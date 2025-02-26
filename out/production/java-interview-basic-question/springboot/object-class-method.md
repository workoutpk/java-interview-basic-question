The `Object` class in Java is the root class of all classes in Java. Every class in Java either directly or indirectly inherits from the `Object` class. It provides several fundamental methods that are available to all Java objects.

### List of `Object` Class Methods
Here is a complete list of the methods provided by the `Object` class:

---

### **Public Methods**
1. **`clone()`**
    - Creates and returns a copy (clone) of the object.
    - **Signature**: `protected Object clone() throws CloneNotSupportedException`
    - **Purpose**: Used to create a copy of an object, provided the class implements the `Cloneable` interface.

2. **`equals(Object obj)`**
    - Checks whether the current object is equal to the specified object.
    - **Signature**: `public boolean equals(Object obj)`
    - **Purpose**: Determines equality based on the default reference comparison or overridden logic.

3. **`finalize()`**
    - Called by the garbage collector before the object is destroyed.
    - **Signature**: `protected void finalize() throws Throwable`
    - **Purpose**: Cleanup operations before object deletion (rarely used).

4. **`getClass()`**
    - Returns the runtime class of the object.
    - **Signature**: `public final Class<?> getClass()`
    - **Purpose**: Used for introspection (reflection).

5. **`hashCode()`**
    - Returns a hash code value for the object.
    - **Signature**: `public int hashCode()`
    - **Purpose**: Used in hashing-based data structures like `HashMap`, `HashSet`.

6. **`toString()`**
    - Returns a string representation of the object.
    - **Signature**: `public String toString()`
    - **Purpose**: Useful for debugging; often overridden to provide meaningful details.

7. **`notify()`**
    - Wakes up a single thread waiting on the object's monitor.
    - **Signature**: `public final native void notify()`
    - **Purpose**: Used in thread synchronization.

8. **`notifyAll()`**
    - Wakes up all threads waiting on the object's monitor.
    - **Signature**: `public final native void notifyAll()`
    - **Purpose**: Used in thread synchronization.

9. **`wait()`**
    - Causes the current thread to wait until another thread invokes `notify()` or `notifyAll()`.
    - **Signatures**:
        - `public final void wait() throws InterruptedException`
        - `public final native void wait(long timeout) throws InterruptedException`
        - `public final void wait(long timeout, int nanos) throws InterruptedException`
    - **Purpose**: Used in thread synchronization.

---

### **Protected Methods**
1. **`clone()`**
    - As mentioned above, it is `protected` and meant for use within subclasses.

2. **`finalize()`**
    - Also `protected` and rarely overridden.

---

### Notes:
- **`equals()` and `hashCode()`**: Should be overridden together to maintain contract integrity (e.g., in `HashMap` or `HashSet`).
- **`toString()`**: Highly recommended to override for debugging and logging purposes.
- **Thread-related methods (`notify`, `notifyAll`, `wait`)**: These are used in synchronized blocks and are essential for thread communication.

By providing these fundamental methods, the `Object` class enables a uniform interface for all objects in Java.