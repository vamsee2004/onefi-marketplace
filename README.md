# OneFi Marketplace

A Spring Boot based e-commerce marketplace application for browsing products, viewing EMI plans, and placing and managing orders.

## Features

- Product management
- Product variant management
- EMI plan management
- Product-wise EMI options
- Order creation
- View all orders
- Update orders
- Delete orders
- Responsive web interface
- MySQL database integration
- RESTful APIs

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- HTML
- CSS
- JavaScript
- Git
- GitHub

## Project Structure

```text

src/main/java/com/onefi/marketplace

├── controller

│   ├── ProductController.java

│   ├── ProductVariantController.java

│   ├── EmiPlanController.java

│   └── OrderController.java

│

├── entity

│   ├── Product.java

│   ├── ProductVariant.java

│   ├── EmiPlan.java

│   └── Order.java

│

├── repository

│   ├── ProductRepository.java

│   ├── ProductVariantRepository.java

│   ├── EmiPlanRepository.java

│   └── OrderRepository.java

│

└── service

&#x20;   ├── ProductService.java

&#x20;   ├── ProductVariantService.java

&#x20;   ├── EmiPlanService.java

&#x20;   └── OrderService.java



src/main/resources

└── static

&#x20;   └── index.html
