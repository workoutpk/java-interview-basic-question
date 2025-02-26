package interview;

// Concrete implementation for credit card payments
public class CreditCardProcessor extends PaymentProcessor {
    @Override
    protected void validatePayment(double amount) {
        System.out.println("Validating credit card payment of $" + amount);
    }

    @Override
    protected double calculateFee(double amount) {
        return amount * 0.02; // 2% fee
    }

    @Override
    protected void performPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
