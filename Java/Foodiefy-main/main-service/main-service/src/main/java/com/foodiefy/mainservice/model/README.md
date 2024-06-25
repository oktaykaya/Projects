# Foodiefy Main Service - User Entity

This project includes the `User, Recipe, Menu, Comment, Category` entity class used in the Foodiefy application. The `User, Recipe, Menu, Comment, Category` entity represents user information stored in the database.

## Technologies Used

- Java
- Jakarta Persistence (JPA)
- Lombok

## Entity Class: User

The `User, Recipe, Menu, Comment, Category` entity class represents user data stored in the database. It includes fields such as full name, email, password, role, and a list of recipes associated with the user.

### Fields

- **id**: Unique identifier for the user (auto-generated).
- **fullName**: Full name of the user.
- **email**: Email address of the user.
- **password**: Password of the user.
- **role**: Role of the user (e.g., admin, user).
- **recipes**: List of recipes associated with the user.

### Annotations

- **@Entity**: Specifies that the class is an entity.
- **@Table(name = "users")**: Specifies the name of the database table to map this entity.
- **@Id**: Specifies the primary key of the entity.
- **@GeneratedValue**: Specifies the strategy for generating the primary key values (in this case, `IDENTITY`).
- **@Column**: Specifies the mapping of a persistent property or field to a database column.
- **@OneToMany**: Defines a one-to-many relationship with the `Recipe` entity, where each user can have multiple recipes.
- **@Builder**, **@Data**, **@AllArgsConstructor**, **@NoArgsConstructor**: Lombok annotations for automatic generation of builder, getters, setters, constructors, and other boilerplate code.

## Usage

The `User, Recipe, Menu, Comment, Category` entity is used to persist and retrieve user information in the Foodiefy application. It is managed by the Jakarta Persistence API (JPA) and integrates with the application's data access layer.

## Notes

- Ensure proper configuration of the database connection and persistence settings in `application.properties` or `persistence.xml`.
- Use JPA repositories or custom queries to perform CRUD operations on the `User` entity.
- Data validation and security measures should be implemented to protect user information.

