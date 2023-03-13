# E-commerce Web App
[![Current Version](https://img.shields.io/badge/version-1.0.0-green.svg)](https://github.com/soumanpaul/MERN-e-commerce)

This is a Spring Boot application that allows users to search for and browse electronic products, add products to their shopping cart, and place an order. It also provides website admins with the ability to manage the product catalog and users.

 ## Index
+ [Features](#features)
+ [Technologies used](#Technologies-Used)
+ [Deploying to Heroku](#Deploying-to-Heroku)
+ [How to Run Locally](#How-to-Run-Locally)
+ [License](#license)

## Features
- [x] User Management
- [ ] Sign up: Users can register by creating a new account using an email address
- [ ] Authentication: Registered users can sign in and sign out
- [ ] Product search by name and category
- [ ] Shopping cart 
- [ ] Payment processing with Pay Pal
- [ ] Order management
- [ ] Product management: Manage brand/category/product


## Technologies Used
- [Spring Boot](https://spring.io/) as the application backend Framework.
- Apache Maven as build tool and Tomcat as server.
- [MySQL](https://www.mysql.com/), [JPA](https://spring.io/guides/gs/accessing-data-jpa/), and [Hibernate](https://hibernate.org/) framework for storing and querying data.
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html) for user authentication via username and password.


## Deployment 
Instructions for deploying the application to Heroku will be added in the future.

## How to Run Locally
1. Clone this repository
2. Set up a MySQL database and configure the ShopioBackend/src/main/resources/application.properties file to point to your database.
3. Run the application using your IDE or by running mvn spring-boot:run in the project directory.
Access the application at http://localhost:9090

