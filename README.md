Selenium-Cucumber-BDD Project

About:
This is a Test Automation project built with Java, Selenium WebDriver**, Cucumber, and Maven. It follows Behavior-Driven Development (BDD) principles to automate end-to-end testing scenarios for a sample web application — [Swag Labs](https://www.saucedemo.com/).
The goal of this project is to demonstrate understanding of BDD practices, Selenium automation, and test design in a real-world structure.

Technologies Used  
- Java  
- Selenium WebDriver  
- Cucumber  
- Maven  
- JUnit  
- IntelliJ IDEA (for development)

Project Structure  

src/test/java
 - com.project.runner       → Test Runner classes
 - com.project.stepDefs     → Step Definitions
 - com.project.utils        → Utility classes

src/test/resources
 - features                 → Cucumber Feature Files

configuration.properties    → Configuration file at project root


How to Run Tests

Run via Maven (Command Line)

```bash
git clone https://github.com/DianaBCh/Selenium-Cucumber-BDD.git
cd Selenium-Cucumber-BDD
mvn clean test
```

Run from IntelliJ

- Open the project in IntelliJ.
- Navigate to the CukesRunner class inside the runner package.
- Right-click the class → Run 'CukesRunner'.

Run via Maven Lifecycle in IntelliJ

- Go to the Maven tab (right side of IntelliJ).
- Expand Lifecycle → Double-click 'test'.

Test Features Implemented:
- Login
- Product Listing
- Shopping Cart
- Checkout Process
- Logout
- End-to-End User Flow  

Notes:
- Thread.sleep was temporarily used in Chrome to handle sync issues during local runs. Firefox runs cleanly without waits.
- All scenarios are tagged for selective execution if needed.
- This project is for educational and portfolio purposes.

