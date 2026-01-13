## Cascading Style Sheets (CSS)
- Used to apply styling to our web pages (Colors, spacing, etc.)

### Cascading Nature of CSS
- CSS rules come from many different places. Imagine if 2 rules gave conflicting stylings (color: red, color: blue), CSS has a way of prioritizing which rules to apply
  - Specificity - More specific selectors will take priority over less specific selectors  - stylings applied to an id will take precedence over stylings applied to a class
  - Importance - stylings marked with !important - take precedence over non-important styles
    - Whenever possible, avoid using important because it has such a high precedence, can make it hard to "Track down" where the styles are coming from
  - Inline vs Internal vs External
    - Inline - defined within the element itself
    - Internal - defined within the HTML file (head)
    - External - defined in an external file (*.css) and linked to the HTML page (also in the head)

#### Cascading Order:
- !important
- Inline styles
- Internal CSS
- External CSS - could be shared by multiple HTML elements
- Browser/User Styles

### Defining CSS rules
- key-value pair
  - key is the name of the field (color, size, etc.)
  - value is the actual size/color/value we want to apply
    - size: px, %, vh, vw
    - colors: 'blue', 'red', '#ffffff'

### Selectors
- Selectors help identify which elements to target
- * - select all elements on the page
- select by element - will apply style to each instance of that element
  - ex: selecting all of the paragraphs on the page
  ```css 
  p {
    color: red;
  }
  ```
- class selector - select all elements with that class
  ```css
  .card {
    background: grey;
  }
- id selector - select all elements with that id
  ```css 
  #card-1 {
    size: 10px;
  }
  ```
- pseudo class selectors - will apply when certain element enter certain states
  - :hover, :active
    - For example, we can have a button change color or darken a bit when hovered to give the user the visual feedback
- pseudo element selectors
  - ::first-letter, ::after

#### Parent/Child Selectors
- Target direct children:
- This code targets all p tags that are direct descendants of div
```css
  div > p {
    /* stylings */
  }
```
- Target all descendants (even those nested in immediate children and beyond)
```css
div p {
/* styling */
}
```

#### Sibling Selectors
- lets us target "siblings" or elements that exist on the same hierarchical level
- to select all siblings 
```css
div ~ p {
  /* stylings */
}
```
In this example, we are targeting all p elements on the same level of div elements
- To target the immediately adjacent siblings:
```css
div + p {
  /* stylings */
}
```

### Box Model
- from inner to outer - content, padding, border, margin
- content - the actual content (ex: text)
- padding - spacing between content and border
- border - wraps around the content, can be styled
- margin - space outside of the border


### Responsive Design
- Making web pages look "good" on devices of varying sizes
- We can use media queries to specify CSS rules for different device sies
- In general, easier to start small and expand
  - We don't care too much about mobile, so we can start at our typical Desktop size
- We can also use flex to help organize our elements

### Flexbox
- Helps us to align our elements along a single axis (row or column)
- Flex Container - contains the elements which we want to spread out
- Flex Items - the items that we want to spread out
- Main Axis - primary direction of the layout (we can change this using flex-direction)

#### Flex Attributes:
- display: flex - applied to flex container, enables flex behavior
- flex-direction - the axis by which we're aligning the elements (row, column, row-reverse, column-reverse)
- justify-content - configures how the content is aligned/justified
  - center
  - space-between
  - space-around
- flex-wrap - allows content to "wrap" to the next row/column (depending on which direction is chosen)

### Grid
- Design 2-dimensional layouts (rows and columns)
- Grid Containers - parent element, contains the items to be aligned
- Grid Items - the items to be aligned
- Grid Tracks - specify the rows and column

### CSS Variables
- Variables that can store commonly used values to be used in our application
  - Common use case is storing common colors
  - Could also store a separate set of colors for a dark mode
- Define CSS variables
```css
:root {
  --main-text-color: #8c97a8;
}
```
- To use the variable:
```css
p {
  color: var(--main-text-color)
}
```