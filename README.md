# Backend Ticket Booking System 

This project provides a complete, fully functional backend implementation of a ticket booking system based on a microservice architecture. I built it primarily to improve my knowledge in this area and because I actually enjoy working on such systems recently. The services are organized in a monorepo as this is a private, non-production project, but the system is nonetheless fully operational. Full documentation is available at: www.blabla.com


## Microservice Architecture Overview

![easybooking Preview](./assets/ticketSystem-architecture.png)


## Tech Stack

- Java
- Spring Boot
- PostgreSQL (Database)
- Flyway (DB Migration)
- Apache Kafka (Queue)
- Keycloak (Auth security)
- Spring Cloud routing (API Gateway)
- Docker


## How to use it

1. Clone repository
```
git clone https://github.com/2002kani/booking-system-microservice.git
cd inventory-service
```

2. Start Docker Container
```
docker compose up -d
```

3. Start services
```
cd inventory-service
./mvnw spring-boot:run

cd bookingservice
./mvnw spring-boot:run
```
