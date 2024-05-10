## TestPage: Automated Web Testing for Parabank

This project provides a suite of automated tests for various functionalities of the Parabank web application ([https://parabank.parasoft.com/](https://parabank.parasoft.com/)). 

### Getting Started

**Prerequisites**

* Java JDK 11 or later
* Maven
* WebDriver for your chosen browser (Chrome, Edge, etc.)

**Installation**

1. Clone this repository.
2. Download the WebDriver for your desired browser and place it in a directory accessible  to your system path.
3. Open a terminal in the project directory and run `mvn install`.

**Running Tests**

1. Open a terminal in the project directory.
2. Run `mvn test` to execute all test cases.

### Test Cases

This project includes test suites for the following functionalities:

* **Registration:** Register a new user on Parabank.
* **Login:** Login to an existing Parabank account using valid credentials.
* **Bill Payment:** Pay a bill through Parabank.
* **Open New Account:** Open a new account on Parabank.
* **Transfer Funds:** Transfer funds between accounts on Parabank.
* **Find Transactions:** Search for past transactions on Parabank.
* **Update Contact Info:** Update a user's contact information on Parabank.
* **Request Loan:** Request a loan through Parabank.
* **Log Out:** Log out of a Parabank account.

Each test case utilizes the following functionalities:

* Open a new browser session and navigate to the Parabank homepage.
* Utilize Page Objects to interact with specific elements on Parabank webpages.
* Generate  dynamic test data using Faker library.
* Assert successful execution of functionalities using TestNG assertions.
* Close the browser session after each test case execution.

### Page Objects

The project utilizes a Page Object Model (POM) design pattern to improve code maintainability and reusability. Separate Page Object classes are defined for each Parabank webpage (e.g., RegisterPage, LoginPage, etc.).
These classes encapsulate locators and functionalities specific to each page.

### Dependencies

This project uses the following external libraries:

* TestNG - A testing framework for Java.
* Selenium WebDriver - A library for automating web browsers.
* Faker - A library for generating random test data.
* Checker Framework (Optional) - A static analysis framework for Java.


