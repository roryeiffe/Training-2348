// first, define a promise
let promise1 = new Promise((resolve, reject) => {
  // hard-coding the success state of the request
  // typically, this part of the code might take a while
  // and could either finish successfully or not
  let success = true;

  if(success) {
    resolve("Success! Here is your data: " + {name: "steve"})
  }
  else {
    reject("There was an error with your request!");
  }
})


// invoke the .then() .catch() to specify the behavior upon completion
promise1.then((message) => {
  console.log(message)
  // handle the data
})
.catch((errorMsg) => console.error(errorMsg));