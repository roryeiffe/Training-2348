## RDS
- On AWS console, we navigate to RDS service
- Click on Create Database
- Select our Engine Type (Postgres)
  - Version - can leave this as is or pick a specific one
- Select Sandbox 
- Single AZ Instance
- Specify a DB instance identifier
  - This is not the same as the database name, this will be "postres"
- Specify username and master password (Make sure to remember these)
- Connectivity
  - Allow Public Access
  - Configure Security Group to allow connections from our IP

## Connecting via DBeaver
- Go on DBeaver -> Database -> New Database Connection
  - Keep the username, database name, port number the same (unless we changed those in the creation)
- Fill out the password
- Instead of localhost, we can get the address from the RDS instance once it's created
  - Under Connectivity and Security, go to the endpoints tab
  - Under endpoints + ports, we should see something like rory-rds.c7tc6o4ksml8.us-east-2.rds.amazonaws.com

## Connecting via our Spring Boot app:
- application.properties:
```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true

spring.datasource.url=jdbc:postgresql://pet.cmm7dyyeb3rr.us-east-1.rds.amazonaws.com/postgres
spring.datasource.username=postgres
spring.datasource.password=password
```

## Shutting Down
- Either from the instance itself or from the list of db instances, we can select "actions" -> delete
- Check the boxes if we want to retain any backups
- Otherwise, type in the prompt and click delete