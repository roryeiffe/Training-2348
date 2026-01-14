// spread
let first = [1,2,3,4,5];
let second = [6,7,8,9,10];

// combine the arrays together:
// Not exactly what we want, because this will give us nested arrays:
console.log([first, second])
console.log([...first, ...second])

let o = {
  name: 'ron',
  pet: 'rat'
}

// trying to copy an object without spread operator:
let oCopy1 = {
  o,
  spells: []
}

// using the spread operator:
let oCopy2 = {
  ...o,
  spells: []
}

console.log(oCopy1);
console.log(oCopy2);

// Rest Operator - 
// Take in a param and an array of numbers and sum them up:
function sumNumbers(param1, numbers) {
  let sum = 0; 
  for(let i = 0; i < numbers.length; i ++) {
    sum += numbers[i];
  }
  return sum;
}

// Using the rest operator here means that instead of passing in an array, we
// can pass in the numbers as individual arguments which will then be "collected" into an array to be used
// as normal in the function
function sumNumbersRest(param1, ...numbers) {
  let sum = 0; 
  for(let i = 0; i < numbers.length; i ++) {
    sum += numbers[i];
  }
  return sum;
}

console.log(sumNumbers("cat", [1,2,3,4,5]))
console.log(sumNumbersRest("dog", 11, 12, 13))