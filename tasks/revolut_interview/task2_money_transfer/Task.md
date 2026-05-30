# Task: Money Transfer Screen

## Time: 60 minutes

## Setup

Create a new Android project in Android Studio.

## Requirements

### Part 1 (~30 min)

Build a "Send Money" screen with the following UI (use Views/XML, NOT Compose):

**Screen layout (top to bottom):**
1. Recipient selector — a horizontal RecyclerView of contacts (circle avatar + name)
2. Amount input — large centered EditText, inputType=numberDecimal
3. Currency selector — a spinner or button showing "EUR", tap to change
4. "Send" button at the bottom

**Behavior:**
- User selects a recipient from the horizontal list
- Types an amount
- Selects currency (EUR, GBP, USD)
- Taps "Send"

**Validation (show errors inline, not as toasts):**
- Amount must be > 0
- Amount must not exceed balance (hardcode balance = 1000.00 EUR)
- Recipient must be selected
- "Send" button disabled until all valid

**Architecture:**
- ViewModel holding: selectedRecipient, amount, currency, validationState
- Observe state from Activity/Fragment, update UI

**Hardcoded contacts:**
```
John Smith, Maria Garcia, Alex Johnson, Emma Wilson, James Brown
```

### Part 2 — Confirm Dialog (~15 min)

Before sending, show a confirmation dialog:
```
Send 42.99 EUR to John Smith?
[Cancel] [Confirm]
```

On confirm:
- Show loading state (disable button, show progress)
- Simulate network call (delay 2 seconds)
- Show success screen or error

On error (simulate randomly ~20% of the time):
- Show retry option
- Preserve all entered data

### Part 3 — Exchange Rate (~10 min)

If sender's currency (EUR) differs from a hypothetical recipient currency:
- Show exchange rate below amount: "1 EUR = 0.87 GBP"
- Show converted amount: "John will receive 37.40 GBP"
- Hardcode rates: EUR->GBP=0.87, EUR->USD=1.16

### Write Tests

- ViewModel test: validation states (empty amount, exceeds balance, no recipient)
- ViewModel test: state after successful/failed send

## Follow-up Questions

- "How would you prevent double-tap on the Send button?"
- "How would you implement idempotency for this payment?"
- "What happens if the user rotates the screen during the network call?"
- "How would you handle back press during loading state?"
