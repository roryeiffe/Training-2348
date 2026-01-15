let s:string = 'hello world'

console.log(s);

// s = 5;

let names:string[] = ['tom', 'jerry']
console.log(names);

// names.push(true);

interface PetI {
  id?: number,
  name: string,
  food: string
}

let pet:PetI = {
  id: 1,
  name: 'smeagol',
  food: 'chicken'
}

let pet3: PetI = {
  name: 'gollum',
  food: 'chicken'
}

console.log(pet);


let t:any = {
  name: 'john',
  pets : [
    {
      name: 'Garfield',
      food: 'lasagna'
    }
  ]
}