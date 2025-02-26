Here’s a list of commonly used **Spring Boot commands** for various tasks like running applications, managing dependencies, and building projects. These commands can be used in the terminal or IDE-integrated terminal.

---

### **1. Running a Spring Boot Application**
- **Run Application (using Maven)**:
  ```bash
  mvn spring-boot:run
  ```
- **Run Application (using Gradle)**:
  ```bash
  ./gradlew bootRun
  ```
- **Run JAR File**:
  ```bash
  java -jar target/<app-name>.jar
  ```

---

### **2. Generating a Spring Boot Project**
- **Using Spring Initializr (Command Line)**:
  ```bash
  curl https://start.spring.io/starter.zip \
  -d dependencies=web,jpa,h2 \
  -d name=demo \
  -d packageName=com.example.demo \
  -o demo.zip
  ```
    - Extract the ZIP file and import the project into your IDE.

---

### **3. Building the Project**
- **Build Project with Maven**:
  ```bash
  mvn clean package
  ```
- **Build Project with Gradle**:
  ```bash
  ./gradlew build
  ```
- This generates a JAR file in the `target` (Maven) or `build/libs` (Gradle) directory.

---

### **4. Running Spring Boot DevTools**
- If you have added **DevTools** to your dependencies, it allows live reloading during development:
  ```bash
  mvn spring-boot:run
  ```
    - With **DevTools** active, the application restarts automatically whenever files are changed.

---

### **5. Managing Dependencies**
- Add or remove dependencies directly in `pom.xml` (Maven) or `build.gradle` (Gradle).
- **Update Project Dependencies**:
    - Maven:
      ```bash
      mvn dependency:resolve
      ```
    - Gradle:
      ```bash
      ./gradlew dependencies
      ```

---

### **6. Running Tests**
- **Run Tests with Maven**:
  ```bash
  mvn test
  ```
- **Run Tests with Gradle**:
  ```bash
  ./gradlew test
  ```

---

### **7. Running Spring Boot in Different Profiles**
- Use the `--spring.profiles.active` property to run the application with specific profiles:
  ```bash
  mvn spring-boot:run -Dspring-boot.run.profiles=dev
  ```
  Or when running the JAR:
  ```bash
  java -Dspring.profiles.active=prod -jar target/<app-name>.jar
  ```

---

### **8. Debugging the Application**
- Run with debug mode enabled:
  ```bash
  java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar target/<app-name>.jar
  ```
- Maven:
  ```bash
  mvn spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
  ```

---

### **9. Accessing Actuator Endpoints**
- If **Spring Boot Actuator** is included, you can access endpoints like:
    - `http://localhost:8080/actuator/health`
    - `http://localhost:8080/actuator/metrics`

---

### **10. Cleaning the Project**
- **Clean Build Files**:
    - Maven:
      ```bash
      mvn clean
      ```
    - Gradle:
      ```bash
      ./gradlew clean
      ```

---

### **11. Managing Logs**
- Set the logging level directly from the command line:
  ```bash
  java -Dlogging.level.root=DEBUG -jar target/<app-name>.jar
  ```
- Or use a specific package:
  ```bash
  java -Dlogging.level.com.example=TRACE -jar target/<app-name>.jar
  ```

---

### **12. Using Custom Properties**
- Pass custom properties via the command line:
  ```bash
  java -jar target/<app-name>.jar --server.port=9090 --custom.property=value
  ```
- Maven:
  ```bash
  mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=9090 --custom.property=value"
  ```

---

### **13. Updating Dependencies**
- For Maven, use:
  ```bash
  mvn versions:use-latest-versions
  ```
- For Gradle, update `dependencies` and refresh Gradle in your IDE.

---

### **14. Running in Docker**
- If a `Dockerfile` exists, build and run the application:
  ```bash
  docker build -t spring-boot-app .
  docker run -p 8080:8080 spring-boot-app
  ```

---

Let me know if you'd like examples for any specific commands!