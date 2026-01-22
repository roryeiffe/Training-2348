// this function will return its own parameter:
// specify that the input type and the output type are the same
// What that type is will be determined when the function is invoked:
function identity<T>(value:T):T {
  return value;
}

// Explicitly set the type:
let s: string = identity<string>("cat");

// Params and return type must match the type we specify:
// let s2: string = identity<string>(4);
// let s3: number = identity<string>(4);

// Even if we don't specify the type, can be inferred
let s4:string = identity("dog");