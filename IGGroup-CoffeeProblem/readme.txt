Coffee House

Rob owns a coffee shop and offers various varieties of coffee throughout all the day. At any given point of time, customers visit his coffee house and order coffee of their choice.
Currently Rob maintains a register to keep track of the inventory and customer details and also generates a receipt manually every time a customer buys a coffee. He wants to transform his coffee house digitally and is looking out for an application to help him perform all the functions listed below.

Functions
 1. Add a new customer
   - Uniqueness of the customer needs to be maintained
   - Customer can be identified by a name and phone number
   - Add a new variety of coffee
   - Each variety needs to have a name, description and total servings available for the day.
   
   
 2. Process an order for a particular customer
    - An order would basically be against a customer, different varieties of coffee ordered, and quantities for each of them and the timestamp.
    - A receipt needs to be generated for each order.
    
    
 3. Generate the report at the end of the day, listing all the coffee types and details regarding how many were sold for the day.
    - Report should contain the following details
            Coffee Variety                  Total servings for the day              Total servings sold for the day
            Cappuccino                      100                                     50
            Latte                           150                                     150
            
Of course, we don’t expect you to build the response in the form of a table, but the response of the API should contain all the above information.


Rules of the game!
 You have two full days to implement a solution.
 You are allowed to make reasonable assumptions for solving the problem.
 Expose different REST API’s for each of the functions mentioned above.
 We are really, really interested in your object oriented development skills, so please solve the problem keeping this in mind.
 Please ensure that the coding conventions, directory structure and build approach of your project follow the conventions set by popular open source projects.
 MANDATORY: Please do not check in class files, jars or other libraries or output from the build process. Use maven for building your application
 MANDATORY: Please write comprehensive unit tests.
 Tech Stack: Java, Spring, (Spring Boot would be great!), Junit, Mockito
 Don’t bother about using any database. InMemory storage should be sufficient, using appropriate data structures.
 MANDATORY: Please provide a readme files listing all useful information, which we could use to invoke all the API’s.

Bonus Points if you do the following
 Expose swagger endpoints
 Shell script that automates the entire build and execute process.
