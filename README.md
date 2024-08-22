To execute and test the Spring Boot project you've set up, you'll need to follow these steps. This guide covers running the application, testing the API, and verifying that everything works as expected.

### 1. **Set Up Your Development Environment**

Before you start, ensure you have the following tools installed:

- **Java Development Kit (JDK):** Version 11 or later.
- **Maven or Gradle:** To manage dependencies and build the project.
- **IDE:** Such as IntelliJ IDEA, Eclipse, or VS Code (optional, but recommended for easier development).

### 2. **Build the Project**

If you’re using Maven, navigate to the project root directory in your terminal and run:

```bash
mvn clean install
```

If you’re using Gradle, you can use:

```bash
./gradlew build
```

These commands will compile your code, run tests, and package the application into a JAR file.

### 3. **Run the Application**

To run the application, you have a few options:

- **Using Maven:**

  ```bash
  mvn spring-boot:run
  ```

- **Using Gradle:**

  ```bash
  ./gradlew bootRun
  ```

- **Running the JAR file:**

  If you have built a JAR file, you can run it using:

  ```bash
  java -jar target/your-application-name.jar
  ```

  Replace `your-application-name.jar` with the actual name of the JAR file generated.

### 4. **Verify Application Startup**

After running the application, you should see output in the terminal indicating that the Spring Boot application has started successfully. Look for messages like:

```plaintext
Tomcat started on port(s): 8080 (http)
Started Application in X seconds
```

### 5. **Test the API Endpoints**

You can test the API using tools like `curl`, Postman, or directly through your browser if the API supports GET requests.

#### Using `curl`

To test the `/api/supplier/query` endpoint, you can use the following `curl` command:

```bash
curl -X POST "http://localhost:8080/api/supplier/query?location=India&natureOfBusiness=small_scale&manufacturingProcesses=3d_printing&page=0&size=10"
```

#### Using Postman

1. **Open Postman** and create a new request.
2. **Set the request type** to POST.
3. **Enter the URL**: `http://localhost:8080/api/supplier/query`.
4. **Add query parameters** to the URL (location, natureOfBusiness, manufacturingProcesses, page, size).
5. **Send the request** and review the response.

#### Using a Web Browser

For GET requests or if you've set up a GET endpoint, you can enter the URL in your browser to see the results.

### 6. **Verify the Output**

Ensure that the API returns the expected results. You should see a JSON response that lists manufacturers matching your criteria. For example:

```json
[
    {
        "supplierId": 1,
        "companyName": "Test Company",
        "website": "http://testcompany.com",
        "location": "India",
        "natureOfBusiness": "small_scale",
        "manufacturingProcesses": "3d_printing"
    }
]
```

### 7. **Check Logs for Errors**

If something goes wrong, check the logs in the terminal where you ran the application. Common issues include misconfigurations, missing dependencies, or incorrect queries.

### 8. **Run Unit Tests (Optional)**

If you’ve written unit tests, you can run them to ensure everything is working correctly:

- **Using Maven:**

  ```bash
  mvn test
  ```

- **Using Gradle:**

  ```bash
  ./gradlew test
  ```

This will execute the tests and report any failures or errors.

### 9. **Document the API (Optional)**

If you’ve set up Swagger or another documentation tool, access the documentation by visiting:

```plaintext
http://localhost:8080/swagger-ui.html
```

Replace `8080` with the port number if it differs.

### Troubleshooting Tips

- **Application Fails to Start:** Check for port conflicts, missing configurations, or dependency issues.
- **API Returns 404 or 500 Errors:** Ensure the endpoint URL is correct and review the application logs for error details.
- **Incorrect Query Results:** Verify the database content and the query logic in the `SupplierRepository`.

By following these steps, you should be able to execute, test, and verify the functionality of your Spring Boot API. If you encounter specific issues, refer to the Spring Boot documentation or error logs for further troubleshooting.
