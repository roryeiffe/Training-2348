let name = 'jim';

let greeting = `Hello, ${name}`;

let petId = 13;
let url = `http://localhost:8081/pets/${petId}`

console.log(greeting);
console.log(url);

// for ... of
let names = ["luke", "han", "leia", "lando"]
for(const name of names) {
  console.log(name);
}