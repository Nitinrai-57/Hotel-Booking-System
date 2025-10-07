# Hotel-Booking-System
Developed a scalable hotel booking platform using microservice architecture with separate services for Hotel, Room, Inventory, Booking, and Payment. Integrated Razorpay payment gateway to enable secure and automated online payments.
Topics to be Covered

## Microservice Architecture

Payment Integration with Razorpay

RESTful APIs & Inter-Service Communication

Service Discovery & Caching

Webhooks & Notifications

Logging & Monitoring

Containerization with Docker

Microservice Architecture
Overview

The hotel booking platform is designed using a microservice architecture. Each service is independent, modular, and responsible for a specific domain:

Hotel Service: Manages hotel information and details.

Room Service: Handles room details and availability.

Inventory Service: Tracks room availability to prevent overbooking.

Booking Service: Manages booking creation, updates, and cancellations.

Payment Service: Handles secure online payments using Razorpay.

User Service: Manages user authentication and profiles.

Notification Service: Sends emails/SMS notifications for bookings and payments.

This approach ensures scalability, fault tolerance, and easier maintenance.

Payment Integration with Razorpay

The platform integrates Razorpay for secure and automated online payments.

Ensures transaction management to maintain consistency between booking and payment.

Supports seamless online transactions with error handling and rollback if payment fails.

RESTful APIs & Inter-Service Communication

Services communicate using RESTful APIs, leveraging:

RestTemplate: For synchronous service-to-service calls.

Feign Clients: For simplified declarative HTTP client calls.

Retry, Timeout, and Fallback mechanisms: To ensure reliability during failures.

Service Discovery & Caching

Eureka Client: Automatically registers services for dynamic discovery.

Redis Caching: Improves performance by storing frequently accessed data.

Webhooks & Notifications

Implemented webhooks for real-time notifications and external service integration.

Notification Service sends emails/SMS for booking confirmations and payment updates.

Logging & Monitoring

Centralized logging for tracking service activity.

Real-time monitoring helps debug issues and ensures system reliability.

Containerization with Docker

All microservices are containerized using Docker.

Ensures consistent environments for development, testing, and production deployment.

Tech Stack

Backend: Java, Spring Boot, Spring Cloud

Databases: MySQL, Redis

Messaging & Event Streaming: Kafka

Service Discovery & Communication: Eureka, Feign Client, RestTemplate

Payment Gateway: Razorpay

Deployment & Containerization: Docker

Other Features: Retry, Timeout, Fallback, Webhooks, Transaction Management, Logging & Monitoring
