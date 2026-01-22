## Testing React Components
- With Java, our tests are mostly testing logic
  - Does this method return the right value?
  - Was this particular exception thrown?
  - Is this object null?
- React also deals with logic but our tests can also help us answer question:
  - Is the proper content being rendered on the page?
  - Does the page respond as expected to user interactions (button clicks, etc.)
  - Does the page respond to state/prop changes?

## Jest
- A test runner for JS code/projects
- Responsibilities - 
  - Discovering test files in our project
  - Run Tests and reporting success/failures
  - Mocking - fake the output for dependencies

## React Testing Library
- Let us query for the DOM elements
- Provides accessible selectors (by text, by labels, by roles)
- Flow
  - Render the Component in question (Arrange)
  - Query the output/rendered element (Act)
  - Assert the expected behavior/values