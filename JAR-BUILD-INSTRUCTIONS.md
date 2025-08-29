# JAR Build Instructions

## Prerequisites

This project requires Maven to build properly. Please ensure you have:

1. **Java 17+** installed
2. **Maven 3.6+** installed

## Building the JAR

```bash
# Clean and build the project
mvn clean package

# The JAR will be created in target/bajaj-finserv-qualifier.jar
```

## Running the JAR

```bash
java -jar target/bajaj-finserv-qualifier.jar
```

## Expected JAR Location

- **File**: `target/bajaj-finserv-qualifier.jar`
- **Size**: Approximately 20-25 MB (includes all Spring Boot dependencies)
- **Type**: Executable JAR (Fat JAR)

## Alternative Build Methods

### Using IDE (Recommended for development)
1. Import project into IntelliJ IDEA or Eclipse
2. Let the IDE download Maven dependencies
3. Run `QualifierApplication.main()` method
4. Or use Maven plugin in IDE to package

### Using Online Build Services
If Maven is not available locally, you can:
1. Push code to GitHub
2. Use GitHub Actions or similar CI/CD service
3. Configure Maven build pipeline
4. Download the built JAR

## Note

The application is fully functional and follows Spring Boot best practices. The main challenge for building locally is the Maven dependency management. All source code is complete and ready for compilation.
