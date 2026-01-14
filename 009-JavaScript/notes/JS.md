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

### Classes and OOP
- JS allows us to create classes as of ES6
  - Conceptually similar to Java where we define the class/structure we want to create
- Inheritance
- Normally, we saw we could create objects using JS notation
```js
{
  field: value,
  field: {
    nestedField: value
  }
}
```
- this keyword - work similar to Java, lets us access instance properties
With classes:
```js
class Animal {
    constructor(name, legs) {
        // this keyword means that we're referring to the object that called this method rather than any other object
        this.name = name;
        this.legs = legs;
    }

    speak() {
        console.log("This animal is speaking.");
    }
}
let animal = new Animal("Smeagol", 4);
```

### Error Handling
- When errors are thrown in JS, we want to be able to catch them and perform some behavior
- We can use try/catch blocks
```js 
try {
  // potentially error-filled code
} catch(error) {
  // whatever you want to happen when the error is caught
}
```
- In addition to console.log, we can use console.error if we want to print an error message

## Truthy and Falsey Values
- A lot of values in JS, even if they're not booleans, can be evaluated as true/false
- If a value is truthy, it will be evaluated as true (ex: in an if statement)
  - Falsey values are the opposite
- The falsey values in JS
  - null
  - undefined
  - ""
  - false
  - 0
  - NaN
- Note that the empty object {} is truthy

## Spread/Rest Operators
- Similar functionality but used in different contexts
- Both are related to the "unraveling" an object/array
- spread - take an array/object and "spread out" the elements
- a = [1,2,3]
  - ...a -> 1,2,3
- rest - take N parameters in a function, store them as an array to be used within the function
  - This should be the last argument and should only be only 1


## Hoisting
- Imagine we have a script in an HTML page 
- We declare a variable with var
- For one reason or another, we try to use the variable before it is defined
```html
<script>
  x = "cat";
  console.log(x);
  var x;
</script>
```
- variables declared with var will be hoisted to the top to avoid issues like this

## Strict Mode
- With strict mode enabled, we will be warned if we do certain things in our code that would normally be ignored:
  - access a variable declared with var before it was declared
  - using reserved words as variable names
  - duplicate property/param names
  - assigning values to read-only properties
  - delete an undeleteable property
- https://www.w3schools.com/js/js_strict.asp 
- To enable strict mode, we can include the following line:
```html
<script>
'use strict';
</script>
```

## ES6
- EcmaScript 6
- 2015
- Introduced a lot of new features to JS
  - let,const keywords
  - classes
  - default parameters
  - arrow functions
  - spread and rest operators
  - template literals
  - for of loop - handy way to iterate through an array of items