# 🚀 Selenium Test Automation Framework

This project is a **Java-based Selenium Test Automation Framework** built with industry-standard practices.  
It is designed to be scalable, reusable, and maintainable for web UI testing.

---

## 📂 Project Structure
```

├── src
│ ├── main
│ │ ├── java
│ │ │ ├── config # Configuration files (config.properties)
│ │ │ ├── pages # Page classes (POM with BasePage)
│ │ │ ├── utils # Utility classes (e.g., ConfigReader)
│ │ │ └── base # Driver setup (WebDriver Manager)
│ └── test
│ │ ├── java
├── reports
└── pom.xml # Maven dependencies
```

---

## 🛠️ Tech Stack

- **Language**: Java  
- **Test Framework**: TestNG  
- **Automation Tool**: Selenium WebDriver  
- **Design Pattern**: Page Object Model (POM) with PageFactory  
- **Build Tool**: Maven  
- **Browser Management**: WebDriverManager  

---

## Install dependencies

mvn clean install

Run tests

mvn test

---

## 📖 Framework Highlights

ConfigReader → Reads properties like browser and app.url.

BasePage → Reusable Selenium methods (click, type, wait, etc.).

Page Classes → Encapsulate page-specific locators and actions (POM with PageFactory).

DriverManager → Initializes and manages WebDriver instances.

Test Classes → Contain actual test logic, keep them clean and readable.

---

## ✅ Best Practices Followed

Separation of Concerns → Pages, Tests, Utilities are independent.

Reusability → Common actions handled in BasePage.

Maintainability → Configurable properties, easy to extend for new tests.

Scalability → Supports multiple browsers.

---

## 📌 Future Enhancements

Add logging (e.g., Log4j / SLF4J).

Add reporting (e.g., Extent Reports or Allure).

Integrate with CI/CD pipeline (GitHub Actions / Jenkins).

Add parallel test execution support.

## ⚙️ Configuration

All test configuration is maintained in `config/config.properties`.

Example:

```properties
browser=chrome
app.url=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

How to Run Tests

Clone the repository

git clone <repo-url>
cd selenium-framework


