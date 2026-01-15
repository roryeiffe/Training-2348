function add(a: number, b: number): number {
  return a + b;
}

let result = add(1,2);
console.log(result);

// Types don't match what the function is expecting
// add('s', 't');

// Also need to make sure the output type is correct
// let result2: string = add(4,5);

function print(message: string | number) {
  console.log(message);
}

print("message");
print(23);

interface UserI  {
  id: number,
  name: string,
  email: string
}

let user2: UserI | null = null;

// fill in the fields later