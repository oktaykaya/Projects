# Contacts List Application

This is a simple Contacts List application built using React. The application allows users to add, view, and manage their contacts. Contacts can be marked as active or completed.

## Components

### `Form` Component
The `Form` component is used to add new contacts to the contacts list. It consists of input fields for the contact's full name and phone number, and an "Add" button. When a contact is added, it is appended to the list of contacts.

### `List` Component
The `List` component displays all contacts and allows the user to toggle the completion status of a contact by clicking on it. It has a button to toggle the visibility of all contacts.

### `Contacts` Component
The `Contacts` component is the main component that manages the state of the contacts list. It uses the `useState` hook to maintain the list of contacts and the `useEffect` hook to log the contacts whenever they change. This component renders both the `List` and `Form` components.


<img width="437" alt="Screen Shot 2024-06-25 at 21 08 25" src="https://github.com/oktaykaya/Projects/assets/74820176/f828188f-a8c8-4a86-9e96-18923a1c2a95">
