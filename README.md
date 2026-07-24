# Playwright Java QA Automation

QA Automation practice project using Playwright with Java, Maven, JUnit 5, Git, and GitHub.


## About this project

The goal of this project is to practice web UI automation and build a professional QA Automation portfolio project.

As a QA Engineer with experience in manual testing and API testing, this project helps me strengthen my automation skills by converting manual test scenarios into automated tests.


\## Technologies used

- Java 21

- Maven

- Playwright

- JUnit 5

- Git

- GitHub

- IntelliJ IDEA



\## What this project covers

- Basic Playwright actions

- Browser navigation

- Locators

- Form filling

- Button clicks

- Text validation

- Login scenarios

- Positive and negative testing

- UI interactions

- Checkboxes

- Dropdowns

- JavaScript alerts

- Data-driven testing

- Page Object Model

- Base test setup



\## Project structure

```text

src
└── test
    └── java
        ├── base
        │   └── BaseTest.java
        ├── config
        │   └── TestConfig.java
        ├── data
        │   └── LoginTestData.java
        ├── pages
        │   └── LoginPage.java
        ├── practice
        │   ├── FirstTest.java
        │   ├── LoginTests.java
        │   ├── MiniTest.java
        │   └── PlaywrightBasicsTests.java
        └── tests
            ├── AssertionsTest.java
            ├── DataDrivenLoginTests.java
            ├── LoginPageObjectTest.java
            ├── ScreenshotTest.java
            ├── TraceViewerTest.java
            └── UIInteractionsTests.java




Test scenarios documentation

Test scenarios are documented here:
docs/test-scenarios.md



How to run the tests
From the project root folder, run:
mvn test

To clean previous build files and run tests:
mvn clean test





Design pattern

This project uses the Page Object Model pattern to keep test code cleaner, reusable, and easier to maintain.



Example:

LoginPage.java contains login page locators and actions.

LoginTests.java contains test validations.

BaseTest.java contains browser setup and teardown.



Current automated scenarios

Open page and validate title

Validate visible text

Fill login fields

Valid login

Invalid login

Data-driven invalid login scenarios

Checkbox interaction

Dropdown selection

JavaScript alert handling





Author

Carolina Aguilera

Senior QA Engineer | Manual Testing | API Testing | Agile | CI/CD | Learning QA Automation

