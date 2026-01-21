# HTML-CSS Practice Questions 
1. What is HTML
2. What is the structure of an HTML document? List some tags. What is `<head>` used for? `<body>`?
4. What is the tag for an ordered list? Unordered list?
5. What are some HTML5 tags? Why were HTML5 tags introduced?
6. Do all tags come in a pair? What are the other things inside tags called? list some.
7. What is the syntax for a comment in HTML?
8. Give me the HTML markup for a table.
9. What are some tags you would use in a form?
10. What is CSS? what are the different ways of styling an HTML file? Which is best? why?
11. Describe the CSS box model.
12. Which way has highest priority when styles cascade: inline, internal, and external.
13. Syntax for styling an element? What is a class and how to style them? What is an id? how to style? difference?
14. What if I want to select child elements, What syntax is that?
15. Can I select multiple elements at once? How?
16. What is a psuedo-class? What is syntax for selecting that?

# JS Practice Questions

- What is JavaScript? What do we use it for?
- Can we run JavaScript in a web browser, on a server, or both?
- What are the benefits of JS over your core language? Drawbacks?
- What programming paradigm(s) does JS support?
- What are the data types in JS?
- What is the type of NaN? What is the isNaN function?
- What is the data type of a function?
- What about an array?
- What is the difference between undefined and null?
- What are JS objects? what is the syntax?
- Use the object literal syntax to create an object with some properties
- What are arrays in JS? can you change their size?
- List some array methods and explain how they work.
- What is JSON? Is it different from JS objects?
- What are some ways you can use functions in JS?
- What are the different scopes of variables in JS?
    - What are the different ways to declare global variables?
    - Is it a best practice to use global variables? Why or why not?
- What are some methods on the function prototype?
- If you declare a variable `var` inside a for loop is that block scoped or function scoped?
- If you declare a variable `let` inside a for loop is that block scoped or function scoped?
- What will happen?
```javascript
const hi;
hi = 3;
console.log(hi);
```
- What are callback functions?
- What is a truthy or falsy value? List the falsy values.
- What prints?:
```javascript
let x = 5;
while(x) {
  x--;
  console.log(x);
}
```
- What is the difference between == and ===? Which one allows for type coercion?
- What is the difference between `for of` and `for in`?
- What does the following code do?
```javascript
function addOne(value) {
    value + 1;
}
let x = 5;
addOne(x);
console.log(x);
```
What about this?
```javascript
function changeUsername(user) {
    user.username = 'new-username';
}

let user = {
    username: 'first-username'
};
changeUsername(user);
console.log(user.username);
```
Why?

- What is the difference between a do-while and a while loop?
- What does this do?
```javascript
for(;;){
    console.log('a');
}
```
- Explain what “strict mode” does   
- What are the naming conventions for a variable used in JavaScript?
- What are the naming conventions for a function used in JavaScript?
- What is function and variable hoisting?
- What does the "this" keyword refer to?
- Explain how inheritance works in JS
- What is the difference between `setInterval()` and `setTimeout()`?
    - How would you stop a `setInterval()` once it has been set?
    - Advanced: How do they work with regards to the callback queue?
- How would you handle an error in JS?
- What attributes does an Error object have?
- What is the difference between var, let, and const keywords?
- How would we rewrite this code with a template literal?
```JavaScript
let n = 'Dorian';
let message = 'My name is '+n;
console.log(message);
```
- What’s the difference between a normal function declaration and an arrow function?
- How would you set default values for parameters to a function?
- Explain the async/await keywords. Why is it preferred to use this instead of .then() methods?
- How do you interact with a Promise? When would it be appropriate to use a Promise?
- Write a method that would print to the console the value returned by the promise?
```JavaScript
function helloPromise() {
  let p = new Promise();

  setTimeout(p.resolve(`Hello World`), 500);

  return p;
}
```
- What is object and array destructuring? Give me an example using the rest/spread operator?

## DOM Manipulation

- Explain the following code:
```javascript
document.getElementById("myid").addEventListener('click', (e) => {
  e.stopPropagation();
});
```
- What is the global object in client-side JavaScript? What are some built-in functions on this object?
- What is the DOM? How is it represented as a data structure? What object in a browser environment allows us to interact with the DOM?
- List some ways of querying the DOM for elements
- How would you insert a new element into the DOM?
- What are event listeners? What are some events we can listen for? What are some different ways of setting event listeners?
- What is bubbling and capturing and what is the difference?
- What are some methods on the event object and what do they do?
- Why is `Hello` not visible on the page after calling this function?

```JavaScript
function addElementToBody() {
  let body = document.getElementsByTagName('body');
  body.innerHTML = '<p>Hello</p>';
}
```
- What is the Fetch API?
- How do you send a Fetch request?
- How would you retreive JSON data from a Fetch request?
- How do you handle a failed request in Fetch?

# TypeScript Practice Questions
* What problem was TypeScript created to solve?
* What does the TypeScript compiler (`tsc`) do?
* What happens to TypeScript-specific syntax after compilation?
* Why might a large codebase benefit more from TypeScript than a small script?
* What are the key differences between TypeScript and JavaScript?
* Is every JavaScript program valid TypeScript? Why or why not?
* What are the primitive types supported by TypeScript?
* When should you avoid using `any`?
* What does the `void` type represent?
* How do you type an array in TypeScript?
* What is a tuple, and how is it different from an array?
* What is an enum, and why might you use one?
* How do you explicitly define a function’s return type?
* What happens if you omit a return type?
* What is an interface in TypeScript?
* How is a type alias different from an interface?
* When would you prefer an interface over a type?
* What is a union type?
* How does a union type differ from an intersection type?
* What is a type alias?
* How do type aliases improve code readability?
* Can a type alias represent primitives, objects, and functions?
* What is type narrowing?
* How does `typeof` act as a type guard?
* What problem do generics solve in TypeScript?
* How do you declare a generic type parameter?
* What are utility types in TypeScript?
* What does the `Partial<T>` utility type do?
* How does `Pick<T, K>` differ from `Omit<T, K>`?
* Why are utility types often preferred over redefining interfaces?
* How do classes in TypeScript differ from classes in JavaScript?
* How do access modifiers (`public`, `private`, `protected`) work?
* What is the purpose of a constructor?
* How does inheritance work using the `extends` keyword?
* What does the `super` keyword do?
* How do you define a function type explicitly?
* What is function overloading in TypeScript?