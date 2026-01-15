type Person = {name: string};
type Employee = Person & {employeeId: number}

let emp1:Employee = {
  name: 'jim',
  employeeId: 1
}