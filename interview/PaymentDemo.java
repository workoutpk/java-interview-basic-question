package interview;

// Example usage
public class PaymentDemo {
    public static void main(String[] args) {
        processPaymentWithProcessor(new CreditCardProcessor(), 100.0);
        processPaymentWithProcessor(new PayPalProcessor(), 100.0);
    }

    public static void processPaymentWithProcessor(PaymentProcessor processor, double amount) {
        processor.processPayment(amount);
    }
}
