# E-Roomify: Hotel Booking Application

## Overview

Welcome to Roomify, a comprehensive hotel booking application developed using Java and Spring Boot. This project incorporates best practices of coding, follows the Singleton design pattern, and adheres to industry-standard coding conventions. With a focus on security, the application implements Spring Security for authentication, authorization, and role-based access control.

## Features

- **Java and Spring Boot**: Leveraging the power of Java and Spring Boot to create a robust and scalable hotel booking application.

- **MySQL Database**: Utilizing MySQL for efficient data storage and retrieval.

- **Spring Security**: Implementing Spring Security to ensure secure authentication, authorization, and role-based access control.

- **Singleton Design Pattern**: Employing the Singleton design pattern for efficient resource management.

- **50+ CRUD Operations**: Enabling a wide range of Create, Read, Update, and Delete operations to manage hotel bookings seamlessly.

- **Modular Structure**: Organizing code into separate modules for entities, repositories, services (interfaces and implementations), controllers, configurations, requests, responses, and custom exceptions.

## Project Structure

```
roomify-hotel-booking-application
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── roomify
│   │   │   │   │   ├── controller      # Controllers for handling HTTP requests
│   │   │   │   │   ├── entity          # Entity classes representing database tables
│   │   │   │   │   ├── exception       # Custom exception classes
│   │   │   │   │   ├── repository      # Spring Data JPA repositories
│   │   │   │   │   ├── security        # Security configurations and classes
│   │   │   │   │   ├── service         # Service interfaces and implementations
│   │   │   │   │   ├── RoomifyApplication.java   # Main application class
│   │   │   │   │
│   │   ├── resources
│   │   │   ├── application.properties    # Application-specific configurations
│   │   │   │
│   ├── test                                # Test classes
│   │
├── .gitignore                             # Git ignore file
├── README.md                              # Project documentation
```

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/pritam-saha-java/e-roomify.git
   ```

2. **Database Configuration:**
   - Set up your MySQL database and update the `application.properties` file with the appropriate database credentials.

3. **Build and Run:**
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

4. **Access the Application:**
   Visit `http://localhost:8080` in your web browser to access the Roomify Hotel Booking Application.
