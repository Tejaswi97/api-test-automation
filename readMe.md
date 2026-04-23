# 🚀 API Automation Framework (RestAssured + TestNG)

## 📌 Overview

This project is a **scalable API Automation Framework** built using **Java, RestAssured, and TestNG**.
It covers end-to-end API testing including **CRUD operations, data-driven testing, and validation strategies**.

The framework is designed following **industry best practices** to ensure maintainability, reusability, and scalability.

---

## 🛠️ Tech Stack

* Java
* RestAssured
* TestNG
* Maven

---

## 📂 Project Structure

```
src\test\java
 ├── base
 │    └── BaseTest.java
 ├── endpoints
 │    └── Routes.java
 ├── payloads
 │    └── ProductPayload.java
 ├── tests
 │    └── Products.java
 
```

---

## ✅ Features Implemented

### 🔹 API Testing

* GET (Single & List)
* POST (Create resource)
* PUT & PATCH (Update resource)
* DELETE (Remove resource)

### 🔹 Validations

* Status code validation
* Response body validation
* JSON parsing using JsonPath
* Data type & field validation

### 🔹 Data-Driven Testing

* Implemented using **TestNG DataProvider**
* Supports multiple datasets for API validation
* Covers both **positive & negative scenarios**

### 🔹 Logging

* Request & Response logging using RestAssured

---

## 🧪 Sample Test Scenario

* Create a product using POST API
* Validate response fields
* Extract product ID
* Use ID in GET API for validation

---

## ▶️ How to Run Tests

### Using Maven:

```
mvn clean test
```

### Using IDE:

* Right-click on test class → Run as TestNG test

---

## 📊 Test Coverage

* Functional testing (CRUD APIs)
* Negative scenarios (invalid inputs, endpoints)
* Data-driven testing
* API chaining (Create → Get → Validate)

---

## 🔮 Future Enhancements

* JSON Schema Validation
* Allure / Extent Reports
* CI/CD integration (GitHub Actions)
* Environment configuration (dev/qa/prod)
* Integration with external test data (Excel/JSON)

---

## 💡 Key Highlights

* Clean and modular framework design
* Reusable components (BaseTest, Routes, Payloads)
* Industry-standard API testing practices
* Easily extendable for real-world projects

---

## 👨‍💻 Author

Tejaswi Vishnubhatla | Java | Selenium | API Testing

---
