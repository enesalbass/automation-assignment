About This Project

This project is a simple Selenium test automation framework built with Java. It was created as part of an assignment to automate test scenarios on multiple websites using the same structure.

The project currently supports 3 different websites:

- SauceDemo
- Demoblaze
- The Internet (Floating Menu page)

Technologies Used

- Java 17
- Selenium
- JUnit 5
- Maven

Project Structure

Each website has its own:

- pages
- tests
- properties file

The framework uses a common BaseTest and BasePage structure to keep the code organized.

How to Run Tests

Tests are executed using Maven with site and tag parameters.

For SauceDemo:

mvn clean test -Dsite=saucedemo -Dtags=saucedemo

For Demoblaze:

mvn clean test -Dsite=demoblaze -Dtags=demoblaze

For Herokuapp:

mvn clean test -Dsite=herokuapp -Dtags=herokuapp

Test Coverage

SauceDemo

- Login tests (positive & negative)
- Add to cart
- Checkout process

Demoblaze

- Add product to cart
- Cart validation

Herokuapp (Floating Menu)

- Scroll behavior test
- Menu visibility test
