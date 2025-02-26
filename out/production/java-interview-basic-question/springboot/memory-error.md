In Java, memory-related exceptions are typically thrown when the Java Virtual Machine (JVM) runs into memory allocation or management issues. Below is a list of common memory exceptions in Java:

---

### **1. `OutOfMemoryError`**
- **Description**: Thrown when the JVM cannot allocate memory for an object because it has run out of memory or cannot increase the heap size further.
- **Common Causes**:
    - Insufficient heap memory.
    - Memory leaks.
    - Large data structures or too many objects being created.
- **Subtypes**:
    - **`OutOfMemoryError: Java heap space`**: Happens when the heap is full.
    - **`OutOfMemoryError: GC overhead limit exceeded`**: Happens when the JVM spends too much time in garbage collection.
    - **`OutOfMemoryError: Direct buffer memory`**: Happens when the JVM runs out of direct memory (e.g., for `ByteBuffer`).
    - **`OutOfMemoryError: Metaspace`**: Occurs when the JVM's Metaspace (used for class metadata) is full.

---

### **2. `StackOverflowError`**
- **Description**: Thrown when a thread's call stack overflows due to deep or infinite recursion.
- **Common Causes**:
    - Recursive method calls without a proper base condition.
    - Excessively deep call chains.

---

### **3. `IllegalStateException`**
- **Description**: Not strictly a memory exception, but can occur in scenarios like object reuse from a pool when memory management constraints are violated.
- **Common Causes**:
    - Reusing objects in an inappropriate state.
    - Issues with memory-sensitive data structures.

---

### **4. `OutOfMemoryError: PermGen space` (Pre-Java 8)**
- **Description**: Thrown when the JVM runs out of space in the Permanent Generation (PermGen).
- **Notes**:
    - PermGen was replaced by Metaspace in Java 8.
    - Managed class metadata and static fields before Java 8.

---

### **5. `VirtualMachineError`**
- **Description**: A superclass for errors related to the Java Virtual Machine's operation.
- **Relevant Subtypes**:
    - **`OutOfMemoryError`**
    - **`StackOverflowError`**

---

### **6. `IOException` (Memory-Related Contexts)**
- **Description**: While primarily an I/O exception, it can occur in memory-related contexts, such as when disk or virtual memory is insufficient for swapping.

---

### **7. `BufferOverflowException` (NIO Specific)**
- **Description**: Thrown when a relative `put` operation exceeds the buffer's limit.
- **Common Causes**:
    - Writing beyond the allocated capacity of a buffer in Java's NIO package.

---

### **8. `BufferUnderflowException` (NIO Specific)**
- **Description**: Thrown when a relative `get` operation attempts to read beyond the buffer's current position.
- **Common Causes**:
    - Reading data from an empty buffer.

---

### **9. `MemoryAccessException` (Non-JDK Specific)**
- **Description**: Occurs in third-party libraries or tools when there are unsafe memory access violations (e.g., JNI, DirectByteBuffer access).

---

### **10. `OOMError: Native Memory Allocation`**
- **Description**: Thrown when the JVM fails to allocate native memory, such as for threads or direct buffers.
- **Common Causes**:
    - Excessive thread creation.
    - Large native memory usage by the application.

---

### **How to Handle These Exceptions**
- **OutOfMemoryError**:
    - Increase heap size (`-Xmx`).
    - Optimize memory usage and fix memory leaks.
- **StackOverflowError**:
    - Refactor recursive algorithms to iterative ones.
    - Increase stack size (`-Xss`).
- **PermGen/Metaspace Errors**:
    - Increase PermGen/Metaspace size (`-XX:MaxMetaspaceSize` for Java 8+).
    - Reduce the number of loaded classes or avoid excessive dynamic class generation.

Let me know if you'd like more in-depth examples or solutions for any specific exception!