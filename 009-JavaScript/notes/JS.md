## JavaScript
- Write scripts including logic, variables, etc.
- How we add logic to our webpages
- JavaScript can be in browsers
  - If we create an HTML page, we can include a "script" tag and include JS code inside
  - The scripts will go in the body, as opposed to the head
- We can also run JS programs using Node.JS outside of the browser

## Data Types in JS:
- String
- Number - whole numbers, decimals, etc.
- Boolean
- Undefined - if the value itself is not defined yet
- Null - has a value but that value is null (ex: a null pet object)
- Object - more complex data types including fields
  - Arrays are represents as objects in JS
- Symbol

## How to create variables
- var - the initial keyword used to define variables, function-scoped, declaring a variable with var inside of a function means it cannot be used outside
- let (introduced in ES6) - block-scoped, meaning that variables defined in a block/function with "let" cannot be accessed outside
- const (introduced in ES6) - block-scoped, meaning that variables defined in a block/function with "let" cannot be accessed outside, cannot change the value

### Scopes
- Global - whenever we define a variable at the outer-most scope, we consider it "global"
  - We can declare a globally-scoped variable with any of var,let,const
- Function Scope - variable declared within a function, can't access the value of the function it was defined in
- Block Scope - for, if - for let/const, variables defined in a block cannot be accessed outside of the block

### Equality Checking
- When comparing 2 values for equality in JS, we can use == or ===
  - == compare values but not type (4 == "4") -- type coercion, because one type is coerced into the other 
  - === compare values and type - checks the value and type

### Printing Output
- console.log("Hello World");
  - If running in the browser, we will see the output in the console tab in our browser's developer tools
  - If running a JS script using Node, we will see the output in the terminal from which we ran the script

### Functions
- Like in Java, functions can be used to repeatedly call a certain set of code
- Can include parameters and return values
  - With JS, don't need to specify return/parameter types
- Callback Functions - we can pass in a function as a variable
- Arrow Functions - shorter syntax we can use to define functions
  - Pretty similar to syntax with lambda expressions in Java 8


#### Default Parameter
- We can include a default value for a particular parameter in our function
```js
function print_number(n = 6) {
  console.log(n);
}
// both of these will work, the latter will take the default value:
print_number(5);
print_number();
```


### Arrays
- 0-index based, access elements with brackets
- We can store multiple values
- Arrays are dynamically sized and contain many useful methods
- We can access the length with array.length
- Methods
  - push - push a value to the array
  - filter - takes in an arrow function which defines the behavior to filter the array by
  - map - takes in an arrow function and applies that function to each element
  - sort - sorts the data, can take in an arrow function to  specify the ordering (useful for objects that don't have a defined order)

### Template Literals
- A cleaner way of injecting values into a string
```js
let name = "Mike";
// The following statements will print the same thing:
console.log("Hello " + name)
console.log(`Hello ${name}`)
```