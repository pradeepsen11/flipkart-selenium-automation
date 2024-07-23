# Selenium Java Automation Project for Flipkart

## Overview
This repository contains a comprehensive Selenium Java automation project for automating functionalities on the Flipkart application's homepage. The project is built using Page Object Model (POM) for maintainability and Extent Reports for detailed test reporting. It is integrated with Jenkins for automated testing through pipelines.

## Important Note:
- **Test Cases are attached in TestCaseDocument.xlsx**
- To view detailed Extent Reports, please save extent report to your system **Go to ExtentReports-->Right click on ExtentReportResult.html--> Save link as...**

## Key Features
- **Page Object Model (POM):** Organizes web elements and their operations into reusable classes, enhancing code readability and maintenance.
- **Extent Reports:** Provides detailed and visually appealing test reports, showcasing test results and insights.
- **Jenkins Pipeline Integration:** Enables continuous integration and automated testing, ensuring robust test execution on each commit.
- **Git Repository:** Hosted on Git for version control, allowing collaboration and transparency in project development.

## Automation Scenarios
The automation project currently includes scenarios such as:
- Logging into the Flipkart application.
- Performing search operations for products.
- Verifying product details and functionalities on the homepage.

## Getting Started
To set up the project locally and run tests:

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   ```

2. **Install dependencies using Maven:**
   ```bash
   mvn clean install
   ```

3. **Run tests using Maven:**
   ```bash
   mvn test
   ```

4. **View Extent Reports for test results and insights.**

## Jenkins Pipeline
The project is configured to run automated tests through Jenkins pipelines on each commit. Jenkins is integrated to trigger tests and generate reports automatically.

## Future Enhancements
Future plans for this project include:
- Adding more test scenarios covering different functionalities of the Flipkart application.
- Enhancing test coverage and reliability through parameterization and data-driven testing.
- Integrating with additional tools for enhanced reporting and monitoring.