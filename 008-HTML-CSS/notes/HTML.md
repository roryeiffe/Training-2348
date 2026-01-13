## Front-End Technologies
- HTML/CSS
  - HTML - Hyper TextMarkup Language
    - Lets us define the elements on our page, structure
  - CSS - Cascading Style Sheets
    - Lets us apply styling to our page/application (color, spacing, borders, background)

### Terms
- Element - something that exists on our web page like a button, some text, image, table, forms
- Tag - in the HTML code, we use tags to define elements
  - Some elements have opening/closing tags
    - <div>Content</div>
  - Some elements are self-closing:
    - <img src = "image.jpg"/>
- Attribute - used to define specific properties of an element
  - src - defining the image source
  - id - identifying an element
  - class - another attribute we can apply, useful for styling
    - for example, card class, we could create stylings that apply to every element with that class

### Structure of HTML Page
- overall, we have html tag that wraps around head/body
- head
  - meta-data - like char set, scale
  - linked styles that we want to apply
- body
  - elements (text, images, etc.)
  - scripts - scripts contain JS which includes logic to operate our web page
    - We put the scripts in the body for efficiency
    - If we put them in the head, the web page wouldn't load until the script finished loading in
- VSCode - 
  - If we have an empty html file, we can type "html:5" "!" and hit tab
    - it will generate the basic layout of an HTML file


### Elements
- Headers (h1-h6) - used to represent titles/headers/etc.
  - Numbers apply to precedence/importance with h1 being the highest
  - ex: h1 as the overall page title and then h2 as like sub-headers
- paragraph (p) - used to type longer pieces of text
  - for testing purposes, in VSCode, we can type in "lorem" and hit enter to include some dummy text
- Div 
  - container to hold other elements
- Lists
  - Unordered Lists (ul)
    - Don't have numbers, bullet points
  - Ordered Lists (ol)
    - Does include numbers
  - Individual list items are written with "li"
- Anchor Tags
  - Used to include links to other pages
    - Could link to a completely different website
    - Can also link to another web page on the same site
    - include paths to a local file
  - <a href = "http://google.com">Click Me </a>
- Images and Videos
  - Include media on the page
  - Use the src attribute to specify the location of the image (local file or somewhere on the web)

### Inline vs Block
- Inline elements can share the same horizontal space as long as there is horizontal room
  - images are inline by default
- Block elements
  - Appear vertically even if there is horizontal room
  - headers, p, divs are block by default
- Can include a <br/> to start a new line wherever in the web page

### Tables
- Used to store table-like data multi-field, 2 dimensional data
- Tags - 
  - table - used to wrap around the entire table
  - thead - we can have headers/labels for our different columns
  - tbody - represent the data that we want to include in the table
  - th - represents a header item (could be a label for a particular column)
  - tr - represents a table row, comprised of td elements
  - td - table data, an individual cell in the table


### Forms
- Forms let us submit data
- form tag - represents the entire form
- input tags - represent the individual input elements in the form
  - text input
  - radio
- Forms are used to take data from the user
  - ex: login/register/adopt pet
- input element
  - type ("text", "password", "email", "radio", "checkbox")
  - name - indicates the name of the field (username, password, birthday)
  - value - indicates the value of the field
  - required - useful for validation, indicates that this field is required
    - forms won't submit if these fields are empty
  - checked - for checkboxes/radios, can configure inputs to start checked
  - button - clickable element, used to trigger events
  - label - used to label an input with the type information it's taking in (username, password, etc.)
  - textarea - used to take in a lot of text, like a biography
  - select - used to create a drop-down menu
    - option - represents a particular option in the dropdown
  

### Live Server
- Whenever we make changes to our HTML code, we have to save the file and then refresh the browser page to see the changes
- The Live Server extension will detect changes and refresh automatically so we don't have to worry
- On VSCode, head to "Extensions" 
  - Look up "Live Server", click it, and install
- Once installed, we can right-click an HTML file on the left side-panel that displays our files
  - Select "Open with Live Server"

### Semantic Tags
- Introduced in HTML 5
- Used to organize our web pages, give descriptive labels to the different sections of our web page
- Semantic Tags
  - header - information at the top of the page
  - footer - information at the bottom
  - nav - navigation bar that redirects us to different pages
  - article, section, aside
