

### What is `@KafkaListener` in Spring Kafka?

- **`@KafkaListener`** is an annotation used to mark a method as a message listener for a specific Kafka topic.
- It simplifies consuming messages from Kafka topics by providing a declarative approach to configure listeners in a Spring application.

---

### Example of `@KafkaListener` in Kafka with Spring

Here’s an example of how to use `@KafkaListener` in a Spring Boot application:

#### Step 1: Add Dependencies
Add the required dependencies in your `pom.xml` for Maven:
```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
    <version>2.9.0</version>
</dependency>
```

---

#### Step 2: Configure Kafka Consumer

Create a configuration class for Kafka:
```java
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public DefaultKafkaConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }
}
```

---

#### Step 3: Create a Kafka Listener

Create a service class with a method annotated with `@KafkaListener`:
```java
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
```

---

### Explanation of `@KafkaListener`

1. **`@KafkaListener` Parameters**:
    - `topics`: Specifies the topic(s) this listener will subscribe to.
    - `groupId`: Identifies the consumer group to which this listener belongs.
    - Other optional attributes like `containerFactory`, `id`, and `errorHandler` provide additional configuration options.

2. **How It Works**:
    - When a message is published to the Kafka topic specified in `@KafkaListener`, the annotated method will automatically be invoked, and the message payload will be passed as a parameter.

---

### Key Features of `@KafkaListener`
- Simplifies message consumption by abstracting Kafka API complexities.
- Supports deserialization of message payloads.
- Provides robust error handling with options for retry and dead-letter queues.

If you meant something different by **`@HostListener` in Kafka**, feel free to clarify, and I can provide a more accurate explanation.