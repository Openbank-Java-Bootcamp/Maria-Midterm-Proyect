# Maria-Midterm-Proyect

The project consists in an API for a bank company. The solution provides some options to the company for managing accounts, and users. The class diagram below shows the possible actions:

![Diagram midterm](https://user-images.githubusercontent.com/103991735/169686786-0767c0fd-8bf6-4ae7-b961-e6355ff23acc.png)

The technologies I have used for build the project are:

1.REST API: Java/Spring Boot, Spring Security, unit and integration tests, robust error handling.

2.MySQL: database tables.

3.Postman: test the endpoints.
  
In the models package we can see all the models and the relationships between them. The Account model contains all the attributes common to all types of accounts. The different types of accounts inherit from the Account class and they are Savings, CreditCard, Checking and StudentChecking.

We also have the User class and the different types of users that inherit from it. They are AccountHolders and Admins.

In addition to these classes, there are others necessary for the implementation of the attributes. These are for example the class Money and Address.

The models have their respective DTOs that I have used as parameters in the service methods.I have created a service for each type of account, which will have their respective controllers.

1. Account Service: Contains a get method to list all account types, a get method to find by id, a method to update the balance of one account, another method to delete an account, and another to create a transfer. The respective endpoints in the controller are "/api/accounts", "/api/accounts/{id}", "/api/accounts/{id}", "/api/accounts/{id}", "/api/accounts/transactions".

2. Checking Service: Contains a method to create a checking account. If the age of the user is less than 24 years, then creates a student checking account. The endpoint in the controller for this method is "/api/checkings".

3. StudentChecking Service: Contains a method to create a student checking account. The endpoint in the controller for this method is "/api/studentCheckings".

4. Savings Service: Contains a method to create a saving account. The endpoint in the controller for this method is "/api/savings".

5. CreditCard Service: Contains a method to create a credit card account. The endpoint in the controller for this method is "/api/creditCard".

Resources:

https://github.com/Openbank-Java-Bootcamp/Openbank-Java-Bootcamp

https://www.youtube.com/watch?v=caCJAJC41Rk

https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/

https://betterprogramming.pub/building-a-spring-boot-rest-api-a-php-developers-view-part-i-6add2e794646

My teachers Raymond and Shaun have helped me a lot with issues and code errors.



