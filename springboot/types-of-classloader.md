In Java, there are several types of class loaders that are responsible for loading classes into the Java Virtual Machine (JVM). Here are the main types of class loaders, along with examples:

1. **Bootstrap Class Loader**:
    - The bootstrap class loader is the top-level class loader in the JVM.
    - It is responsible for loading the core Java classes, such as those found in the `java.*` and `javax.*` packages.
    - The bootstrap class loader is written in native code (typically C/C++) and is not accessible directly from Java code.
    - Example: The `java.lang.String` class is loaded by the bootstrap class loader.

2. **Extension Class Loader**:
    - The extension class loader is a child of the bootstrap class loader.
    - It is responsible for loading classes from the JDK's extension directory (usually `$JAVA_HOME/lib/ext` or `java.ext.dirs` system property).
    - The extension class loader is implemented in Java and can be accessed using the `sun.misc.Launcher$ExtClassLoader` class.
    - Example: The `javax.swing.JButton` class is loaded by the extension class loader.

3. **System/Application Class Loader**:
    - The system class loader, also known as the application class loader, is a child of the extension class loader.
    - It is responsible for loading classes from the application's classpath, which includes the current directory, the `CLASSPATH` environment variable, and any JAR files or directories specified in the classpath.
    - The system class loader is implemented in Java and can be accessed using the `java.lang.ClassLoader.getSystemClassLoader()` method.
    - Example: Your own application classes are loaded by the system class loader.

4. **Custom Class Loader**:
    - Custom class loaders are user-defined class loaders that extend the `java.lang.ClassLoader` class.
    - They are used to load classes from non-standard locations, such as the network, a database, or a custom file system.
    - Custom class loaders can be used to implement class loading policies, such as caching, versioning, or on-demand loading.
    - Example: You might create a custom class loader to load classes from a remote server or a plugin system.

Here's an example of a simple custom class loader that loads classes from a specific directory:

```java
public class CustomClassLoader extends ClassLoader {
    private static final String CLASS_DIR = "path/to/classes/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = loadClassBytes(name);
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassBytes(String name) throws ClassNotFoundException {
        String fileName = CLASS_DIR + name.replace(".", "/") + ".class";
        try {
            return Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not find class: " + name, e);
        }
    }
}
```

In this example, the `CustomClassLoader` loads classes from the `path/to/classes/` directory. You can use this class loader to load your application's classes from a non-standard location.