# Selenium WebDriver Test Automation Framework - SauceDemo

This project implements a **test automation framework** for the SauceDemo web application using **Selenium WebDriver**, **Java**, and **TestNG**, applying **design patterns**, **Page Object Model (POM)**, and **SOLID principles**.

The framework supports **multi-browser execution**, **logging**, **test data externalization**, and **test suites separation (Smoke & Regression)**.

---

# 🚀 Features

* Selenium WebDriver automation
* TestNG test runner
* Page Object Model (POM)
* Design Patterns implementation
* WebDriverManager for driver handling
* Multi-browser support (Chrome & Edge)
* Environment-based configuration (dev / qa)
* Logging with Log4j2 (console + file)
* Screenshot capture on test failure
* Smoke & Regression test suites
* Externalized test data (properties files)
* Centralized error handling (clean test methods)

---

# 📋 Test Scenarios

### ✅ Test Case 1: Login with valid credentials

* Open login page
* Enter valid username and password
* Click login
* Validate successful navigation to homepage ("Swag Labs")

---

### 🛒 Test Case 2: Add product to cart

* Login with valid credentials
* Add a product to the cart
* Validate cart badge count is updated

---

### 💳 Test Case 3: Complete checkout process

* Login with valid credentials
* Add product to cart
* Navigate to cart
* Proceed to checkout
* Fill checkout form
* Complete purchase
* Validate confirmation message: **"Thank you for your order!"**

---

# 🏗️ Project Architecture

```
src
├── main
│ └── java
│ └── com.epam.training.student_ulises_lara.model
│ ├── User.java
│ └── CheckoutData.java 
│
├── test
│ ├── java
│ │ ├── base
│ │ │ └── BaseTest.java
│ │ ├── driver
│ │ │ ├── DriverSingleton.java
│ │ │ └── factory
│ │ │ ├── WebDriverFactory.java
│ │ │ ├── ChromeDriverFactory.java
│ │ │ └── EdgeDriverFactory.java
│ │ ├── decorator
│ │ │ ├── ElementActions.java
│ │ │ ├── BaseElementActions.java
│ │ │ └── LoggingDecorator.java
│ │ ├── page
│ │ │ ├── BasePage.java
│ │ │ ├── LoginPage.java
│ │ │ └── HomePage.java
│ │ ├── service
│ │ │ └── TestDataReader.java
│ │ ├── tests
│ │ │ ├── LoginTest.java
│ │ │ ├── CartTest.java
│ │ │ └── CheckoutTest.java
│ │ └── utils
│ │ └── ScreenshotUtils.java
│
│ └── resources
│ ├── dev.properties
│ ├── qa.properties
│ └── log4j2.xml
│
├── testng-smoke.xml
├── testng-regression.xml
├── pom.xml
└── README.md
```

---

# ⚙️ Configuration

### Environments

The framework supports multiple environments using properties files:

* `dev.properties` → Chrome
* `qa.properties` → Edge

---

# 🌐 Browser Configuration

Browser is configured dynamically via environment:

```bash
-Denvironment=dev   → Chrome
-Denvironment=qa    → Edge
```

Handled inside `DriverSingleton`.

---

# ▶️ How to Run Tests

### Run all tests

```bash
mvn clean test
```

---

### Run Smoke tests

```bash
mvn clean test -DsuiteXmlFile=testng-smoke.xml
```

---

### Run Regression tests

```bash
mvn clean test -DsuiteXmlFile=testng-regression.xml
```

---

### Run with specific environment

```bash
mvn clean test -Denvironment=qa
```

---

# 📊 Logging

* Implemented using **Log4j2**
* Logs include:

  * Test start/end
  * Step execution (Page Objects)
  * Validation results
  * Errors

Logs are written to:

* Console
* File (daily logs in `/logs`)

---

# 📸 Screenshots

* Automatically captured on test failure
* Stored in `/screenshots` folder
* Path is logged in test output

---

# 🧪 Test Suites

### Smoke Suite

* Basic functionality
* Fast execution

### Regression Suite

* Full test coverage
* Includes checkout flow

---

# 🧠 Design Patterns Used

* Page Object Model (POM)
* Singleton (Driver management)
* ThreadLocal (parallel execution ready)
* Factory Method (Implemented via WebDriverFactory interface to encapsulate browser creation logic and support extensibility without modifying existing code)
* Decorator (Implemented via ElementActions interface to enhance element interactions with logging and highlighting without modifying base functionality)
* Builder (Implemented in CheckoutData to provide a flexible and readable way to create test data objects)

---

# 👨‍💻 Author

- Student: Ulises Lara
- Program: EPAM Java Automation Specialization
- Project: Module 8 TA Frameworks: Layers, Runner, Business Objects And Module 9 Design Patterns in TA Frameworks Implementation

