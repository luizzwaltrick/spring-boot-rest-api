# todo-api

A minimal RESTful API for managing TODO items, built with Spring Boot. This project is intended as a simple starting point to explore Spring Boot, JPA, and an in-memory H2 database.

## Tech stack
- Java 17
- Spring Boot 3
  - Spring Web
  - Spring Data JPA
- H2 Database (runtime)
- Maven
- Lombok (optional)

## Prerequisites
- Java 17 (or a JDK compatible with your configured `java.version`)
- Maven (or use the provided Maven Wrapper)

## Getting started

### 1) Clone the repo
```
git clone https://github.com/<your-username>/todo-api.git
cd todo-api
```

### 2) Run the app
Using Maven Wrapper (recommended):
- Windows:
```
mvnw.cmd spring-boot:run
```
- macOS/Linux:
```
./mvnw spring-boot:run
```

Or with a local Maven installation:
```
mvn spring-boot:run
```

The application starts on `http://localhost:8080` by default.

### 3) H2 Console (optional)
The project uses an in-memory H2 database at runtime. If enabled in `src/main/resources/application.yaml`, you can open the H2 console at:
```
http://localhost:8080/h2-console
```

## Configuration
Main config file:
```
src/main/resources/application.yaml
```
Adjust server port, H2 console visibility, or datasource settings as needed.

## API
This is a basic starter; endpoints/controllers may evolve. If you add controllers, document them here. Example structure you might implement:
- `GET /api/todos` – list all todos
- `POST /api/todos` – create a todo
- `GET /api/todos/{id}` – get a todo by id
- `PUT /api/todos/{id}` – update a todo
- `DELETE /api/todos/{id}` – delete a todo

## Build and test
- Build:
```
./mvnw clean package
```
- Run tests:
```
./mvnw test
```
(Windows users can use `mvnw.cmd` instead of `./mvnw`.)

## Project structure
```
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com.github.luizzwaltrick.todo.todo_api
│  │  │     └─ TodoApiApplication.java
│  │  └─ resources
│  │     └─ application.yaml
│  └─ test
│     └─ java
│        └─ com.github.luizzwaltrick.todo.todo_api
│           └─ TodoApiApplicationTests.java
├─ pom.xml
├─ README.md
└─ LICENSE
```

## Troubleshooting
- If Lombok-related errors occur in your IDE, ensure Lombok annotation processing is enabled and the Lombok plugin is installed.
- If port 8080 is in use, change it in `application.yaml`:
```
server:
  port: 8081
```

## License
This project is open source. See the [LICENSE](LICENSE) file for details.

## Acknowledgements
- Spring Initializr
- Spring Boot, H2, and Lombok communities
