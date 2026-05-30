# Task: Transaction History Screen

## Time: 60 minutes

## Setup

Create a new Android project in Android Studio. No templates, no generated code.

## Requirements

### Part 1 (~30 min)

Build a screen that displays a list of financial transactions.

**Data source:** Use the provided hardcoded JSON below (pretend it came from an API).

**Each row displays:**
- Transaction icon (incoming = green arrow, outgoing = red arrow)
- Counterparty name (e.g. "Amazon", "John Smith")
- Date and time (formatted: "15 May 2026, 14:30")
- Amount with currency (e.g. "-€42.99" in red, "+€150.00" in green)

**Architecture:**
- Use ViewModel + LiveData or StateFlow
- RecyclerView with ViewBinding
- DiffUtil for list updates

```json
[
  {"id": "1", "counterparty": "Amazon", "amount": -4299, "currency": "EUR", "timestamp": 1747312200000, "type": "CARD_PAYMENT"},
  {"id": "2", "counterparty": "John Smith", "amount": 15000, "currency": "EUR", "timestamp": 1747225800000, "type": "TRANSFER_IN"},
  {"id": "3", "counterparty": "Netflix", "amount": -1599, "currency": "EUR", "timestamp": 1747139400000, "type": "CARD_PAYMENT"},
  {"id": "4", "counterparty": "Salary", "amount": 350000, "currency": "EUR", "timestamp": 1747053000000, "type": "TRANSFER_IN"},
  {"id": "5", "counterparty": "Uber", "amount": -1250, "currency": "EUR", "timestamp": 1746966600000, "type": "CARD_PAYMENT"},
  {"id": "6", "counterparty": "Maria Garcia", "amount": -5000, "currency": "EUR", "timestamp": 1746880200000, "type": "TRANSFER_OUT"},
  {"id": "7", "counterparty": "Revolut Exchange", "amount": -20000, "currency": "EUR", "timestamp": 1746793800000, "type": "EXCHANGE"},
  {"id": "8", "counterparty": "Revolut Exchange", "amount": 17245, "currency": "GBP", "timestamp": 1746793800000, "type": "EXCHANGE"}
]
```

Note: amounts are in cents (4299 = €42.99).

### Part 2 — Filter & Search (~15 min)

Add a search bar (EditText or SearchView) at the top:
- Filter transactions by counterparty name as user types
- Use debounce (300ms) to avoid filtering on every keystroke
- Show "No results" if filter matches nothing

Add filter chips below the search bar:
- "All", "Incoming", "Outgoing", "Card Payments"
- Chips and search work together (e.g. search "Amazon" + "Card Payments")

### Part 3 — Pull to Refresh (~10 min)

Add SwipeRefreshLayout:
- On pull, simulate a network call (delay 1 second)
- Add a new random transaction at the top of the list
- Smooth animation via DiffUtil (no notifyDataSetChanged!)

### Write Tests

- ViewModel test: verify filtering logic
- ViewModel test: verify search + filter combination

## Follow-up Questions

- "Why DiffUtil instead of notifyDataSetChanged?"
- "How would you paginate this list for 10,000 transactions?"
- "How would you group transactions by date (sticky headers)?"
- "What happens to the search query on screen rotation?"
