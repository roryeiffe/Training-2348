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