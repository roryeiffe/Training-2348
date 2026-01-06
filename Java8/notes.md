## Java 8
- A lot of the features we'll talk about in Java 8 don't necessarily provide new functionality but provide "cleaner" ways of performing operations
- IntelliJ, we have to set our language level to 8 or higher
  - File -> Project Structure -> Project
  - Click on the drop-down menu Language Level and select anything 8 or higher

### Lambda Expressions
- Includes parameters and some expression
#### Variations
- parameter -> expression
  - take in a single parameter and return a value (whatever the expression evaluates to)
- (parameter1, parameter2, ...) -> expression
  - take in multiple parameters and return a value
- (parameter1, parameter2, ...) -> {code}
  - Takes in 1 or more parameters, and instead of evaluating a single expression, it runs the block of code
- Lamba Expressions are similar to methods in that they represent some input/output/code but they aren't really useful on their own until we look into Functional Interfaces
### Functional Interfaces
- An interface with a single abstract method
- We can use Functional Interfaces to store lambda expressions
- Built-In Functional Interfaces
  - Consumer - takes in a single value and doesn't return anything
    - take in a value and print it out
  - Predicate - takes in a single value and returns a boolean
    - check if a number is even
  - Function - take in a single value and return a single value
    - square/cube function
  - Supplier - not take in a value but will return a value
    - return a random number
  - Bi-versions of the first 3:
    - BiConsumer - takes in 2 values, returns nothing
    - BiPredicate - takes in 2 values, returns a boolean
    - BiFunction - takes in 2 values, returns a value
