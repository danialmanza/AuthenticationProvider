# Authentication Provider

Authentication Provider is a Java-based application that provides authentication and authorization services. It allows users to securely authenticate and access protected resources within a system.

## Features

- User Registration: Allows users to create an account by providing their name, email, phone number, and password.
- User Authentication: Provides secure authentication using username/email and password combination.
- Password Management: Allows users to reset their password by providing their email and receiving a password reset link.
- Role-based Authorization: Supports role-based access control to protect resources based on user roles.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JSON Web Tokens (JWT)
- Spring Data JPA
- MySQL

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- MySQL database
- Postman (or any REST API client) for testing

### Installation

1. Clone the repository:

https://github.com/danialmanza/AuthenticationProvider.git


2. Configure the database:

   - Create a new MySQL database.
   - Update the database connection details in the `application.properties` file.

3. Build the project:

mvn clean install

4. Run the application:

mvn spring-boot:run


5. The application will start running on `http://localhost:8080`.

## API Endpoints

### User Registration

- `POST /auth/signup`: Register a new user by providing the required user details.

### User Authentication

- `POST /auth/login`: Authenticate a user by providing their username/email and password. Returns a JSON Web Token (JWT) for subsequent API requests.

