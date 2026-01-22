type Book = {
  name: string,
  author: string,
  sales: number
}

// with Partial, don't need to specify anything
// We can include any fields we want, properties are optional:
let partial_book:Partial<Book> = {
  name: 'Lord of the Rings',
}

let name_author_only:Pick<Book, "name" | "author"> = {
  name: "The Martian",
  author: "Andy Weir"
}

let omit_author:Omit<Book, "author"> = {
  name: "Harry Potter",
  sales: 1000000
}

// Record lets us type key-value pairs
type CatName = "smeagol" | "gollum" | "garfield"

interface CatInfo {
  age: number;
  color: string;
}

const cats: Record<CatName, CatInfo> = {
  smeagol: {age: 3, color: "grey and white"},
  gollum: {age: 3, color: "grey"},
  garfield: {age: 10, color: 'orange'}
}