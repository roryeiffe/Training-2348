// create an object
let student = {
  name: 'Harry',
  pet: 'Hedwig',
  house: 'Gryffindor',
  spells: ['wingardium leviosa', 'stupefy']
}

console.log(student.spells);

// imagine we got this object from an API call so we don't know if it's null or not
student = null; 

try {
  console.log(student.potions);
} catch (error) {
  console.error(error);
  console.log("An error occurred when trying to access the potions field");
}