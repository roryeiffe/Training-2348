## TypeScript
- A typed superset of JavaScript
- It is more strict than JS which requires more work from us initially because we have to declare types for our variables
  - In the long run, it will make our projects more readable, cleaner, intuitive

### Installing and Running
- To install, we type 'npm install -g typescript'
- Create a file with a .ts extension
  - We could write plain JS or we can write TS
- Transpile to JS (tsc name-of-file.ts)
- Convert the TS to JS file
- Then, run with node (node name-of-file.js)

### Typing Primitives:
- In JS, we use let, const, var to declare variables but didn't give a type
- Still using let,const,var but we can also declare the type:
```ts
let n:number = 4; // this would prevent us from assigning a different type value later on
```
- We can also specify the type for an array
```ts
let names:string[] = ["luke", "han", "leia"] // prevents us from adding a number to the array
```

### Interfaces
- Use interfaces to define a custom structure for our objects
- We specify what fields the object will have and the types of those fields
```ts
interface PetI {
  id: number,
  name: string,
  food: string
}

let pet:PetI = {
  id: 1,
  name: 'Smeagol',
  food: 'chicken'
}
```

### Types
- Types also let us define structure for our objects
```ts
type Employee = {employeeId: number, employeeName: string}
```

### Types vs Interfaces
- Interfaces are extendable and better suited for public APIs
- Types are most flexible and can represent union, intersections, primitives


### Enums
Enums let us store a fixed set of constants. Can help make code more readable.

```ts
enum Direction {
  Up,
  Down,
  Left,
  Right
}
```

### Tuples
Tuples are fixed-length arrays where each position in the array has a specific type. The order of the values matters. 
```ts
let user: [string,number] = ["Sam", 25];
```

More structured than typical arrays but less flexible.

### Functions

With TypeScript, we can now assign types to our inputs/outputs for our functions. That way, when we pass in arguments, we will be warned if the types don't match. 

```ts
function add(a: number, b: number): number {
  return a + b;
}
```

### Union Types |
- Union Types allow a value to be one of several types. 

```ts
let message: string | number;

// custom type indicates that the ID should be a string/number. So we if apply this type to a variable, it will be as if we typed it as string | number
type ID = string | number;
let x:ID = 4;
x = 'cat';
```

### Intersection Types &
- Require a value to adhere to multiple types/restrictions:

```ts
type Person = {name: string};
type Employee = Person & {employeeId: number}
```

### ? and !
- ? makes a parameter in the interface optional, so we don't need to declare that when we assign a value
  - we can use this for id because we might not know the id before it is sent to the database
- ! - guaranteeing that the variable isn't null/undefined, telling the compiler not to worry about it
  - Make sure you're sure that the variable is valid

### Type Inference & Type Narrowing
- TypeScript can infer types based on values. Type narrowing refines a type using checks like typeof
```ts
function print(value: string | number) {
  if(typeof value === 'string') {
    console.log("Your string is " + value);
  }
  else {
    console.log("your number is " + value);
  }
}
```

### Special Types
- any - means that any structure will be allowed
  - Only use it if you have to, undoes some of the benefits of TypeScript
