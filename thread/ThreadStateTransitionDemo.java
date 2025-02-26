package thread;

public class ThreadStateTransitionDemo {
    static class StateTransitionDemo implements Runnable{
        private volatile boolean shouldSleep = false;
        private volatile boolean shouldWait = false;
        private final Object transitionLock = new Object();

        public void triggerSleep() {
            shouldSleep = true;
        }

        public void triggerWait() {
            shouldWait = true;
        }
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (shouldSleep) {
                    try {
                        Thread.sleep(1000);
                        shouldSleep = false;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (shouldWait) {
                    synchronized (transitionLock) {
                        try {
                            transitionLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
        public void wakeUp() {
            synchronized (transitionLock) {
                shouldWait = false;
                transitionLock.notify();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        StateTransitionDemo stateDemo = new StateTransitionDemo();
        Thread transitionThread = new Thread(stateDemo);

        // Show initial state
        System.out.println("Initial state: " + transitionThread.getState());

        // Start thread and show RUNNABLE state
        transitionThread.start();
        Thread.sleep(100);
        System.out.println("After start: " + transitionThread.getState());

        // Trigger sleep and show TIMED_WAITING state
        stateDemo.triggerSleep();
        Thread.sleep(100);
        System.out.println("After sleep trigger: " + transitionThread.getState());

        // Wait for sleep to complete
        Thread.sleep(1100);

        // Trigger wait and show WAITING state
        stateDemo.triggerWait();
        Thread.sleep(100);
        System.out.println("After wait trigger: " + transitionThread.getState());

        // Wake up thread and show final state
        stateDemo.wakeUp();
        Thread.sleep(100);
        transitionThread.interrupt();
        Thread.sleep(100);
        System.out.println("Final state: " + transitionThread.getState());

    }
}
