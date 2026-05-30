# Task: Contact List with Search and Pagination

## Time: 60 minutes

## Setup

Create a new Android project in Android Studio.

## Requirements

### Part 1 (~25 min)

Build a contacts screen that loads data from a fake API.

**Fake API (implement as a class, not real network):**

```kotlin
class FakeContactsApi {
    private val allContacts = (1..200).map { i ->
        Contact(
            id = "id_$i",
            name = "Contact $i",
            phone = "+44${(1000000..9999999).random()}",
            avatarUrl = ""
        )
    }

    suspend fun getContacts(page: Int, pageSize: Int = 20): ContactsPage {
        delay(800)
        if (Random.nextInt(10) == 0) throw IOException("Network error")
        val start = page * pageSize
        val end = minOf(start + pageSize, allContacts.size)
        if (start >= allContacts.size) return ContactsPage(emptyList(), hasMore = false)
        return ContactsPage(allContacts.subList(start, end), hasMore = end < allContacts.size)
    }
}

data class Contact(val id: String, val name: String, val phone: String, val avatarUrl: String)
data class ContactsPage(val contacts: List<Contact>, val hasMore: Boolean)
```

**UI:**
- RecyclerView with contact rows (name + phone number)
- Loading indicator at the bottom while loading next page
- Error state with "Retry" button

**Architecture:**
- ViewModel + StateFlow
- Pagination: load next page when user scrolls near the bottom
- Show initial loading spinner for first page

### Part 2 — Search (~20 min)

Add a SearchView at the top:
- Filter contacts **locally** from already loaded data
- BUT also trigger a new API call with search query for server-side search:

```kotlin
suspend fun searchContacts(query: String): List<Contact> {
    delay(500)
    return allContacts.filter {
        it.name.contains(query, ignoreCase = true) ||
        it.phone.contains(query)
    }
}
```

- Use debounce (300ms)
- Show local results immediately, then replace with server results when they arrive
- Handle: user types "Jo", waits, results load. Then types "John" — cancel previous search

Hint: flatMapLatest

### Part 3 — Selection Mode (~10 min)

Long press a contact to enter selection mode:
- Show checkboxes on each row
- Toolbar changes to "X selected" with a "Delete" action
- Tap contact in selection mode toggles selection
- Back press or toolbar X exits selection mode

### Write Tests

- ViewModel test: pagination loads pages correctly
- ViewModel test: search debounce and cancellation
- ViewModel test: selection mode state management

## Follow-up Questions

- "How do you prevent memory leaks with the scroll listener?"
- "What happens if the user scrolls fast and triggers multiple page loads?"
- "How would you cache contacts offline? (Room)"
- "RecyclerView.ViewHolder recycling — what bugs can it cause with checkboxes?"
