## Comparator and Comparable
- In Java, we are able to compare primitives easily (as well as strings <, >)
- Imagine comparing something like a Movie object, there is no universally accepted way to 
  - sort/compare these so we have to define our behavior ourselves
- Both are responsible for adding comparison behavior to custom objects

### Comparable 
- An interface that we can implement and imposes the natural ordering on a given class
  - The class which implements Comparable is the class that we want to compare
- When we implement, we have to fill out compareTo method which takes in an instance of an object and returns an integer
  - 0 if same
  - negative number if less than the specified object
  - positive if greater than

### Comparator
- Imposes a total ordering over a collection of objects
- We will make a separate Comparator class that we then pass into Collections.sort method (or others, depending on how we're going to use the comparator)