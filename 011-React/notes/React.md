## React
- Library that lets us build Single-Page component-based applications
- Component Based - 
  - Each component is going to serve a specific purpose
  - Logic - handling user events (click), fetching data
  - Visual - showing off data
  - ex: ButtonComponent, FormComponent
- Single Page -
  - Loads everything at once, React dynamically renders the page using a virtual dom
  - We can look at the url in our browser and see that we can render different components while still being at the same "location"

### JSX and TSX
- JSX - syntax extension that lets us write HTML-like code within JS
```jsx
const element = <h1>Hello World</h1>
```
- When we create components in React, they are represented by functions
  - the functions will return the jsx to be displayed
- TSX is similar but allows for typing
```tsx
type Props = {
  name: string
}

const Greeting = ({name}: Props) => {
  return <h1>Hello, {name}</h1>
}
```

### Installing React:
- Should have Node installed
- We also want to install create-react-app
  - npm install -g create-react-app
- To create an app, 
  - npx create-react-app app-name --template typescript

### Run the application
- to run the app, cd into the directory
  - npm start
  - navigate to localhost:3000 in the browser

### Structure of React App
- index.tsx - starting point, renders the App component
- App.tsx - the main component in which everything will be rendered

### Node Project Files/Folders
- package.json - not specific to React
  - included in all Node projects
  - contain meta-data (name, dependencies, version, etc.)
  - when we install node dependencies, (ex: npm i axios), the package.json will be updated accordingly
    - Alternatively, if we change the package.json (add a dependency) and then run `npm install`, then the dependencies will be pulled in automatically
- package-lock.json - auto-generated based on the package.json
  - We don't need to modify this
- node_modules
  - contains the code for the dependencies we used for our project
  - We don't want to modify this manually 
  - We also don't want to push this folder up to Github
    - Luckily, the node_modules folder is included in the .gitignore by default

### Importing Exporting Components
- If we use `export default`, we can rename how we want when we import it to another component
  - `import HelloWorldComponent from './components/HelloWorld';`
- Otherwise, we have to specify the exact name and wrap it in {}
  - ex: `import {HelloWorld} from '/components/HelloWorld'`

### Components
- Components are reusable pieces of the website (include logic and view)
- In the past, React components were made with classes and functions
  - Classes used to be favored because of their extended capabilities (ex: managing state)
  - Since the introduction of hooks, we can achieve that same functionality with functions and with cleaner syntax
- With functional components:
  - We can pass in props (input)
  - We can set up logic in the function body (managing state, making API calls, setting up data)
  - Return tsx which will be displayed in the browser
- VSCode shortcut - 'rfc' + enter, will create a new,empty function
#### Typing Props
- If we expliticlty set up the type for our props, we can include that in function declaration
```ts
type HelloWorldProps = {
  message: string,
  author?: string,
}
export default function HelloWorld({message, author}: HelloWorldProps)
```
- React.FC is a generic type for React function components
  - Can use this without having to create a separate inerface/type
  - FC = Functional Component

### Hooks
- Hooks are features of React that provide us with additional functionality

#### useState
- Lets us manage state in React
- The type of state can be inferred
- syntax:
```ts
const [count, setCount] = useState(0)

// invoke the function to change state:
setCount(10);

return (
  <div>
  // Render the state value (view should update every time the state changes)
    <p>{count}</p>
  </div>
)
```
- the tuple stores the state variable itself and the function which is used to set the state
- The useState hook takes in the starting value

#### useEffect
- Useful when we have potential side effects (interacting with anything outside of the React ecosystem (API, direct updates to DOM))
- Takes in 2 main parameters
  - Callback function to be executed
    - This will contain the side-effects
    - We will be putting logic to make API calls here
  - Dependency Array - includes the values which will trigger the useEffect function to run if changed. 
    - If no dependency array is passed, the useEffect will run whenever React commits changes to the DOM
    - If an empty dependency array is passed, the effect will run once when the component first loads
    - If we pass a single value to the dependency array, then the useEffect will re-run whenever that particular variable is changed
  
#### useRef
- useRef holds a mutable value that persists across renders without triggering re-renders. Used to reference dom elements
  - values managed by useRef hook can be accessed with .current

#### useMemo
- useMemo memoizes a computed value, recalculate when dependencies. Helps to avoid recalculations, especially those that are time-intensive

#### useCallback
- useCallback memoizes a function reference, preventing unnecessary re-creations across renders. Typically used when passing callback functions to child components

### Handling DOM Events in React with TypeScript
- We have React-specific Event types that we can use to specify the types of events that we're going to be triggering

#### Common Event Types

##### MouseEvent
- Used for mouse interactions (clicking, hovering)

```tsx
function handleClick(event:React.MouseEvent<HTMLButtonElement>) {
  console.log(event);
}

```

##### ChangeEvent
- Commonly used for when inputs change their value
```tsx
function handleChange(event:React.ChangeEvent<HTMLInputElement>) {
  console.log(event.target.value);
  // guess what the user typing 
}
```

##### FormEvent
- Used for submitting forms, validating data
```tsx
function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
  // prevent page refresh, let us handle the submission behavior
  event.preventDefault();
}
```

## Controlled vs Uncontrolled Components

### Controlled Components
Controlled Components store values in React state. The component fully controls the input's value. Typically we will use useState to manage the fields and update them based on the events that occur on the page. 

- Predictable State
- Easy Validation 

### Uncontrolled Components
Rely more directly on the DOM itself to manage state. Typically accessed with refs. 

- We don't have as much control
- Less boilerplate code to set up
- Useful for simple or legacy form