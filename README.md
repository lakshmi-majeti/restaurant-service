# API for getting the List of Thai Restaurants- Restaurant Service

Added Documentation for API using Swagger. Below is the URL.

http://localhost:9082/swagger-ui.html 

**Built With:**
Maven- Dependency Management
Java8 - For Development
Spring Boot - Framework to ease the bootstrapping and development of new Spring Applications
MySQL - Open-Source Relational Database Management System

**Assumptions Made:**

1.For calculating Rating for a restaurant i assumed that, if the critical flag in the table is
 'N' and Score value is < 20 then those are restaurants are good rated. 
 Assuming that 1 to 15 is Rating A and 15 to 20 is rating B.
2. User can get other types of cuisine as well by passing its value. I assumed that only cuisine type is the only input
as per the requirement document 


**Running the application locally:**
To run the application locally, person needs to install Java 8, Maven, Postman to test API
or can use CURL command using commandline tool
    Commands to run locally using command line
        a. mvn clean install
        b. mvn spring-boot:run 
        c. open other terminal, type below curl command 
         curl -v http://localhost:9082/restaurants/Thai
          [OR]
         hit  http://localhost:9082/restaurants/Thai url by selecting 
         GET operation using postman
        
**Improvements can be done:**
1.We can have one more input zipcode for the controller along with cuisine-type to filter restaurants
2.DB improvements can be done, Right now it does not have any indexes
  a.If we want to maintain in a single table, we can add primary column CAMIS, 
     Add NOT null constraint on CAMIS
     Add NOT null constraint on Cuisine Description
     Add NOT null constraint on Critical Flag
     Add NOT null constraint on Score
   b. We can create two tables, one for Restaurant Information and other is for Inspection Information 
      And have one to one mapping between them by having restaurant id common in both tables.  
     
    
         