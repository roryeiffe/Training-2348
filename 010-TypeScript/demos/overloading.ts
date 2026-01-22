// multiple ways to call this function but only one implementation
function format(value: string):string;
function format(value: number):string;
function format(value: string | number): string {
  return value.toString();
}

console.log(format("hello"));
console.log(typeof format("hello"));
console.log(format(5));
console.log(typeof format(5));
