# GPA Calculator (Java + MySQL)

A Java-based GPA Calculator using OOP principles and MySQL database integration. The project manages courses and calculates GPA through a simple console application.

---

## Features

- Add / remove courses  
- View all courses  
- Calculate GPA  
- Track total credits  
- Validate grades  
- Prevent duplicate courses  
- MySQL database persistence  

---

## Tech Stack

- Java  
- JDBC  
- MySQL  
- Maven  
- JUnit  

---

## Database

```sql
CREATE DATABASE gpa_db;

USE gpa_db;

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    grade VARCHAR(5) NOT NULL,
    credits DOUBLE NOT NULL
);
