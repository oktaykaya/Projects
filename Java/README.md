
# Foodiefy Project

Foodiefy is a web application designed to manage and share recipes. It consists of a backend written in Java with PostgreSQL as the database, and a frontend implemented in JavaScript.

## Features

- **User Management**: Allows users to register, login, and manage their profiles.
- **Recipe Management**: Enables users to create, edit, and delete recipes.
- **Category Management**: Supports categorization of recipes into different categories.
- **Commenting**: Users can comment on recipes and interact with other users' comments.
- **Search Functionality**: Provides search capabilities to find recipes based on keywords or categories.
- **Responsive Design**: Frontend is responsive, ensuring usability across different devices.

## Technologies Used

### Backend

- **Java**: Primary programming language for implementing business logic and RESTful APIs.
- **Spring Boot**: Framework for building and deploying Java-based applications.
- **Spring Data JPA**: Simplifies data access using the Java Persistence API (JPA).
- **PostgreSQL**: Relational database management system used for persistent data storage.
- **Lombok**: Library to reduce boilerplate code in Java classes.

### Frontend

- **JavaScript (ES6+)**: Core language used for implementing frontend logic and user interface.
- **HTML/CSS**: Markup and styling languages for structuring and designing the user interface.
- **Bootstrap**: Frontend framework for building responsive and mobile-first websites.
- **Fetch API**: Used for making asynchronous HTTP requests to the backend RESTful APIs.

## Setup and Installation

1. **Backend Setup**:
   - Clone the repository containing the backend Java project.
   - Configure `application.properties` to set up the PostgreSQL database connection.
   - Build and run the Spring Boot application.

2. **Frontend Setup**:
   - Clone the repository containing the frontend JavaScript project.
   - Open the project directory and install dependencies (`npm install`).
   - Start the frontend development server (`npm start`).

3. **Database Setup**:
   - Install PostgreSQL and create a new database for Foodiefy.
   - Update the database configuration in `application.properties` with your PostgreSQL credentials.

## Usage

- Navigate to the frontend URL in your web browser to access the Foodiefy application.
- Register as a new user or log in with existing credentials to start using the application.
- Explore recipes, create new recipes, comment on recipes, and interact with other users.
