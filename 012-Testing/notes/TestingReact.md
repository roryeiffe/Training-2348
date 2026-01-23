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

## Setup and Running
- Just make sure we are in the same directory as our package.json (root directory)

1. Install Jest, the rest-runner:
```npm install --save-dev jest jest-environment-jsdom```

2. Install React Testing Library:
```npm install --save-dev @testing-library/react @testing-library/jest-dom```

3. Install user interaction helpers:
```npm install --save-dev @testing-library/user-event```

4. Install Types (because we're using TypeScript)
```npm install --save-dev @types/jest```

5. Add a test script to package.json:
```json
{
  "scripts": {
    "test": "jest"
  }
}
```

6. Run tests with `npm test`

## Ensuring JSX/TSX can be tested:
- By default, Jest might not know how to work with JSX/TSX. We can install and configure babel (JS compiler) to understand JSX
1. Run ```npm install --save-dev @babel/preset-env @babel/preset-react babel-jest```
2. Run ```npm install --save-dev @babel/preset-typescript```
3. Add a file "babel.config.js" at the project root and add the following:
```js
module.exports = {
  presets: [
    ["@babel/preset-env", { targets: { node: "current" } }],
    ["@babel/preset-react", { runtime: "automatic" }],
  ],
};

module.exports = {
  presets: [
    ["@babel/preset-env", { targets: { node: "current" } }],
    ["@babel/preset-react", { runtime: "automatic" }],
    "@babel/preset-typescript",
  ],
};
```
4. Now, configure JEST to use babel by creating a file jest.config.js and add the following:
```js
module.exports = {
  testEnvironment: "jsdom",
  transform: {
    "^.+\\.(ts|tsx|js|jsx)$": "babel-jest",
  },
  setupFilesAfterEnv: ["<rootDir>/src/setupTests.ts"],
};
```

### Fix for Cannot read properties of undefined (reading 'testEnvironmentOptions')
- This can happen if your core jest package and jest-environment-jsdom are mismatched in terms of versions. We can explicitly specify the version to fix this:
```
npm remove jest jest-environment-jsdom babel-jest
npm install --save-dev jest@29.7.0 jest-environment-jsdom@29.7.0 babel-jest@29.7.0
```