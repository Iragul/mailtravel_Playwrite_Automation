# mailtravel_Automation
# playwright Automation Framework for Mailtravel

## Overview
This repository contains a playwright-based automation framework for testing Mailtravel. The framework is designed to provide a structured and maintainable way to write and execute automated tests using Cucumber, Selenium, and Playwright.

## Features
- **Cucumber:** Utilizes the Cucumber framework for writing behavior-driven tests.
- **Selenium:** Integrates Selenium for web automation.
- **Playwright:** Incorporates Playwright for end-to-end testing of web applications.
- **Page Object Model (POM):** Follows the POM design pattern for better code organization and maintenance.
- **Extent Reports:** Utilizes Extent Reports for generating detailed and interactive test reports.

## Prerequisites
- Java 17 or higher
- Maven 3.8.8
- Playwright
- Cucumber

## Getting Started
1. Clone this repository to your local machine.
2. Install the necessary dependencies by running:
    ```bash
    mvn clean install
    ```
3. Run the tests using the following command:
    ```bash
    mvn test
    ```

## Folder Structure
- **src/main/java:** Contains the core framework code with page object model playwright.
- **src/main/resources:** Includes configuration files, Cucumber feature files and step definitions, chromedriver, and Playwright setup.
- **src/test/java:** Contains the testcase runner code.

## Configuration
Update the `src/main/resources/ObjectRepository` file with your test details, such as the application URL, XPath path of objects, etc.

## Reporting
Test reports are generated in the `src/main/resources/Extent_Report/Report.html` directory after each test run.

## Contributing
Feel free to contribute to the development of this framework. Fork the repository, make your changes, and submit a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
