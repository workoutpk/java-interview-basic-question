Here is a list of commonly used Kafka methods and their descriptions, categorized by the Kafka APIs they belong to:

---

### **1. Producer API Methods**

The **Producer API** is used to send messages to Kafka topics.

#### **Key Methods**
- **`send(ProducerRecord<K, V> record)`**
    - Sends data to a Kafka topic asynchronously.
    - Example:
      ```java
      producer.send(new ProducerRecord<>("my_topic", "key", "value"));
      ```

- **`flush()`**
    - Ensures all previously sent records are transmitted to Kafka.
    - Example:
      ```java
      producer.flush();
      ```

- **`close()`**
    - Closes the producer and releases resources.
    - Example:
      ```java
      producer.close();
      ```

- **`partitionsFor(String topic)`**
    - Fetches metadata about the partitions for a given topic.
    - Example:
      ```java
      List<PartitionInfo> partitions = producer.partitionsFor("my_topic");
      ```

- **`metrics()`**
    - Returns metrics about the producer.
    - Example:
      ```java
      Map<MetricName, ? extends Metric> metrics = producer.metrics();
      ```

---

### **2. Consumer API Methods**

The **Consumer API** is used to read messages from Kafka topics.

#### **Key Methods**
- **`subscribe(Collection<String> topics)`**
    - Subscribes the consumer to a list of topics.
    - Example:
      ```java
      consumer.subscribe(Arrays.asList("topic1", "topic2"));
      ```

- **`poll(Duration timeout)`**
    - Fetches data from Kafka within the specified timeout.
    - Example:
      ```java
      ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
      ```

- **`commitSync()`**
    - Commits the current offsets synchronously.
    - Example:
      ```java
      consumer.commitSync();
      ```

- **`commitAsync()`**
    - Commits the current offsets asynchronously.
    - Example:
      ```java
      consumer.commitAsync();
      ```

- **`assign(Collection<TopicPartition> partitions)`**
    - Assigns specific topic partitions to the consumer.
    - Example:
      ```java
      consumer.assign(Arrays.asList(new TopicPartition("my_topic", 0)));
      ```

- **`seek(TopicPartition partition, long offset)`**
    - Manually sets the offset for a topic partition.
    - Example:
      ```java
      consumer.seek(new TopicPartition("my_topic", 0), 10);
      ```

- **`close()`**
    - Closes the consumer and releases resources.
    - Example:
      ```java
      consumer.close();
      ```

- **`wakeUp()`**
    - Interrupts a consumer blocking on a `poll()` call.
    - Example:
      ```java
      consumer.wakeup();
      ```

---

### **3. Admin API Methods**

The **Admin API** is used to manage topics, brokers, and other Kafka resources.

#### **Key Methods**
- **`createTopics(Collection<NewTopic> topics)`**
    - Creates new topics.
    - Example:
      ```java
      adminClient.createTopics(Collections.singletonList(new NewTopic("new_topic", 1, (short) 1)));
      ```

- **`listTopics()`**
    - Lists all topics in the Kafka cluster.
    - Example:
      ```java
      adminClient.listTopics().names().get();
      ```

- **`describeTopics(Collection<String> topicNames)`**
    - Fetches metadata for the specified topics.
    - Example:
      ```java
      adminClient.describeTopics(Collections.singleton("my_topic"));
      ```

- **`deleteTopics(Collection<String> topics)`**
    - Deletes the specified topics.
    - Example:
      ```java
      adminClient.deleteTopics(Collections.singleton("my_topic"));
      ```

- **`describeCluster()`**
    - Provides metadata about the Kafka cluster.
    - Example:
      ```java
      adminClient.describeCluster();
      ```

- **`describeConsumerGroups(Collection<String> groupIds)`**
    - Fetches information about consumer groups.
    - Example:
      ```java
      adminClient.describeConsumerGroups(Collections.singletonList("my_group"));
      ```

---

### **4. Streams API Methods**

The **Streams API** is used for stream processing in Kafka.

#### **Key Methods**
- **`builder.stream(String topic)`**
    - Creates a stream from a topic.
    - Example:
      ```java
      KStream<String, String> stream = builder.stream("input_topic");
      ```

- **`filter(Predicate<? super K, ? super V> predicate)`**
    - Filters records based on a condition.
    - Example:
      ```java
      KStream<String, String> filteredStream = stream.filter((key, value) -> value.contains("important"));
      ```

- **`mapValues(ValueMapper<? super V, ? extends VR> mapper)`**
    - Transforms the values of the stream.
    - Example:
      ```java
      KStream<String, String> mappedStream = stream.mapValues(value -> value.toUpperCase());
      ```

- **`groupByKey()`**
    - Groups records by their keys.
    - Example:
      ```java
      KGroupedStream<String, String> groupedStream = stream.groupByKey();
      ```

- **`count()`**
    - Counts the records in each group.
    - Example:
      ```java
      KTable<String, Long> countTable = groupedStream.count();
      ```

- **`join()`**
    - Joins two streams based on their keys.
    - Example:
      ```java
      KStream<String, String> joinedStream = stream1.join(stream2, (value1, value2) -> value1 + value2);
      ```

- **`to(String topic)`**
    - Sends the processed stream to a new topic.
    - Example:
      ```java
      stream.to("output_topic");
      ```

---

### **5. Kafka Connect API Methods**

Kafka Connect is used for integrating Kafka with external systems.

#### **Key Operations**
- **Source Connectors**:
    - Reads data from an external system into Kafka topics.

- **Sink Connectors**:
    - Writes data from Kafka topics to an external system.

- **Connector Management Methods**:
    - Start, stop, and monitor connectors using REST APIs.

---

### Summary Table

| API                | Key Methods                                     |
|--------------------|-------------------------------------------------|
| Producer API       | `send()`, `flush()`, `close()`, `partitionsFor()` |
| Consumer API       | `poll()`, `subscribe()`, `commitSync()`, `seek()` |
| Admin API          | `createTopics()`, `listTopics()`, `deleteTopics()` |
| Streams API        | `stream()`, `filter()`, `mapValues()`, `join()` |
| Connect API        | Source and Sink Connector operations           |

Each method has specific use cases, and together they provide a comprehensive framework for building applications with Kafka.