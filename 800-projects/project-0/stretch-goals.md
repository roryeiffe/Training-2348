## Rules Regarding Stretch Goals
- The MVP should be your priority
  - Please do not tackle any stretch goals until the project is completely finished
- Prioritized completed goals
  - For example, if you start stretch goal A, recommended to complete A before starting B

## The Stretch Goals

**(For returning associates, please select 1 goal from each category (5 total))**

### Security

* Password hashing + salting (e.g., bcrypt) instead of storing plaintext passwords.
* Account lockout / rate limiting after N failed logins

### Proper Financial Transactions

* Atomic transfers with proper DB transactions (commit/rollback): deposit + withdrawal happen together or not at all.
* Daily limits / rules: e.g., max withdrawal per day, max transfers, etc.

### Better domain modeling

* Support multiple account types (checking/savings) with different rules (min balance, interest, overdraft not allowed, etc.).
* Add account status lifecycle: pending → approved → frozen/closed -> compromised
* Add joint accounts (multiple customers tied to one account with permissions).

### Employee tooling upgrades

* Search/filter transaction logs (by customer, account, date range, type).
* Flag suspicious activity (e.g., many failed logins, many transfers to new accounts, rapid withdrawals).

### Misc:

* Custom exceptions for validation vs database failures, consistent error messaging.
* Export transactions to CSV for an account or customer.