Here are the key differences between Deadlock and Livelock in concurrent programming:

1. **Definition**:

   **Deadlock**:
    - A deadlock occurs when two or more threads are blocked forever, each waiting for the other to release resources
    - Threads are in a completely blocked state
    - No progress is made at all

   Example of Deadlock:
```java
public class DeadlockExample {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK1) {
                System.out.println("Thread 1: Holding lock 1...");
                try { Thread.sleep(100);} catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (LOCK2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            synchronized (LOCK2) {
                System.out.println("Thread 2: Holding lock 2...");
                try { Thread.sleep(100);} catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (LOCK1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
}
```

**Livelock**:
- A livelock occurs when threads are actively trying to resolve a conflict but end up in a cycle where they prevent each other from making progress
- Threads are not blocked, but they're unable to make progress
- Threads are actively performing actions, but these actions don't lead to useful progress

Example of Livelock:
```java
public class LivelockExample {
    static class Spoon {
        private Diner owner;
        public Spoon(Diner d) { owner = d; }
        public Diner getOwner() { return owner; }
        public synchronized void setOwner(Diner d) { owner = d; }
        public synchronized void use() { 
            System.out.printf("%s has eaten!", owner.name); 
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;
        
        public Diner(String n) { name = n; isHungry = true; }
        
        public String getName() { return name; }
        public boolean isHungry() { return isHungry; }
        
        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                // Don't have the spoon, wait patiently for spouse
                if (spoon.owner != this) {
                    try { Thread.sleep(1); } catch(InterruptedException e) {}
                    continue;
                }
                
                // If spouse is hungry, insist upon passing the spoon
                if (spouse.isHungry()) {
                    System.out.printf(
                        "%s: You eat first %s!%n", 
                        name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }
                
                // Spouse wasn't hungry, so finally eat
                spoon.use();
                isHungry = false;
                System.out.printf(
                    "%s: I am stuffed, my %s!%n", 
                    name, spouse.getName());
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Bob");
        final Diner wife = new Diner("Alice");
        final Spoon s = new Spoon(husband);
        
        new Thread(() -> husband.eatWith(s, wife)).start();
        new Thread(() -> wife.eatWith(s, husband)).start();
    }
}
```

2. **Key Differences**:

    - **State of Threads**:
        - Deadlock: Threads are blocked and waiting
        - Livelock: Threads are running but making no progress

    - **Resource Usage**:
        - Deadlock: Resources are held and not released
        - Livelock: Resources are being actively passed between threads

    - **CPU Usage**:
        - Deadlock: Minimal CPU usage as threads are blocked
        - Livelock: High CPU usage as threads are actively running

    - **Resolution**:
        - Deadlock: Requires external intervention
        - Livelock: Might resolve itself if timing changes

3. **Prevention Strategies**:

   **Deadlock Prevention**:
   ```java
   public class DeadlockPrevention {
       private static final Object LOCK1 = new Object();
       private static final Object LOCK2 = new Object();
       
       public static void main(String[] args) {
           // Always acquire locks in the same order
           Thread thread1 = new Thread(() -> {
               synchronized (LOCK1) {
                   synchronized (LOCK2) {
                       // Work with both locks
                   }
               }
           });
           
           Thread thread2 = new Thread(() -> {
               synchronized (LOCK1) {
                   synchronized (LOCK2) {
                       // Work with both locks
                   }
               }
           });
       }
   }
   ```

   **Livelock Prevention**:
   ```java
   public class LivelockPrevention {
       public static void transferMoney(Account from, Account to, BigDecimal amount) {
           while (true) {
               // Add random delay to break the cycle
               if (Math.random() < 0.5) {
                   try { Thread.sleep(1); } catch (InterruptedException e) {}
               }
               
               if (from.tryTransfer(to, amount)) {
                   return;
               }
           }
       }
   }
   ```

In summary, while both deadlock and livelock prevent progress, deadlock involves threads being completely blocked, while livelock involves threads actively running but unable to make progress. Understanding these differences is crucial for developing robust concurrent applications and implementing appropriate prevention strategies.