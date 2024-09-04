package circuit_barrier;

import java.util.concurrent.TimeUnit;

public class CircuitBreaker {

        private final int failureThreshold;
        private final int waitDurationInOpenState;
        private final TimeUnit timeUnit;
        private int failureCount;
        private boolean isOpen;

        public CircuitBreaker(int failureThreshold, int waitDurationInOpenState, TimeUnit timeUnit) {
                this.failureThreshold = failureThreshold;
                this.waitDurationInOpenState = waitDurationInOpenState;
                this.timeUnit = timeUnit;
                this.failureCount = 0;
                this.isOpen = false;
        }

        public void execute(Runnable runnable) {
                if (isOpen) {
                        System.out.println("The circuit breaker is open.");
                        return;
                }

                try {
                        runnable.run();
                } catch (Exception e) {
                        failureCount++;

                        if (failureCount >= failureThreshold) {
                                isOpen = true;
                                System.out.println("The circuit breaker has opened.");
                        }
                }
        }

        public void reset() {
                failureCount = 0;
                isOpen = false;
        }
}

