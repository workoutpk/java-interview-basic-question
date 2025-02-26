I'll create a comprehensive example of a Choreography-Based Saga using Spring Boot, demonstrating a typical order processing scenario across multiple microservices.

```java
// Order Service
@Service
public class OrderService {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private final OrderRepository orderRepository;

    @Value("${kafka.topics.order-created}")
    private String orderCreatedTopic;

    @Transactional
    public Order createOrder(Order order) {
        // Save initial order with PENDING status
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderRepository.save(order);

        // Publish Order Created Event
        OrderEvent orderEvent = new OrderEvent(savedOrder.getId(), savedOrder);
        kafkaTemplate.send(orderCreatedTopic, orderEvent);

        return savedOrder;
    }

    @KafkaListener(topics = "${kafka.topics.order-rejected}")
    public void handleOrderRejection(OrderEvent event) {
        Order order = orderRepository.findById(event.getOrderId())
            .orElseThrow(() -> new RuntimeException("Order not found"));
        
        order.setStatus(OrderStatus.REJECTED);
        orderRepository.save(order);
    }
}

// Payment Service
@Service
public class PaymentService {
    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;
    private final PaymentRepository paymentRepository;

    @Value("${kafka.topics.order-created}")
    private String orderCreatedTopic;

    @Value("${kafka.topics.payment-processed}")
    private String paymentProcessedTopic;

    @Value("${kafka.topics.payment-failed}")
    private String paymentFailedTopic;

    @KafkaListener(topics = "${kafka.topics.order-created}")
    public void processPayment(OrderEvent orderEvent) {
        try {
            // Simulate payment processing
            Payment payment = processPaymentForOrder(orderEvent.getOrder());
            
            // Publish Payment Processed Event
            PaymentEvent paymentEvent = new PaymentEvent(orderEvent.getOrderId(), payment);
            kafkaTemplate.send(paymentProcessedTopic, paymentEvent);
        } catch (Exception e) {
            // Publish Payment Failed Event
            PaymentEvent failedEvent = new PaymentEvent(orderEvent.getOrderId(), null);
            failedEvent.setErrorMessage(e.getMessage());
            kafkaTemplate.send(paymentFailedTopic, failedEvent);
        }
    }

    @KafkaListener(topics = "${kafka.topics.payment-failed}")
    public void handlePaymentRollback(PaymentEvent event) {
        // Refund or cancel payment
        paymentRepository.deleteByOrderId(event.getOrderId());
    }
}

// Inventory Service
@Service
public class InventoryService {
    private final KafkaTemplate<String, InventoryEvent> kafkaTemplate;
    private final InventoryRepository inventoryRepository;

    @Value("${kafka.topics.payment-processed}")
    private String paymentProcessedTopic;

    @Value("${kafka.topics.inventory-reserved}")
    private String inventoryReservedTopic;

    @Value("${kafka.topics.inventory-failed}")
    private String inventoryFailedTopic;

    @KafkaListener(topics = "${kafka.topics.payment-processed}")
    public void reserveInventory(PaymentEvent paymentEvent) {
        try {
            // Simulate inventory reservation
            InventoryReservation reservation = reserveProductInventory(paymentEvent.getOrder());
            
            // Publish Inventory Reserved Event
            InventoryEvent inventoryEvent = new InventoryEvent(
                paymentEvent.getOrderId(), 
                reservation
            );
            kafkaTemplate.send(inventoryReservedTopic, inventoryEvent);
        } catch (InsufficientInventoryException e) {
            // Publish Inventory Reservation Failed Event
            InventoryEvent failedEvent = new InventoryEvent(
                paymentEvent.getOrderId(), 
                null
            );
            failedEvent.setErrorMessage(e.getMessage());
            kafkaTemplate.send(inventoryFailedTopic, failedEvent);
        }
    }

    @KafkaListener(topics = "${kafka.topics.inventory-failed}")
    public void handleInventoryRollback(InventoryEvent event) {
        // Release reserved inventory
        inventoryRepository.releaseReservation(event.getOrderId());
    }
}

// Shipping Service
@Service
public class ShippingService {
    private final KafkaTemplate<String, ShippingEvent> kafkaTemplate;
    private final ShippingRepository shippingRepository;

    @Value("${kafka.topics.inventory-reserved}")
    private String inventoryReservedTopic;

    @Value("${kafka.topics.shipping-initiated}")
    private String shippingInitiatedTopic;

    @Value("${kafka.topics.shipping-failed}")
    private String shippingFailedTopic;

    @KafkaListener(topics = "${kafka.topics.inventory-reserved}")
    public void initiateShipping(InventoryEvent inventoryEvent) {
        try {
            // Simulate shipping initiation
            Shipping shippingDetails = createShippingForOrder(inventoryEvent.getOrder());
            
            // Publish Shipping Initiated Event
            ShippingEvent shippingEvent = new ShippingEvent(
                inventoryEvent.getOrderId(), 
                shippingDetails
            );
            kafkaTemplate.send(shippingInitiatedTopic, shippingEvent);
        } catch (Exception e) {
            // Publish Shipping Failed Event
            ShippingEvent failedEvent = new ShippingEvent(
                inventoryEvent.getOrderId(), 
                null
            );
            failedEvent.setErrorMessage(e.getMessage());
            kafkaTemplate.send(shippingFailedTopic, failedEvent);
        }
    }

    @KafkaListener(topics = "${kafka.topics.shipping-failed}")
    public void handleShippingRollback(ShippingEvent event) {
        // Cancel shipping
        shippingRepository.cancelShipping(event.getOrderId());
    }
}

// Event Classes
@Data
@AllArgsConstructor
public class OrderEvent {
    private Long orderId;
    private Order order;
    private String errorMessage;
}

@Data
@AllArgsConstructor
public class PaymentEvent {
    private Long orderId;
    private Payment payment;
    private String errorMessage;
}

@Data
@AllArgsConstructor
public class InventoryEvent {
    private Long orderId;
    private InventoryReservation reservation;
    private String errorMessage;
}

@Data
@AllArgsConstructor
public class ShippingEvent {
    private Long orderId;
    private Shipping shipping;
    private String errorMessage;
}

// Kafka Configuration
@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic orderCreatedTopic() {
        return TopicBuilder.name("order-created").partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic paymentProcessedTopic() {
        return TopicBuilder.name("payment-processed").partitions(1).replicas(1).build();
    }

    // Add similar beans for other topics
}

// Global Error Handling Mechanism
@Service
public class SagaCompensationService {
    @KafkaListener(topics = {"payment-failed", "inventory-failed", "shipping-failed"})
    public void handleSagaFailure(BaseEvent event) {
        // Centralized error handling and compensation logic
        compensateEntireTransaction(event.getOrderId());
    }

    private void compensateEntireTransaction(Long orderId) {
        // Trigger compensation for all services
        // Send compensation events to respective services
    }
}

```

