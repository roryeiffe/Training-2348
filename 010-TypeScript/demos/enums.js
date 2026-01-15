var PetTypes;
(function (PetTypes) {
    PetTypes[PetTypes["cat"] = 0] = "cat";
    PetTypes[PetTypes["dog"] = 1] = "dog";
    PetTypes[PetTypes["bird"] = 2] = "bird";
})(PetTypes || (PetTypes = {}));
var pet2 = {
    name: 'scooby',
    food: 'scooby snax',
    type: PetTypes.cat
};
console.log(pet2);
