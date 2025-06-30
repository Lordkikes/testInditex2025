# 🛍️ Inditex Product Sorting API

This project provides a robust RESTful API built with Java and Spring Boot, designed to intelligently sort products based on weighted criteria. It leverages a **hexagonal architecture** to ensure a highly decoupled, maintainable, and extensible design.

---

## ✨ Key Features

- **Sales Units:** Prioritize products with higher sales volumes.
- **Stock Ratio by Size:** Take into account the availability across sizes to promote balanced stock.
- **Weighted Sorting:** Adjust the importance of each criterion dynamically through request parameters.

---

## 🛠️ Technologies & Tools

| Tool                | Version     | Description                                      |
|---------------------|-------------|--------------------------------------------------|
| Java                | 17          | The core programming language                    |
| Spring Boot         | 3.4.7       | Framework for standalone Spring applications     |
| Spring Data JPA     | ✅          | Simplified data access via repositories          |
| MySQL               | ✅          | Relational database for storing product data     |
| MapStruct           | 1.5.5       | Code generation for object mapping               |
| Lombok              | 1.18.30     | Eliminates boilerplate code                      |
| Springdoc OpenAPI   | 2.3.0       | Swagger integration for RESTful API docs         |
| Maven               | ✅          | Build automation and dependency management       |

---

## 📐 Architecture: Hexagonal Design

This project follows a **Hexagonal Architecture (Ports and Adapters)** for clear separation of concerns.

```
src/main/java/com/testiniditex
├── application.service
│   └── ProductSorterService.java
├── domain
│   ├── model/Product.java
│   ├── port/input/SortProductUseCase.java
│   └── port/output/ProductRepository.java
│   └── service/SortProductServiceImpl.java
├── infrastructure
│   ├── controller/ProductController.java
│   ├── config/SwaggerConfig.java
│   └── repository
│       ├── entity/ProductEntity.java
│       ├── entity/ProductStockEntity.java
│       ├── entity/ProductStockId.java
│       ├── mapper/ProductEntityMapper.java
│       ├── JpaProductRepository.java
│       └── SpringDataProductRepository.java
└── resources
    ├── application.properties
    └── data.sql
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17
- Maven
- MySQL (or Docker Compose)

### Running the Project

```bash
./mvnw clean spring-boot:run
# or
mvn clean spring-boot:run
```

Access the application at: `http://localhost:8080`

---

## 🧪 Initial Data Load

The `data.sql` script initializes the `products` and `product_stock` tables with sample data.

Make sure the following is set in `application.properties`:

```properties
spring.sql.init.mode=always
```

---

## 📚 API Documentation (Swagger UI)

Access interactive documentation at:

```
http://localhost:8080/swagger-ui.html
```

---

## 📦 API Endpoint: Sort Products

**GET** `/api/products/sorted`

Retrieve a list of products sorted by weighted criteria.

### Parameters

| Name              | Type    | Required | Description                                |
|-------------------|---------|----------|--------------------------------------------|
| `salesWeight`     | double  | ✅        | Weight for sales volume                    |
| `stockRatioWeight`| double  | ✅        | Weight for stock distribution by size      |

### Example Request

```http
GET /api/products/sorted?salesWeight=0.8&stockRatioWeight=0.2
```

### Example Response

```json
[
  {
    "id": 5,
    "name": "CONTRASTING LACE T-SHIRT",
    "salesUnits": 650,
    "stockBySize": { "S": 0, "M": 1, "L": 0 }
  },
  {
    "id": 1,
    "name": "V-NECK PULLOVER",
    "salesUnits": 300,
    "stockBySize": { "S": 1, "M": 1, "L": 0 }
  }
]
```

---

API will be available at: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

MySQL runs on port 3306 with:

- Username: `root`
- Password: `rootpassword` // colocar la contraseña que usas en tu DB y ajustarlo en el aplication.properties
- DB: `productdb`

---

---

## 🧪 Ejecutar Tests

Para ejecutar los tests del proyecto, utiliza el siguiente comando:

```bash
mvn test

## ✨ Future Enhancements

- Add more sorting criteria (rating, margin, etc.)
- Pagination for large result sets
- Client-specific sorting rules
```

---

---

## 👤 Author

Developed by **Enrique Navarro**  
Senior Software Engineer 
📍 Madrid, Spain
