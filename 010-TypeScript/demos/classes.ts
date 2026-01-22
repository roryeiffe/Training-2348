class Animal {
  constructor(public name: string) {  }

  speak() {
    console.log("This animal is speaking");
  }
}

class Dog extends Animal {
  speak() {
    // use the name field that we inherit and specify that 
    // the dog is barking
    console.log(`${this.name} is barking`)
  }
}

let dog:Dog = new Dog("Scooby Doo");
console.log(dog.name);
dog.speak();

let cat:Animal = new Animal("Garfield");
console.log(cat.name);
cat.speak();
