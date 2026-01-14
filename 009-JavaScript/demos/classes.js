class Animal {
  constructor(name, legs, sound) {
    this.name = name;
    this.legs = legs;
    this.sound = sound;
  }

  speak() {
    if(!this.sound) console.log("This animal is speaking.");
    else console.log(this.sound);
  }
}

class Cat extends Animal {
  // super() calls the parent constructor:
  constructor(name) {
    super(name, 4, "meow");
  }

  speak() {
    console.log("Meow");
  }
}

let dog = new Animal("Scooby", 4, "Ruh roh");
dog.speak();

let snail = new Animal("Gary", 0, null)
snail.speak();

let cat = new Cat("Gollum");
cat.speak();














// console.log("Hello World");