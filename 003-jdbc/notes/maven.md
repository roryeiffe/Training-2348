## Maven
- Build Automation Tool
- We can specify dependencies (like JDBC) in our project and Maven will automatically fetch them integrate them into the project

### Installation (Windows)
- Download zip file
- Extract and place the resulting folder in easily accessible file location
- Add the bin directory to the PATH environment variable
  - Windows Bar - Search "environment" and select the option to edit the system's environment variables
  - Click "Environment Variables"
  - Under User Variables or System Variables, click on PATH and then the "Edit" button
  - On the next screen, click "New" and paste the path in the empty row
  - Click ok and exit out

### IntelliJ Maven Project
- In IntelliJ, click on File -> New -> Project
- On the project creation screen, can select Maven on the left
- Name our project
- Select JDK
- Select an archetype (template), select the maven quick start archetype

### pom.xml
- Project Object Model
- Contains information about the project including name, version, website url (if applicable)
- Dependencies - 
  - Enclosed within the "dependencies" tag, we have individual "dependency" tags that contain information about the external libraries that we're using for our project
- Whenever we make edits to the pom, we need to resync the changes
  - In IntelliJ, there is a pop-up button that lets us sync the Maven changes

### Maven Central Repository
- Website in which you can search for Maven dependencies
- mvnrepository.com
- We can filter by version and copy the xml code directly from the website and paste into our pom.xml