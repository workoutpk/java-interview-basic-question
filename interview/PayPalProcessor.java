package interview;

// Concrete implementation for PayPal payments
public class PayPalProcessor extends PaymentProcessor {
    @Override
    protected void validatePayment(double amount) {
        System.out.println("Validating PayPal payment of $" + amount);
    }

    @Override
    protected double calculateFee(double amount) {
        return amount * 0.015; // 1.5% fee
    }

    @Override
    protected void performPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    @Override
    protected void sendConfirmation() {
        System.out.println("PayPal-specific confirmation sent.");
    }
}
