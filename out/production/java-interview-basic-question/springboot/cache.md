I'll provide a comprehensive example of implementing caching in a Spring Boot REST API using different caching strategies. I'll demonstrate local caching, distributed caching, and Redis caching.



```java
// Dependency: Add these to your pom.xml
/*
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
*/

// 1. Cache Configuration Class
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class CacheConfig {
    // Local In-Memory Cache
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(
            "userCache", 
            "productCache"
        );
    }

    // Redis Distributed Cache (Optional)
    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.builder(connectionFactory)
            .withCacheConfiguration("redisUserCache", 
                RedisCacheConfiguration.defaultCacheConfig()
                    .entryTtl(Duration.ofMinutes(10))
            )
            .build();
    }
}

// 2. User Entity
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    private Long id;
    private String name;
    private String email;

    // Constructors, getters, setters
}

// 3. User Repository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

// 4. User Service with Caching
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Cacheable: Retrieve from cache if exists
    @Cacheable(value = "userCache", key = "#id")
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
    }

    // CachePut: Always update cache
    @CachePut(value = "userCache", key = "#user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // CacheEvict: Remove from cache
    @CacheEvict(value = "userCache", key = "#id")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Conditional Caching
    @Cacheable(
        value = "userCache", 
        key = "#id", 
        condition = "#id > 0"
    )
    public User getActiveUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        
        return user.isActive() ? user : null;
    }
}

// 5. User REST Controller
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
        @PathVariable Long id, 
        @RequestBody User user
    ) {
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }
}

// 6. Custom Cache Eviction Scheduler
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheEvictionScheduler {
    @Autowired
    private CacheManager cacheManager;

    // Scheduled cache clearing every hour
    @Scheduled(fixedRate = 3600000) // 1 hour
    public void evictAllCaches() {
        cacheManager.getCacheNames()
            .forEach(cacheName -> {
                Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
            });
    }
}

// 7. Redis Configuration (application.properties)
/*
# Redis Configuration
spring.redis.host=localhost
spring.redis.port=6379

# Cache Configuration
spring.cache.type=redis
*/

// 8. Advanced Caching with Custom Key Generator
import org.springframework.cache.interceptor.KeyGenerator;

public class CustomKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return method.getName() + "_" + 
               Arrays.stream(params)
                   .map(Object::toString)
                   .collect(Collectors.joining("_"));
    }
}

// Usage in Configuration
@Bean
public KeyGenerator customKeyGenerator() {
    return new CustomKeyGenerator();
}

// Then use in service method
@Cacheable(
    value = "userCache", 
    keyGenerator = "customKeyGenerator"
)
public User complexCachedMethod(String param1, Integer param2) {
    // Implementation
}

```

### Caching Strategies Explained

1. **Local In-Memory Caching**
    - Uses `ConcurrentMapCacheManager`
    - Simple, quick solution for single-instance applications
    - Limited by JVM memory

2. **Distributed Caching with Redis**
    - Supports multiple application instances
    - Provides network-level caching
    - Configurable TTL (Time-To-Live)

### Caching Annotations

- `@Cacheable`: Caches method return values
- `@CachePut`: Updates cache without preventing method execution
- `@CacheEvict`: Removes entries from cache

### Key Caching Considerations

1. **Performance**: Reduces database load
2. **Scalability**: Use distributed caching for multiple instances
3. **Consistency**: Implement proper cache invalidation strategies

### Best Practices

1. Cache frequently accessed, rarely changed data
2. Use appropriate cache eviction strategies
3. Consider cache size and memory limitations
4. Implement conditional caching
5. Use distributed caching for clustered environments

### Recommended Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-cache</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
</dependencies>
```

### When to Use Different Caching Strategies

- **Local Caching**:
    - Small applications
    - Single server deployments
    - Low traffic environments

- **Distributed Caching (Redis)**:
    - Microservices
    - Clustered environments
    - High-traffic applications
    - Need for cross-service caching

### Monitoring and Tuning

1. Use Spring Boot Actuator for cache metrics
2. Monitor cache hit/miss rates
3. Adjust cache sizes and TTL based on usage patterns

Would you like me to elaborate on any specific aspect of caching implementation or discuss advanced caching strategies?