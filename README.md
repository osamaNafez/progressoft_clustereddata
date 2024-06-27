# progressoft-clustereddata
this project was developed for the evaluation task for Java developer position at Progressoft Corp

Project Overview
This project was developed as part of an evaluation task for the Java Developer position at Progressoft Corp. The main objective of this project is to create a Spring Boot application that accepts and persists foreign exchange (FX) deals into a PostgreSQL database. The project adheres to SOLID principles and Clean Code practices to ensure maintainability and scalability. The entire system is containerized using Docker for seamless deployment.

Features and Work Done

Spring Boot Application: Developed a Spring Boot application to handle the FX deals.
Database Integration: Integrated with a PostgreSQL database, chosen for its robustness and compatibility.
Containerization: Containerized the application using Docker, facilitating easy deployment and environment consistency.
Validation: Implemented input validation using javax.validation to ensure data integrity before persisting records.
Architecture: Followed a layered architecture, separating the application into model, service, and controller packages for better organization and maintainability.
Test-Driven Development (TDD): Created unit tests for all components using JUnit, ensuring high code quality and reliability.
Logging: Utilized SLF4J for effective logging, aiding in monitoring and troubleshooting.
Build Tool: Used Maven for project management and build automation.
Customer Story
As part of a scrum team developing a data warehouse for Bloomberg to analyze FX deals, one customer story required us to accept deal details and persist them into a database. The following logic was implemented:

Request Fields:

Deal Unique Id
From Currency ISO Code ("Ordering Currency")
To Currency ISO Code
Deal Timestamp
Deal Amount in Ordering Currency

Validation:

Validate the structure of the incoming data, including missing fields and type format.
Ensure that duplicate requests (based on Deal Unique Id) are not imported twice.
Implement a no-rollback policy; any rows successfully imported should remain in the database.
Deliverables
The deliverables include a fully functional application ready for deployment, complete with a sample file and the following components:

Database: Utilized PostgreSQL for this project, but the solution can be adapted to use MySQL or MongoDB as required.
Deployment: Provided a Docker Compose configuration for deploying the application and database.
Build Tool: Maven project setup for managing dependencies and building the project.
Error Handling: Implemented proper error and exception handling mechanisms.
Logging: Configured SLF4J for logging.
Unit Testing: Comprehensive unit tests with adequate coverage.
Documentation: Detailed documentation provided in markdown format.
Version Control: Code delivered via GitHub.
Makefile: Included a Makefile to streamline running the application (optional but beneficial).

Conclusion

This project demonstrates the implementation of a Spring Boot application that adheres to industry best practices, ensuring robustness and maintainability. It provides a scalable solution for handling FX deals, validating input data, and persisting it to a PostgreSQL database, all within a Dockerized environment for easy deployment.
