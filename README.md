# Bajaj Finserv Health Qualifier - Java Spring Boot Application

This is a Spring Boot application developed for the Bajaj Finserv Health Qualifier challenge.

## Overview

The application:
1. On startup, sends a POST request to generate a webhook
2. Solves an SQL problem based on the registration number (REG12347 - odd ending, so Question 1)
3. Submits the SQL solution to the provided webhook URL using JWT authentication

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── bajajfinserv/
│   │           └── qualifier/
│   │               ├── QualifierApplication.java        # Main application class
│   │               ├── config/
│   │               │   └── AppConfig.java               # Configuration beans
│   │               ├── dto/                             # Data Transfer Objects
│   │               │   ├── WebhookRequest.java
│   │               │   ├── WebhookResponse.java
│   │               │   └── SqlQueryRequest.java
│   │               ├── runner/
│   │               │   └── QualifierRunner.java         # Startup execution logic
│   │               └── service/
│   │                   ├── WebhookService.java          # Webhook API interactions
│   │                   └── SqlProblemSolver.java        # SQL problem solving logic
│   └── resources/
│       └── application.properties                       # Application configuration
└── pom.xml                                             # Maven configuration
```

## Features

- **Automatic Startup Execution**: Uses `CommandLineRunner` to trigger the flow on application startup
- **RESTful API Integration**: Uses `RestTemplate` for HTTP communication
- **JWT Authentication**: Handles JWT token in Authorization header
- **Dynamic SQL Problem Selection**: Selects SQL question based on registration number (odd/even logic)
- **Error Handling**: Comprehensive error handling and logging

## User Details (as specified in requirements)

- Name: John Doe
- Registration Number: REG12347
- Email: john@example.com

## SQL Problem Logic

The application determines which SQL question to solve based on the last two digits of the registration number:
- Odd last two digits (47) → Question 1
- Even last two digits → Question 2

For REG12347, it will solve Question 1.

## Requirements

- Java 17 or higher
- Maven 3.6 or higher
- Internet connection for API calls

## Building the Application

### With Maven installed:
```bash
mvn clean package
```

### Without Maven (using wrapper - if available):
```bash
./mvnw clean package    # Linux/Mac
mvnw.cmd clean package  # Windows
```

## Running the Application

### From JAR:
```bash
java -jar target/bajaj-finserv-qualifier.jar
```

### From Maven:
```bash
mvn spring-boot:run
```

## Expected Flow

1. **Application Starts**: Spring Boot application initializes
2. **Webhook Generation**: POST request to `https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
3. **SQL Problem Solving**: Determines and solves the appropriate SQL question
4. **Solution Submission**: POST request to `https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`
5. **Application Completes**: Process finishes and application can be terminated

## API Endpoints Used

### Generate Webhook
- **URL**: `https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
- **Method**: POST
- **Body**: 
  ```json
  {
    "name": "John Doe",
    "regNo": "REG12347",
    "email": "john@example.com"
  }
  ```

### Submit Solution
- **URL**: `https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`
- **Method**: POST
- **Headers**: `Authorization: <accessToken>`
- **Body**:
  ```json
  {
    "finalQuery": "SQL_QUERY_HERE"
  }
  ```

## Notes

- The application includes placeholder SQL queries that would typically be derived from analyzing the actual problem documents
- Error handling is implemented for network issues and API failures
- Console logging shows the progress and results of each step
- No controllers or REST endpoints are exposed (as per requirements)

## Submission

This project is designed to be submitted with:
- Complete source code in a public GitHub repository
- Built JAR file available for download
- This README with complete instructions

## Author

Developed for Bajaj Finserv Health Qualifier Challenge
