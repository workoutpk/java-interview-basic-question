package interview;

// Abstract class representing a generic payment processor
public abstract class PaymentProcessor {
    // Common method for all payment processors
    public void processPayment(double amount) {
        validatePayment(amount);
        double fee = calculateFee(amount);
        double totalAmount = amount + fee;
        performPayment(totalAmount);
        sendConfirmation();
    }

    // Abstract methods to be implemented by specific payment processors
    protected abstract void validatePayment(double amount);
    protected abstract double calculateFee(double amount);
    protected abstract void performPayment(double amount);

    // Common method that can be overridden if needed
    protected void sendConfirmation() {
        System.out.println("Payment confirmation sent.");
    }
}

