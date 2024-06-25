# Playwright Test for App

This repository contains automated tests using Playwright for a web application. The tests are designed to automate the user journey through various steps of the application.

## Description

The tests simulate user interactions with the application to perform tasks such as logging in, creating elevators, selecting components, and completing forms.

## Tests Overview

### Login Test

- Navigate to the login page.
- Accept cookies.
- Enter credentials and log in.

### Elevator Creation Test

- Select a building and create a new elevator.
- Fill out elevator details including name, supervisor, and serial number.
- Proceed to the next steps until completion.

### Component Selection Test

- Select elevator class, shaft details, and number of floors.
- Choose components such as suspension type and drawing template.

### Door and Cabin Configuration Test

- Configure doors and cabin specifications.
- Choose door types and cabin components.

### Motor and Safety Test

- Select motor type and configure safety measures.
- Choose safety gear and other components.

### Compensation Chain and Flexible Test

- Configure balance chain options and flexible components.
- Draw configurations.

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/playwright-test.git
   cd playwright-test
