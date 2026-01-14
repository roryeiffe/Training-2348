## DOM
- Document Object Model
  - Represents the content of the pages, elements 
  - Represented as a tree structure
  - nodes can have children or siblings
  - In the following code, p elements are siblings, div tag would be the parent
  ```html
  <div>
    <p>this is text</p>
    <p>this is text</p>
  </div>
  ```
- JS allows us to target/find elements on the page
  - Manipulate them
  - Add new elements to the page
  - Remove elements from the page
  - CRUD

### Select Elements from the DOM
- document.getElementById(id) - return an element by its id
  - a reason why ids should be unique, if we're getting an element by id, we don't want any ambiguity
- document.getElementsByClass(clazz) - returns an array of elements with that class
- document.getElementsByTagName(tagName) - return an array of elements that are that tag
- document.querySelector(CSS selector)
  - # for ids
- document.querySelectorAll(CSS selector)
  - . for classes

### Accessing Family Members (parents,children, siblings)
- element.children - return the children of the element
- element.firstChild
- element.lastChild
- element.previousElementSibling
- element.nextElementSibling

### Manipulating the Page
- document.createElement(tag) - create an element of that type
- element1.appendChild(element2) - add element2 as a child of element1
- element.insertBefore(newElement, existingElement) - insert the new element before the existing element
- element.innerText - access/change the text of an element
- element.innerHTML - directly access/change the HTML that is inside of this element
- element.removeChild(childElement) - remove the child element from the page
- element.setAttribute(key, value) - set the value to that attribute
- element.getAttribute(key) - return value associated with that key/attribute
- element.removeAttribute(key) - remove attribute by key
- element.hasAttribute(key) - check if the element has that attribute
- element.remove() - removes that element from the page

### Events and Listeners
- We can set up listeners on certain elements to trigger actions when certain events happen
  - ex: Clicking a button - make some API call
- element.addEventListener(eventType, function)
  - When this event happens, run this function
  - Bubbling/Capturing can be configured with a 3rd parameter
- Event Object
  - target - whatever element helped to trigger the event
  - bubbles - tells you if the event is bubbling/capturing
  - type - type of event

### Bubbling/Capturing
- If we have 2 elements that have a parent-child relationship
  - And, the elements both have an event listener associated
- ex:
```html
<div>
  <button>Click Me</button>
</div>
```
- If we click the button, we are also clicking the div, so both events are triggered
- In which order will they happen?
  - Bubbling - default, child to parent
  - Capturing - parent -> child