In a Spring Boot application, authorized user details can be saved or managed in multiple ways, depending on the authentication mechanism used. Here are the common places and mechanisms where user details are saved or managed:

---

### **1. In-Memory Authentication**
- **Where saved:** User details are stored in memory during application runtime.
- **How configured:**
  Using `InMemoryUserDetailsManager`.
  ```java
  @Configuration
  public class SecurityConfig extends WebSecurityConfigurerAdapter {
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.inMemoryAuthentication()
              .withUser("user").password("{noop}password").roles("USER")
              .and()
              .withUser("admin").password("{noop}admin").roles("ADMIN");
      }
  }
  ```
- **Use case:** Suitable for testing or small applications without a persistent user store.

---

### **2. Database Authentication**
- **Where saved:** User details are fetched from a relational database (e.g., MySQL, PostgreSQL).
- **How configured:**
  Using `JdbcUserDetailsManager` or a custom `UserDetailsService` with queries to fetch user credentials.
  ```java
  @Service
  public class CustomUserDetailsService implements UserDetailsService {
      @Autowired
      private UserRepository userRepository;

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user = userRepository.findByUsername(username)
                  .orElseThrow(() -> new UsernameNotFoundException("User not found"));
          return new org.springframework.security.core.userdetails.User(
                  user.getUsername(),
                  user.getPassword(),
                  Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
          );
      }
  }
  ```
- **Database Schema Example:**
  ```sql
  CREATE TABLE users (
      username VARCHAR(50) PRIMARY KEY,
      password VARCHAR(100),
      enabled BOOLEAN
  );

  CREATE TABLE authorities (
      username VARCHAR(50),
      authority VARCHAR(50),
      FOREIGN KEY (username) REFERENCES users(username)
  );
  ```

---

### **3. JWT Token (Stateless Authentication)**
- **Where saved:** User details are encoded in the JWT token itself, which is stored client-side (e.g., browser/local storage).
- **How configured:**
  Use Spring Security with JWT.
  ```java
  public String generateToken(UserDetails userDetails) {
      return Jwts.builder()
              .setSubject(userDetails.getUsername())
              .claim("roles", userDetails.getAuthorities())
              .setIssuedAt(new Date())
              .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
              .signWith(SignatureAlgorithm.HS256, secretKey)
              .compact();
  }
  ```
    - The token is sent with every request in the `Authorization` header.
      ```http
      Authorization: Bearer <JWT_TOKEN>
      ```

- **Use case:** Ideal for stateless applications or distributed systems.

---

### **4. Session-Based Authentication**
- **Where saved:** User details are saved in the HTTP session on the server.
- **How configured:**
  Spring Security handles session management automatically by default. User details are stored in the session after authentication.

    - Example:
      ```java
      SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      ```

- **Use case:** Suitable for stateful applications.

---

### **5. OAuth2/OpenID Connect Authentication**
- **Where saved:** User details are fetched from an external Identity Provider (IDP) like Google, Okta, or Keycloak.
- **How configured:**
  Using Spring Boot's OAuth2 client support.
  ```yaml
  spring:
    security:
      oauth2:
        client:
          registration:
            google:
              client-id: <client-id>
              client-secret: <client-secret>
              scope: profile, email
  ```
    - The user details are fetched from the IDP and stored in `SecurityContext`.

- **Use case:** Suitable for applications relying on external authentication providers.

---

### **6. Custom Storage (e.g., Redis, NoSQL)**
- **Where saved:** User details can be saved in custom storage like Redis, MongoDB, etc., for scalability.
- **How configured:**
  Implement custom `UserDetailsService` and save user sessions or tokens in the desired storage.

---

### **Accessing User Details After Authentication**

Once a user is authenticated, their details are available in the `SecurityContext`.

```java
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
UserDetails userDetails = (UserDetails) authentication.getPrincipal();
System.out.println("Username: " + userDetails.getUsername());
```

---

### Summary Table

| Storage Location       | Mechanism                              | Use Case                                    |
|------------------------|---------------------------------------|--------------------------------------------|
| In-Memory             | `InMemoryUserDetailsManager`          | Testing or small apps                      |
| Relational Database   | `JdbcUserDetailsManager` or custom    | Persistent user store                      |
| JWT Token             | Stateless authentication              | Stateless and distributed applications     |
| HTTP Session          | Spring Security default session       | Stateful applications                      |
| External IDP          | OAuth2 or OpenID Connect              | Third-party authentication (e.g., Google) |
| Custom Storage        | Redis, MongoDB, etc.                  | Scalability and custom requirements        |

The method used depends on the application's requirements and architecture.