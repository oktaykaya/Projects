# Foodiefy Main Service API

This project contains Spring Boot API controllers for managing users, categories, menus, and recipes in the Foodiefy application backend.

## Technologies Used

- Java
- Spring Boot
- Maven

## Project Structure

The project includes the following controller classes:

- **CategoryController:** Handles operations related to categories.
- **MenuController:** Manages operations related to menus.
- **RecipeController:** Handles operations related to recipes.
- **UserController:** Manages operations related to users.

Each controller class handles HTTP requests using respective DTOs (Data Transfer Objects) and Service classes.

## API Endpoints

### Category Controller

- **GET /category/all**: Lists all categories.
- **GET /category/{id}**: Retrieves a specific category by ID.
- **POST /category/create**: Adds a new category.
- **PUT /category/update/{id}**: Updates an existing category.
- **DELETE /category/delete/{id}**: Deletes a specific category.

### Menu Controller

- **GET /menu/all**: Lists all menus.
- **GET /menu/{id}**: Retrieves a specific menu by ID.
- **POST /menu/create**: Adds a new menu.
- **PUT /menu/update/{id}**: Updates an existing menu.
- **DELETE /menu/delete/{id}**: Deletes a specific menu.

### Recipe Controller

- **GET /recipe/all**: Lists all recipes.
- **GET /recipe/{id}**: Retrieves a specific recipe by ID.
- **POST /recipe/create**: Adds a new recipe.
- **PUT /recipe/update/{id}**: Updates an existing recipe.
- **DELETE /recipe/delete/{id}**: Deletes a specific recipe.

### User Controller

- **GET /user/all**: Lists all users.
- **GET /user/{id}**: Retrieves a specific user by ID.
- **POST /user/create**: Adds a new user.
- **PUT /user/update/{id}**: Updates an existing user.
- **DELETE /user/delete/{id}**: Deletes a specific user.

## Getting Started

Before running the project, follow these steps:

1. Install Java and Maven.
2. Open your IDE (e.g., IntelliJ IDEA, Eclipse) and import the project folder.
3. Configure necessary database settings in `application.properties`.
4. Start the application either from your IDE or using the command `mvn spring-boot:run` in the terminal.

## Notes

- Each controller class injects its respective service class to manage business logic.
- Postman or similar API development environments can be used to test the functionality of endpoints.
- Ensure security measures and data validation are in place during development or before deployment.

