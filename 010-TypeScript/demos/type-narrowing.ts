function print4(value: string | number) {
  if(typeof value === 'string') {
    console.log("Your string is " + value);
  }
  else {
    console.log("your number is " + value);
  }

}

print4("hello");

print4(5);