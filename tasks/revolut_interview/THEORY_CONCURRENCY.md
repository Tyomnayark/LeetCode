# Concurrency — Questions They Ask at Revolut

These are oral questions asked during or after the live coding.
Prepare verbal answers, not code.

---

## Kotlin Coroutines

**Q: launch vs async — what's the difference?**
- launch returns Job, fires and forgets, exception crashes parent
- async returns Deferred, stores result, exception thrown on await()

**Q: What is structured concurrency?**
- Child coroutines are tied to parent scope
- If parent is cancelled, all children are cancelled
- If child throws, parent and siblings are cancelled
- coroutineScope waits for all children to finish

**Q: What is SupervisorJob and when do you use it?**
- Child failure does NOT cancel other children or parent
- Used when tasks are independent (e.g. loading profile + loading orders — if orders fail, profile should still show)

**Q: Dispatchers — what are they?**
- Dispatchers.Main — UI thread (Android only)
- Dispatchers.IO — disk/network, large thread pool
- Dispatchers.Default — CPU-heavy work, limited to CPU cores
- Dispatchers.Unconfined — runs in caller's thread until first suspension

**Q: What happens if you do network call on Main dispatcher?**
- NetworkOnMainThreadException (Android blocks it)
- Use withContext(Dispatchers.IO) { } to switch

**Q: How does coroutine cancellation work?**
- Cooperative — code must check isActive or call suspending functions
- delay(), yield(), withContext() are cancellation points
- CPU-heavy loop without checks will NOT cancel
- Use ensureActive() or yield() inside loops

**Q: What is Flow? Hot vs Cold?**
- Flow is cold — starts emitting only when collected
- SharedFlow/StateFlow are hot — emit regardless of collectors
- StateFlow always has a value, replays last value to new collectors

**Q: flatMapLatest — what does it do?**
- When new value arrives, cancels previous inner flow and starts new one
- Perfect for search: new query cancels previous API call

---

## Java Concurrency (they still ask this)

**Q: synchronized — what does it do?**
- Acquires monitor lock on object
- Only one thread can execute synchronized block on same object
- Other threads wait (block)

**Q: volatile — what does it do?**
- Guarantees visibility: changes are immediately visible to all threads
- Does NOT guarantee atomicity (i++ is not atomic even with volatile)

**Q: What is a deadlock? How to prevent?**
- Two threads each hold a lock the other needs
- Prevention: always acquire locks in same order
- Example: transfer(A,B) locks A then B; transfer(B,A) locks B then A → deadlock
- Fix: lock by min(id) first, then max(id)

**Q: What is a race condition?**
- Result depends on timing of thread execution
- Example: two threads do balance++ simultaneously, one increment lost
- Fix: synchronization, atomic operations, or single-threaded access

**Q: AtomicInteger vs synchronized?**
- AtomicInteger: lock-free, uses CAS (compare-and-swap), faster for simple ops
- synchronized: heavier, but allows complex multi-step operations atomically

**Q: What is the Java Memory Model (JMM)?**
- Defines how threads interact through memory
- Without synchronization, threads may see stale values (CPU cache)
- volatile/synchronized/final create "happens-before" relationships

**Q: ReentrantLock vs synchronized?**
- ReentrantLock: tryLock(), timed wait, interruptible, fairness option
- synchronized: simpler syntax, auto-releases on exception
- Use ReentrantLock when you need tryLock or fairness

---

## Android-Specific Concurrency

**Q: How do you prevent memory leaks with coroutines?**
- Use viewModelScope (cancelled when ViewModel cleared)
- Use lifecycleScope (cancelled when lifecycle destroyed)
- Never use GlobalScope in Android
- collectLatest with repeatOnLifecycle for Flow in UI

**Q: What if Activity is destroyed during a network call?**
- viewModelScope: coroutine keeps running, result saved in ViewModel
- On recreation, Activity observes existing StateFlow/LiveData
- lifecycleScope: coroutine is cancelled — use viewModelScope instead

**Q: Handler, Looper, MessageQueue — how does Android threading work?**
- Main thread has a Looper that loops over MessageQueue
- Handler posts Runnables/Messages to the queue
- UI updates must happen on main thread
- Coroutines abstract this away (Dispatchers.Main uses Handler internally)

**Q: What causes ANR (Application Not Responding)?**
- Main thread blocked for >5 seconds
- Heavy work on main thread: network, disk IO, complex computation
- Fix: move to background thread/coroutine

**Q: How do you handle configuration changes (rotation)?**
- ViewModel survives rotation
- StateFlow/LiveData in ViewModel — UI resubscribes after recreation
- SavedStateHandle for process death
