# Domain-Driven Design, Backend Exercise

This project demonstrates a Domain-Driven Design (DDD) backend implemented in Java Spring for a course management system. The system allows users to browse courses, answer questions, and purchase courses they are interested in.
## Tech Stack
* Java Spring Boot
* PostgreSQL
* JPA (Java Persistence API)

## Project Structure
1. Course Catalog

   The course-catalog module is responsible for managing courses and their associated questions. It includes:
   * Course Model: Represents a course entity.
   * Questions Model: Contains the questions for each course.
   * Value Objects: Additional data abstractions to support the course and questions.
2. Enrolment Management
   
  The enrolment-management module handles the process of purchasing a course. It includes:
  * Order Model: Represents an order made for a course.
  * Order Status: Manages the current state of an order (e.g., pending, completed).
  * Ordered Item Model: Represents the purchased items within an order.
3. Shared Kernel

  The shared-kernel module contains common logic shared across the other modules. This includes utilities, domain events, and shared entities that can be reused.

