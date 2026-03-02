## REST DSL Generator

A Domain-Specific Language (DSL) and code generation tool for automatically creating Spring Boot REST API projects from a textual specification.

### Overview

This project demonstrates language engineering concepts including DSL design, parsing, metamodeling, and code generation. 
Users define REST services in a custom DSL, and the tool generates corresponding Spring Boot controllers, DTOs, and project structure.

The goal is to reduce boilerplate code and improve developer productivity by allowing APIs to be described declaratively.

### Example DSL
service UserService {

endpoint GET /users -> List<User>

endpoint POST /users(UserRequest) -> User

}
### Generated Output

The generator produces:

Spring Boot Controllers

Request/Response DTO classes

Project structure

Optional configuration files

### Architecture

The project consists of the following main components:

Grammar (ANTLR)
Defines the syntax of the DSL.

Parser
Converts DSL text into a parse tree.

Metamodel
Java object representation of services and endpoints.

Code Generator
Produces Spring Boot source files from the metamodel.

CLI Tool
Command-line interface to run the generator.

### Technology Stack

Java 21,
Maven,
ANTLR4,
Spring Boot (generated output),
PlantUML for diagrams,

### How It Works
DSL File → Parser → Metamodel → Code Generator → Spring Boot Project
#### Usage

1. Write a DSL file:

service UserService {
endpoint GET /users -> User
}

2. Run the generator:

java -jar rest-dsl-generator.jar api.dsl

3. Generated Spring Boot project will be created in the output directory.


### Future Improvements

OpenAPI/Swagger generation

Validation annotations

Database integration

IntelliJ plugin for DSL syntax highlighting

Web-based generator UI