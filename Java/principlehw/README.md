# CAREZ - Car Washer Reservation

## Project Description

CAREZ is a system that allows users to make online car wash reservations. This project enables users to select from different car wash services, make reservations, and track the coupons they have earned.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Class and Method Descriptions](#class-and-method-descriptions)

## Features

- User login
- Listing car wash services
- Listing the nearest car wash services
- Searching car wash services by name or area
- Making reservations and earning coupons

## Requirements

- Java JDK (1.8 or higher)

## Installation

1. Clone or download this project to your computer.
2. Open a terminal or command prompt and navigate to the project directory.
3. Compile all `.java` files using the `javac` command:
    ```sh
    javac Application.java CarWasher.java Coupon.java Location.java ReservationHistory.java Search.java
    ```
4. After compiling, run the application using the `java` command:
    ```sh
    java Application
    ```

## Usage

When the program starts, it displays a welcome message for CAREZ and verifies user login information. You can then list available car wash services, view the nearest services, search by name or area, and make reservations.

## Class and Method Descriptions

### Application

- `loginn(String log)`: Verifies user login.
- `open()`: Displays the application opening message.
- `close()`: Displays the application closing message.
- `main(String[] args)`: The entry point of the application.

### CarWasher

- `listInfo()`: Lists the three nearest car wash services.
- `list()`: Lists all car wash services.

### Coupon

- `coupon()`: Generates a random coupon number.
- `givecoupon()`: Checks the coupon status and informs the user.

### Location

- `calculateDistance()`: Calculates and lists the distances of car wash services from the user's location.

### ReservationHistory

- `make_reservation()`: Prompts the user to select a car wash service and completes the reservation.

### Search

- `search_name(String name)`: Searches for and lists car wash services matching the given name.
- `search_area(String area)`: Searches for and lists car wash services in the given area.

## Contact

For any questions or feedback, please email [Carez@hotmail.com](mailto:Carez@hotmail.com).

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.
