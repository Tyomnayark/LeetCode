# Testing — Questions They Ask at Revolut

---

## Unit Testing Basics

**Q: What do you test in a ViewModel?**
- State transitions (Loading → Success → Error)
- Business logic (filtering, validation, calculations)
- Edge cases (empty list, null, boundary values)
- NOT: Android framework, UI rendering, navigation

**Q: What is the testing pyramid?**
- Unit tests (bottom, most) — fast, isolated, test logic
- Integration tests (middle) — test components together
- UI/E2E tests (top, fewest) — slow, test full flow

**Q: What is a mock vs stub vs fake?**
- Stub: returns hardcoded values, no verification
- Mock: records calls, you verify interactions (verify was called N times)
- Fake: working implementation with shortcuts (in-memory DB instead of real one)

---

## Coroutine Testing

**Q: How do you test coroutines?**
```kotlin
@Test
fun test() = runTest {
    // runs coroutines synchronously
    // auto-advances virtual time (delay is instant)
}
```

**Q: Why Dispatchers.setMain(testDispatcher)?**
- ViewModel uses Dispatchers.Main which needs Android Looper
- In tests there is no Looper → crash
- Replace with TestDispatcher before tests, reset after

```kotlin
@Before
fun setup() {
    Dispatchers.setMain(StandardTestDispatcher())
}

@After
fun tearDown() {
    Dispatchers.resetMain()
}
```

**Q: How do you test StateFlow emissions?**
- Use Turbine library:
```kotlin
viewModel.state.test {
    assertEquals(Loading, awaitItem())
    assertEquals(Success(data), awaitItem())
    cancelAndIgnoreRemainingEvents()
}
```

**Q: How do you test debounce / time-dependent code?**
- runTest auto-advances virtual time
- advanceTimeBy(300) to simulate debounce wait
- advanceUntilIdle() to run all pending coroutines

---

## MockK (Kotlin mocking library)

**Q: Basic MockK usage?**
```kotlin
val repo = mockk<Repository>()
every { repo.getData() } returns listOf("a", "b")

val result = repo.getData()

verify { repo.getData() }
assertEquals(listOf("a", "b"), result)
```

**Q: How to mock suspend functions?**
```kotlin
coEvery { repo.fetchData() } returns data
coVerify { repo.fetchData() }
```

**Q: relaxed mock?**
```kotlin
val repo = mockk<Repository>(relaxed = true)
// all methods return default values without setup
// useful when you don't care about some methods
```

**Q: IMPORTANT — declare mocks BEFORE using them!**
```kotlin
// WRONG — will crash
every { repo.getData() } returns data
val repo = mockk<Repository>()

// CORRECT
val repo = mockk<Repository>()
every { repo.getData() } returns data
```
This specific mistake was mentioned as a rejection reason at Revolut.

---

## What Revolut Expects in Tests

**DO:**
- Test ViewModel logic, not Android framework
- Test edge cases and error paths
- Use descriptive test names: `amount exceeding balance should disable send button`
- Structure: Given / When / Then (Arrange / Act / Assert)
- Test concurrency: launch multiple coroutines, verify consistency

**DON'T:**
- Don't test trivial getters/setters
- Don't test framework code (RecyclerView, Fragment lifecycle)
- Don't use Thread.sleep() — use runTest + advanceTimeBy
- Don't forget to reset Dispatchers.Main in @After

---

## Common Test Scenarios at Revolut

1. **Filtering:** given list of transactions, when filter "incoming" selected, then only positive amounts shown
2. **Validation:** given empty amount, when user taps send, then error state is emitted
3. **Network error:** given API throws exception, when loading data, then Error state with message
4. **Debounce:** given user types "a", "ab", "abc" quickly, then API called only once with "abc"
5. **State preservation:** given data loaded, when configuration change, then same data shown (no re-fetch)
