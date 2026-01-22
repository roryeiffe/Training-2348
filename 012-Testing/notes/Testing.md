## Testing
- Writing code that executes some of our main application code and evaluates the results against some expected/desired behavior
- Successful tests indicate that the application is working as intended
- Helps find bugs in the code
- Improves maintainability
- A well-written test
  - includes documentation
  - modular
  - improves stability

## Unit Testing
- Testing small, isolated pieces of code (typically methods/functions)
- Focus on one specific behavior
- Runs quickly because it is testing one specific part of the code
- Repeatable - will produce the same result each time (assuming the code doesn't change)

## Test-Driven Development
- Tests are written before the code
- Forces us to think about the requirements from the start
- Could help to identify edge cases
- Provide a frame of reference for when we are writing the code
- Can also give you a more streamlined development process
  - Write some code, test, make fixes, test, etc.

## Arrange, Act, Assert
- Arrange - Set up data that we need to test (instantiating an object, etc.) and environment
- Act - invoking/executing the function/method that is being tested
  - store the result in some variable
- Assert - verifying that the actual computed result matches what is expected of the behavior.

## Assertion Types
- Equality - assert that 2 values are equal
- Boolean - check a boolean if true/false
- Null Checks - check if an object is null
- Exceptions - check if an exception is thrown

## Coverage
- When we run tests, certain tools give an overview of what percentage of the code base was covered/tested
- Gives a good idea of how well-tested your code-base is
  - 100% Coverage doesn't mean the app is free of bugs
- Line Coverage - which specific lines were covered
- Branch Coverage - ensuring all paths in control flow are reached (if/else, switch)