Key Characteristics of this Choreography-Based Saga:

1. **Decentralized Coordination**
    - Each microservice manages its own logic
    - Services communicate through Kafka events
    - No central orchestrator controls the entire flow

2. **Event-Driven Architecture**
    - Uses Kafka as the event bus
    - Each service listens to specific topics
    - Publishes events after completing its part of the transaction

3. **Compensation Mechanism**
    - Each service has a compensation method
    - If a step fails, corresponding rollback events are published
    - Services can handle their own compensating actions

4. **Transaction Flow**
    - Order Creation → Payment Processing → Inventory Reservation → Shipping Initiation
    - Failure in any step triggers compensation for previous steps

Kafka Topics Workflow:
```
order-created → 
payment-processed → 
inventory-reserved → 
shipping-initiated
```

Compensation Flow:
```
shipping-failed → 
inventory-failed → 
payment-failed → 
order-rejected
```

Configuration Considerations:
- Use application.yml to configure Kafka topics
- Implement robust error handling
- Use transactional outbox pattern for event publishing
- Implement idempotent consumers

Recommended Enhancements:
- Add distributed tracing
- Implement circuit breakers
- Add retry mechanisms
- Use correlation IDs for tracking transactions

Would you like me to elaborate on any specific aspect of this Choreography-Based Saga implementation?