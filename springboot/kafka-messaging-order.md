I'll explain different strategies and configurations for maintaining message order in Kafka:

1. Single Partition Approach:
```java
// Producer Configuration
@Configuration
public class KafkaProducerConfig {
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Enable idempotence
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        return new DefaultKafkaProducerFactory<>(config);
    }
}

// Topic Configuration
@Bean
public NewTopic topic() {
    // Create topic with single partition
    return TopicBuilder.name("ordered-topic")
                      .partitions(1)
                      .replicas(3)
                      .build();
}
```

2. Key-Based Partitioning:
```java
// Producer with Key
@Service
public class OrderedMessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String key, String message) {
        // Messages with same key go to same partition
        kafkaTemplate.send("topic-name", key, message);
    }
}

// Consumer Configuration
@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "ordered-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // Disable auto commit
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        return new DefaultKafkaConsumerFactory<>(config);
    }
}
```

3. Custom Partitioner:
```java
public class CustomOrderPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, 
                        Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        // Custom logic to determine partition
        int orderNumber = extractOrderNumber(key.toString());
        return Math.abs(orderNumber % numPartitions);
    }

    private int extractOrderNumber(String key) {
        // Extract ordering information from key
        return Integer.parseInt(key.split("-")[1]);
    }
}

// Configure Custom Partitioner
@Bean
public ProducerFactory<String, String> producerFactory() {
    Map<String, Object> config = new HashMap<>();
    config.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomOrderPartitioner.class);
    // Other configurations...
    return new DefaultKafkaProducerFactory<>(config);
}
```

4. Transaction Management:
```java
@Service
@Transactional
public class TransactionalMessageService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendOrderedMessages(List<String> messages) {
        kafkaTemplate.executeInTransaction(operations -> {
            for (String message : messages) {
                operations.send("topic-name", message);
            }
            return true;
        });
    }
}

// Enable Transactions
@Configuration
public class KafkaConfig {
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "tx-");
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        // Other configurations...
        return new DefaultKafkaProducerFactory<>(config);
    }
}
```

5. Consumer Group Management:
```java
@KafkaListener(topics = "ordered-topic", groupId = "ordered-group")
public class OrderedMessageConsumer {
    
    @KafkaListener(topics = "ordered-topic")
    public void listen(ConsumerRecord<String, String> record, 
                      Acknowledgment acknowledgment) {
        try {
            processMessageInOrder(record);
            acknowledgment.acknowledge();
        } catch (Exception e) {
            // Handle error
        }
    }

    private void processMessageInOrder(ConsumerRecord<String, String> record) {
        // Process message maintaining order
        String key = record.key();
        String value = record.value();
        // Processing logic...
    }
}
```

6. Batch Processing with Ordering:
```java
@Service
public class BatchMessageProcessor {
    @KafkaListener(topics = "ordered-topic", 
                  containerFactory = "batchFactory")
    public void listenBatch(List<ConsumerRecord<String, String>> records, 
                           Acknowledgment acknowledgment) {
        // Sort records if needed
        records.sort(Comparator.comparing(ConsumerRecord::timestamp));
        
        for (ConsumerRecord<String, String> record : records) {
            processRecord(record);
        }
        acknowledgment.acknowledge();
    }
}

// Batch Consumer Configuration
@Bean
public ConcurrentKafkaListenerContainerFactory<String, String> batchFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory =
            new ConcurrentKafkaListenerContainerFactory<>();
    factory.setBatchListener(true);
    factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
    return factory;
}
```

Best Practices for Maintaining Order:

1. Configuration Best Practices:
```java
// Producer Configuration
max.in.flight.requests.per.connection=1
enable.idempotence=true
acks=all

// Consumer Configuration
isolation.level=read_committed
enable.auto.commit=false
```

2. Monitoring and Error Handling:
```java
@Service
public class MessageMonitoringService {
    private Map<String, Long> lastProcessedOffset = new ConcurrentHashMap<>();

    public void monitorMessage(ConsumerRecord<String, String> record) {
        String partition = record.partition() + "";
        long offset = record.offset();
        
        Long lastOffset = lastProcessedOffset.get(partition);
        if (lastOffset != null && offset <= lastOffset) {
            log.warn("Out of order message detected");
        }
        
        lastProcessedOffset.put(partition, offset);
    }
}
```

3. Recovery Mechanisms:
```java
@Service
public class MessageRecoveryService {
    private Queue<ConsumerRecord<String, String>> recoveryQueue = 
        new PriorityQueue<>(Comparator.comparing(ConsumerRecord::offset));

    public void handleFailedMessage(ConsumerRecord<String, String> record) {
        recoveryQueue.offer(record);
        processRecoveryQueue();
    }

    private void processRecoveryQueue() {
        while (!recoveryQueue.isEmpty()) {
            ConsumerRecord<String, String> record = recoveryQueue.poll();
            // Retry processing
        }
    }
}
```

Key Points for Maintaining Order:
1. Use single partition for strict ordering
2. Use consistent key for related messages
3. Configure appropriate number of consumer threads
4. Handle failures and retries properly
5. Monitor message order
6. Use transactions when needed
7. Implement proper error handling
8. Consider batch processing requirements
9. Use appropriate acknowledgment modes
10. Maintain proper offset management

Would you like me to explain any specific aspect in more detail?