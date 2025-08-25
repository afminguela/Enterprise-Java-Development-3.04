# Airline Booking System - Documentation

This project implements a simple airline booking system using Java, Spring JPA, and data from the airline database (see Lab 3.02). The system models Customers, Flights, and Flight Bookings, and tracks customer status and flight mileage.

## Overview

The system is composed of four main components:

- `CustomerStatus` (enum): Defines customer status levels.
- `Customer` (class): Represents a customer with relevant details.
- `Flight` (class): Represents a flight and its details.
- `FlightBooking` (class): Represents a booking linking customers and flights.

---

## Components

### 1. CustomerStatus Enum

Defines the status of a customer. Possible values:

- `Gold`
- `Silver`
- `None`

This allows for easy tracking and management of customer reward levels.

---

### 2. Customer Class

Represents a customer in the system, with the following fields:

- `customerId` (Integer): Auto-generated unique identifier. *(Primary Key)*
- `customerName` (String): The customer's name.
- `customerStatus` (CustomerStatus): Enum value indicating customer status.
- `totalCustomerMileage` (Integer): Total miles flown by the customer.

#### Methods

- **Constructors:**
    - Empty constructor (required by Hibernate)
    - Parameterized constructor: accepts `customerName`, `customerStatus`, and `totalCustomerMileage`
- **Getters and Setters:** For all fields.

---

### 3. Flight Class

Represents a flight, with the following fields:

- `flightId` (Integer): Auto-generated unique identifier. *(Primary Key)*
- `flightNumber` (String): Unique flight number.
- `aircraft` (String): Aircraft type or model.
- `totalAircraftSeats` (Integer): Number of seats on the aircraft.
- `flightMileage` (Integer): Distance covered by the flight.

#### Methods

- **Constructors:**
    - Empty constructor (required by Hibernate)
    - Parameterized constructor: accepts `flightNumber`, `aircraft`, `totalAircraftSeats`, and `flightMileage`
- **Getters and Setters:** For all fields.

---

### 4. FlightBooking Class

Represents a booking that links a customer to a flight, with the following fields:

- `bookingId` (Integer): Auto-generated unique identifier. *(Primary Key)*
- `customerId` (Integer): References the `Customer` entity. *(Foreign Key)*
- `flightId` (Integer): References the `Flight` entity. *(Foreign Key)*

#### Methods

- **Constructors:**
    - Empty constructor (required by Hibernate)
    - Parameterized constructor: accepts `customerId` and `flightId`
- **Getters and Setters:** For all fields.

#### Constraints

- **Foreign Key Constraints:**  
  - `customerId` references the `customerId` in the `Customer` table.
  - `flightId` references the `flightId` in the `Flight` table.

---

## Getting Started

1. **Clone the repository.**
2. **Set up your database** using data from Lab 3.02.
3. **Build and run the project** using your preferred Java IDE and Spring Boot.

---

## References

- [Spring JPA Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- Airline database schema and data from Lab 3.02

---

