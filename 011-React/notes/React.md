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
- If we explicitly set up the type for our props, we can include that in function declaration
```ts
type HelloWorldProps = {
  message: string,
  author?: string,
}
export default function HelloWorld({message, author}: HelloWorldProps)
```
- React.FC is a generic type for React function components
  - FC = Functional Component
  - In past versions, would implicitly include children in prop type so we wouldn't have to configure that ourselves
  - 

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

## React Router
- Up until now, we've been rendering all of our components directly in App.tsx
```tsx
function App() {
  return (
    <div>
      <HelloWorldComponent message ="hello world" author = "Dr. Suess" />
      <HelloWorldComponent message ="hello world" />
      <Hooks />
      <EventExample />
      <ControlledComponent />
      <UncontrolledComponent />      
    </div>
  );
}
```
- Manually commenting/uncommenting kind of works for small demos but definitely not scalable/automatic
- React Router is a dependency that will allow us to configure routes and corresponding components
  - ex: If I go to localhost:3000/form -> display a form component
  - localhost:3000/pets/5 -> Render the pet component and programmatically utilize the number 5 that was passed in




### Install
- From your command line, at the root level of the React project, we can run ```npm install react-router-dom```
### Tags/Features
- BrowserRouter - wrapper tag that must wrap around everything related to Routing, otherwise routing will not work
- Routes - wrapper tag that wraps around all of the Route components (this goes inside of BrowserRouter)
- Route - represents an individual route, lets us specify the path and corresponding component
- Link - represents a clickable element, can specify which react-router route to take
  - This is different from passing an href

### Basic Structure:
```tsx
<BrowserRouter>
  <Routes>
    <Route path="/" element={<HelloWorldComponent message='Welcome to React!'/>}></Route>
    <Route path = "/hooks" element={<Hooks/>}/>
    <Route path = "/events" element={<EventExample/>}/>
    <Route path = "/controlled" element={<ControlledComponent/>}/>
    <Route path = "/uncontrolled" element={<UncontrolledComponent/>}/>
  </Routes>

</BrowserRouter>

```

### Navbar:
```tsx
import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <nav>
      <ul>
        <li>
          <Link to='/'>Welcome</Link>
        </li>
        <li>
          <Link to='/hooks'>Hooks</Link>
        </li>
      </ul>
    </nav>
  )
}
```
- We want to render the Navbar within BrowserRouter so it has routing functionality but outside of Routes because we want the Navbar to exist on every page.

### Extracting Values from the Path
- useParams can be imported from react-router-dom and invoked to retrieve information from the path
- Will return an object from which we can extract the variables
- For this to work, we need to configure our route to take in a dynamic value
```tsx
<Route path = "/component:val" element = {<Component/>} >
```

### Manually/Programatically Redirect
- We've already seen <Link> elements which are clickable
- We can utilize the useNavigate hook to specify a path to redirect to in our code
- useNavigate() returns a function that is used to navigate

### Nested Routes
- We can define nested routes by placing Route tags within another Route tag
- Useful for swapping information out on a single page
- Make use of a special tag <Outlet> which renders child Route based on the path
```tsx
<Route path="/dashboard" element={<AppLayout />}>
  <Route index element={<DashboardHome />} />
  <Route path="settings" element={<DashboardSettings />} />
</Route>
  ```

### Route Guards
- Some pages on our website are restricted to users who are logged in/authenticated
  - Route Guards help to check those conditions (authenticated, etc.) and re-routes if you do not meet those conditions
- We can set up nested routes
  - The outer route acts as the router guard, checks authentication state and renders children if valid, redirect otherwise
  - Anything we render inside out of the Route guard will prevent non-authenticated users from navigating to it


## Axios
- Used to consume external APIs (like our Spring back-end)
- Different methods for different HTTP methods (post, put, delete, get)
- Returns a promise
  - We can use .then and .catch to handle the results
  - Or, if we're inside of an async function, we can await the results of the promise and use them directly
- The first argument will be the endpoint (localhost, etc..)
- axios.post and axios.put take in complex objects, so the 2nd argument will be whatever entity/object you're sending

### Installation
- ```npm i axios```

### Styling
- We can apply styling to our components by importing css files:
```import './App.css';```
  - The only downside to this approach is these styles will be applied for all components (even if we don't import them to that particular file). This is good for global styles but not if we want component-specific stylings that we don't any other components to use
- We can create css module files
  - Files end with .module.css
  - These files can be imported into the components and used as classNames
  - If we inspect these class names using chrome devtools, we should see a random string appended to the end of these class names so that they don't conflict with other class names
  - With module.css files, we want to work with classes because if we specify elements, those stylings will be applied globally

## Context API
- Context lets share certain values across many different components without the need to pass them in as props
  - Passing values as props is useful for some situations (when you're dealing with a few components)
  - For certain values, such as authentication state which is used across the app, it is better to use the context API
  - Prop Drilling - bunch of nested components, passing the props from one parent to the next
    - This problem is avoided by using context API
- Use Cases for Context API (Low Frequency Updates, Highly Important State)
  - Authentication State
  - Theme (Light/Dark Mode)
  - User Preferences
- Not a full replacement for something like redux, but useful for its own use cases

### Implementation
- First, we will define the shape of the data we're keeping track of as well as the functions that manipulate it
  - For authentication, keep track of
    - The user object
    - login function
    - logout function
- Then, we set up a Provider which contains all of the logic for updating the state
  - This Provider can take and render children
  - Everything wrapped in the provider will have access to the context

## Custom Hooks
- Is a function we can create in our React application
- While React components are re-usable pieces of UI, custom hooks are reusable logic
- starts with "use"
- Calls one or more built-in hooks (useState, useEffect)
- We can create a useAuth hook that handles the AuthContext and checks for null values


## React Hook Forms
- Dependency we can add to our project, helps us make more reliable forms
- Gives us some tools to work with forms (errors/validation, isSubmitting)
- Works nicely with TypeScript, we can set up the types for the data that the form is collecting
- Install - `npm install react-hook-form`
### Implementation
- Start by defining the type for our data
- Configure which aspects of React Hook Form we want to use (errors, isValid, isSubmitting)
  - For example, we can grey out the submit button if the data isn't valid
  - We can check/validate our data before submitting
- Create the form, utilizing aspects of React Hook Form where applicable
- See what types of features/validation are offered [here](https://react-hook-form.com/docs/useform/register)