## Async JS
- With front-end websites, we have multiple processes going at once (fetching data, loading assets, etc.)
- These operations take time so we can employ asynchronous programming to ensure the website doesn't get held up at every bottleneck

### Promises
- We use promises to handle asynchronous requests in JS
- We can manually create promises and specify values to return upon success/failure
  - We pass in callback functions to define the behavior
- When we execute the promise, we can use .then to specify actions to take assuming the request was successful
- We can use .catch to specify actions upon failure
- The Fetch API will also return promises from which we can define the behavior that will happen when it finishes

### Fetch API
- The Fetch API is used to receive data via HTTP GET request
- Fetch returns a promise from which we can specify what to do with the data using .then
- We can specify what happens when the success is a failure
- The .then function will take an arrow function which contains a parameter with our data/response
- We usually parse it using response.json()
- Once the data is in JSON form (as opposed to String), we can interact it like it's a JS object

### async/await keywords
- async - we can apply this keyword to a function, make the function asynchronous meaning it returns a promise
- await - only valid inside of async functions, indicates that we want to wait until the promise is finished before moving on
  - As opposed to the traditional .then() which only specifies what to do when the promise finishes and then moves on