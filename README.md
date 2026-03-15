Description
A robust, Microservices-based portal designed to automate student attendance tracking. Built with Java and Spring Boot, the system ensures high availability, modularity, and seamless integration between student, faculty, and administrative modules.

🏗️ Architecture
This project follows a decoupled Microservices architecture:

Discovery Server: Netflix Eureka for service registration.

API Gateway: Centralized entry point for all client requests.

Attendance Service: Core logic for marking and retrieving attendance.

Student/Faculty Service: Manages user profiles and academic records.

Notification Service: Automated alerts for low attendance.

✨ Key Features
Role-Based Access Control (RBAC): Distinct dashboards for Students, Teachers, and Admins.

Automated Reports: Generate weekly/monthly attendance summaries in PDF/Excel.

Real-time Dashboard: Live statistics on student presence using Spring Boot Actuator.

Database: PostgreSQL for persistent storage and Redis for caching.

🛠️ Tech Stack
Backend: Java 17+, Spring Boot, Spring Cloud, Hibernate/JPA.

Database: PostgreSQL, MySQL.

Tools: Docker (Containerization), Maven, Postman (API Testing).
