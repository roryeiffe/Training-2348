# Bank (Solo Project)
## Description 
The Bank app is a console-based application that simulates banking operations. A customer can apply for an account, view their balance, and make withdrawals and deposits. An employee can approve or deny accounts and view account balances for their customers. 
## Purpose 
We want to see that you can meet deadlines and that you can code. You are expected to complete the following requirements and give a 5 minute presentation of your project.
## Requirements 
1. Functionality should reflect the below user stories. 
2. Data is stored in a database. 
3. A custom stored procedure is called to perform some portion of the functionality. 
4. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects. 
5. All input is received using the java.util.Scanner class. 
## User Stories 
* As a user, I can register for a customer account. 
  * Don't need functionality to register as an employee but make sure to have one hard-coded into the database for demonstration purposes
* As a user, I can login as a customer or an employee
* As a customer, I can apply for a new bank account with a starting balance. 
* As a customer, I can view the balance of a specific account. 
* As a customer, I can make a withdrawal or deposit to a specific account. 
* As the system, I reject invalid transactions. 
    * Ex: * A withdrawal that would result in a negative balance. 
    * A deposit or withdrawal of negative money. 
* As an employee, I can approve or reject an account. 
* As an employee, I can view a customer's bank accounts. 
* As a customer, I can post a money transfer to another account. 
* As a customer, I can accept a money transfer from another account. 
* As an employee, I can view a log of all transactions.
  * Keep in mind "transaction" here refers to financial transactions (not SQL transactions)

## To Start
- Reread the specs and making sure you understand them
- Begin planning entities (ex: user) and fields for each entity
- Set up the "skeleton"/infrastructure for the command line parsing using dummy functions