In Spring Security, the `HttpSecurity` class provides methods for configuring **authentication** (who can log in) and **authorization** (who can access what resources). Here is a list of common methods for both **authorization** and **authentication** in `HttpSecurity`:

---

### **Authentication Methods in HttpSecurity**
These methods configure how users are authenticated.

1. **`httpBasic()`**
    - Configures HTTP Basic Authentication.
    - Example:
      ```java
      http.httpBasic();
      ```

2. **`formLogin()`**
    - Configures form-based authentication.
    - Example:
      ```java
      http.formLogin()
          .loginPage("/login")
          .permitAll();
      ```

3. **`oauth2Login()`**
    - Configures OAuth2/OpenID Connect authentication.
    - Example:
      ```java
      http.oauth2Login()
          .clientRegistrationRepository(clientRegistrationRepository());
      ```

4. **`authenticationProvider(AuthenticationProvider provider)`**
    - Configures a custom `AuthenticationProvider`.
    - Example:
      ```java
      http.authenticationProvider(customAuthProvider);
      ```

5. **`userDetailsService(UserDetailsService userDetailsService)`**
    - Specifies a custom `UserDetailsService` for loading user details.
    - Example:
      ```java
      http.userDetailsService(myUserDetailsService);
      ```

6. **`addFilter()`**
    - Adds custom filters for authentication (e.g., JWT authentication filter).
    - Example:
      ```java
      http.addFilter(new CustomAuthenticationFilter(authenticationManager()));
      ```

7. **`authenticationManager(AuthenticationManager authenticationManager)`**
    - Specifies a custom `AuthenticationManager`.
    - Example:
      ```java
      http.authenticationManager(customAuthManager);
      ```

---

### **Authorization Methods in HttpSecurity**
These methods configure who can access which resources.

1. **`authorizeRequests()` / `authorizeHttpRequests()` (since Spring Security 6)**
    - Configures authorization rules for specific URL patterns.
    - Example:
      ```java
      http.authorizeRequests()
          .antMatchers("/admin/**").hasRole("ADMIN")
          .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
          .anyRequest().authenticated();
      ```

2. **`antMatcher(String pattern)`**
    - Configures rules for a specific URL pattern.
    - Example:
      ```java
      http.antMatcher("/api/**").authorizeRequests().anyRequest().authenticated();
      ```

3. **`mvcMatcher(String pattern)`**
    - Similar to `antMatcher`, but uses Spring MVC's `RequestMapping` path matching.
    - Example:
      ```java
      http.mvcMatcher("/api/**").authorizeRequests().anyRequest().authenticated();
      ```

4. **`anyRequest()`**
    - Configures a default rule for all unmatched requests.
    - Example:
      ```java
      http.authorizeRequests()
          .anyRequest().permitAll();
      ```

5. **`permitAll()`**
    - Allows access to specific URL patterns without authentication.
    - Example:
      ```java
      http.authorizeRequests()
          .antMatchers("/public/**").permitAll();
      ```

6. **`denyAll()`**
    - Denies access to specific URL patterns.
    - Example:
      ```java
      http.authorizeRequests()
          .antMatchers("/restricted/**").denyAll();
      ```

7. **`hasRole(String role)`**
    - Grants access only to users with a specific role.
    - Example:
      ```java
      http.authorizeRequests()
          .antMatchers("/admin/**").hasRole("ADMIN");
      ```

8. **`hasAnyRole(String... roles)`**
    - Grants access to users with any of the specified roles.
    - Example:
      ```java
      http.authorizeRequests()
          .antMatchers("/user/**").hasAnyRole("USER", "ADMIN");
      ```

9. **`hasAuthority(String authority)`**
    - Grants access based on a specific authority.
    - Example:
      ```java
      http.authorizeRequests()
          .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN");
      ```

10. **`hasAnyAuthority(String... authorities)`**
    - Grants access if the user has any of the specified authorities.
    - Example:
      ```java
      http.authorizeRequests()
          .antMatchers("/user/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");
      ```

11. **`access(String expression)`**
    - Configures access using Spring Expression Language (SpEL).
    - Example:
      ```java
      http.authorizeRequests()
          .antMatchers("/custom/**").access("hasRole('ADMIN') and hasIpAddress('192.168.1.0/24')");
      ```

12. **`rememberMe()`**
    - Configures "Remember Me" functionality for authentication.
    - Example:
      ```java
      http.rememberMe()
          .key("uniqueAndSecret")
          .tokenValiditySeconds(86400);
      ```

13. **`logout()`**
    - Configures logout functionality.
    - Example:
      ```java
      http.logout()
          .logoutUrl("/logout")
          .logoutSuccessUrl("/login?logout");
      ```

---

### **Additional Security Methods**

1. **`csrf()`**
    - Configures Cross-Site Request Forgery (CSRF) protection.
    - Example:
      ```java
      http.csrf().disable();
      ```

2. **`cors()`**
    - Enables Cross-Origin Resource Sharing (CORS) support.
    - Example:
      ```java
      http.cors().configurationSource(corsConfigurationSource());
      ```

3. **`headers()`**
    - Configures HTTP security headers.
    - Example:
      ```java
      http.headers()
          .contentSecurityPolicy("script-src 'self'");
      ```

4. **`sessionManagement()`**
    - Configures session management rules.
    - Example:
      ```java
      http.sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      ```

5. **`exceptionHandling()`**
    - Configures custom exception handling.
    - Example:
      ```java
      http.exceptionHandling()
          .accessDeniedHandler(customAccessDeniedHandler);
      ```

---

### **Example Configuration**
Here’s a complete example combining authentication and authorization:
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login").permitAll()
            .and()
            .logout()
                .logoutUrl("/logout").logoutSuccessUrl("/login?logout");
    }
}
```

This demonstrates how `HttpSecurity` can manage both **authentication** and **authorization** in a Spring Boot application.