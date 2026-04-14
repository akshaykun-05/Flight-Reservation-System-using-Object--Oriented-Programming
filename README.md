# Flight Booking System

A simple Java program that simulates a flight seat booking system.

## Description

This project demonstrates object-oriented programming concepts in Java by implementing a basic flight booking system. It includes:

- **Passenger Class**: Represents passengers with ID and name
- **Flight Class**: Manages seat bookings with a fixed capacity
- **Main Class**: Demonstrates the booking functionality

## Features

- Book seats for passengers
- Prevent duplicate bookings for the same passenger
- Display current seat status
- Handle flight full scenarios
- Fixed seat capacity (configurable)

## How to Run

### Prerequisites
- Java Development Kit (JDK) installed on your system
- Java version 8 or higher recommended

### Compilation
```bash
javac Main.java
```

### Execution
```bash
java Main
```

## Sample Output

```
Flight Created with 5 seats.

Passenger Aman booked successfully.
Passenger Rahul booked successfully.

Seat Status:
Seat 1: Aman
Seat 2: Rahul
Seat 3: Empty
Seat 4: Empty
Seat 5: Empty

Passenger Neha booked successfully.
Passenger Karan booked successfully.
Passenger Vikas booked successfully.

Flight Full! Booking failed for Passenger: Riya
```

## Project Structure

- `Main.java` - Contains the Passenger, Flight, and Main classes
- `Passenger.class` - Compiled Passenger class
- `Flight.class` - Compiled Flight class
- `Main.class` - Compiled Main class

## Author

AkshaySahu05

## License

This project is for educational purposes.