# OneFi Marketplace

A full-stack marketplace application built using **Spring Boot, Java, MySQL, HTML, CSS, and JavaScript**.

The application provides product management, product variants, EMI plans, and order management through REST APIs, along with a simple web-based frontend.

---

## 🚀 Features

- Product management
  - Create product
  - View all products
  - View product by ID
  - Update product
  - Delete product

- Product Variant management
  - Create variant
  - View variants
  - View variant by ID
  - Update variant
  - Delete variant

- EMI Plan management
  - Create EMI plan
  - View all EMI plans
  - View EMI plan by ID
  - Get EMI plans by product
  - Update EMI plan
  - Delete EMI plan

- Order management
  - Place order
  - View all orders
  - View order by ID
  - Update order
  - Delete order

- Frontend
  - Product listing
  - Product details
  - EMI selection
  - Place order
  - My Orders
  - Update order
  - Delete order

---

## 🛠️ Technologies Used

### Backend
- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven

### Database
- MySQL 8

### Frontend
- HTML5
- CSS3
- JavaScript

### Development Tools
- Eclipse
- Git
- GitHub
- PowerShell

---

## 📁 Project Structure

```text
marketplace/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── onefi/
│   │   │           └── marketplace/
│   │   │               ├── controller/
│   │   │               ├── entity/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               └── MarketplaceApplication.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html
│   │       ├── application-example.properties
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
