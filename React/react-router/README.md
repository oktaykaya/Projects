# React Users App

This is a simple React application that demonstrates fetching and displaying a list of users from an API (`jsonplaceholder.typicode.com`). Users can click on each user's name to view their details and navigate to the next user using the provided link.

## Components

### `Users` Component

The `Users` component fetches a list of users from the API and displays them as a list of links. Each link leads to the `User` component for the corresponding user's details.

- **Routes:**
  - `/users`: Displays a list of users fetched from the API.
  - `/users/:id`: Displays details of a specific user based on the `id` parameter.

### `User` Component

The `User` component fetches and displays detailed information about a specific user based on the `id` parameter from the URL.

- **Routes:**
  - `/users/:id`: Displays detailed information about the user with the given `id`.
  - `/users/:id`: Provides a link to navigate to the next user's details (next `id`).
