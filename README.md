# Spring Boot CRUD API with H2 Database

A RESTful CRUD (Create, Read, Update, Delete) API built with Spring Boot and H2 in-memory database, featuring POST operations for data creation.

## Configuration

### application.properties

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console (available at http://localhost:8080/h2-console)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.port=8080
```

### Maven Dependencies (pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Features

- **Complete CRUD Operations**: Create, Read, Update, and Delete entities
- **REST API Endpoints**: RESTful web services with JSON responses
- **H2 In-Memory Database**: Fast, lightweight database for development and testing
- **Spring Data JPA**: Simplified data access layer
- **Spring Boot**: Auto-configuration and embedded server
- **POST Endpoint**: Create new records via HTTP POST requests
- **H2 Console**: Web-based database management interface

## Technologies Used

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database**
- **Maven** (or Gradle)
- **Spring Web**

## Prerequisites

- Java 17 or higher
- Maven 3.6+ or Gradle 7+
- IDE (IntelliJ IDEA, Eclipse, VS Code)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/crud/
│   │       ├── CrudApplication.java
│   │       ├── controller/
│   │       │   └── EntityController.java
│   │       ├── model/
│   │       │   └── Entity.java
│   │       ├── repository/
│   │       │   └── EntityRepository.java
│   │       └── service/
│   │           └── EntityService.java
│   └── resources/
│       ├── application.properties
│       └── data.sql (optional)
└── test/
    └── java/
        └── com/example/crud/
            └── CrudApplicationTests.java
```



## API Endpoints

### Base URL: `http://localhost:8080/api/entities`

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| `GET` | `/` | Get all entities | - |
| `GET` | `/{id}` | Get entity by ID | - |
| `POST` | `/` | Create new entity | JSON |
| `PUT` | `/{id}` | Update entity | JSON |
| `DELETE` | `/{id}` | Delete entity | - |

### Sample Entity JSON

```json
{
  "name": "Sample Entity",
  "description": "This is a sample entity",
  "active": true
}
```

## API Usage Examples

### Create Entity (POST)

```bash
curl -X POST http://localhost:8080/api/entities \
  -H "Content-Type: application/json" \
  -d '{
    "name": "New Entity",
    "description": "Created via POST request",
    "active": true
  }'
```

### Get All Entities

```bash
curl -X GET http://localhost:8080/api/entities
```

### Get Entity by ID

```bash
curl -X GET http://localhost:8080/api/entities/1
```

### Update Entity

```bash
curl -X PUT http://localhost:8080/api/entities/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Entity",
    "description": "Updated via PUT request",
    "active": false
  }'
```

### Delete Entity

```bash
curl -X DELETE http://localhost:8080/api/entities/1
```

## Database Access

### H2 Console

Access the H2 database console at: `http://localhost:8080/h2-console`

**Connection Settings:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## Testing

### Run Tests

```bash
# Maven
mvn test

# Gradle
./gradlew test
```

### Sample Test Data

You can add sample data by creating a `data.sql` file in `src/main/resources/`:

```sql
INSERT INTO entity (name, description, active) VALUES 
('Sample Entity 1', 'First sample entity', true),
('Sample Entity 2', 'Second sample entity', false),
('Sample Entity 3', 'Third sample entity', true);
```

## Response Format

### Success Response

```json
{
  "id": 1,
  "name": "Entity Name",
  "description": "Entity Description",
  "active": true,
  "createdAt": "2023-12-01T10:30:00",
  "updatedAt": "2023-12-01T10:30:00"
}
```

### Error Response

```json
{
  "timestamp": "2023-12-01T10:30:00.123+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Entity not found with id: 1",
  "path": "/api/entities/1"
}
```

## Status Codes

- `200 OK` - Successful GET, PUT requests
- `201 Created` - Successful POST request
- `204 No Content` - Successful DELETE request
- `400 Bad Request` - Invalid request data
- `404 Not Found` - Entity not found
- `500 Internal Server Error` - Server error

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Troubleshooting

### Common Issues

1. **Port 8080 already in use**
   - Change the port in `application.properties`: `server.port=8081`

2. **H2 Console not accessible**
   - Ensure `spring.h2.console.enabled=true` in configuration

3. **Database connection issues**
   - Verify H2 dependency is included
   - Check datasource URL format

### Support

For questions and support, please open an issue in the GitHub repository.

---

**Happy Coding!**
