package interview;

import java.io.*;
import java.lang.reflect.Constructor;

public class InstanceCreationComparison {

    // 1. Using constructor
    public static class UsingConstructor {
        public UsingConstructor() {
            // Constructor logic
        }
    }

    // 2. Factory method
    public static class UsingFactory {
        private UsingFactory() {}
        public static UsingFactory createInstance() {
            return new UsingFactory();
        }
    }

    // 3. Object pool
    public static class ObjectPool {
        private static final int POOL_SIZE = 10;
        private static UsingConstructor[] pool = new UsingConstructor[POOL_SIZE];
        private static int currentIndex = 0;

        static {
            for (int i = 0; i < POOL_SIZE; i++) {
                pool[i] = new UsingConstructor();
            }
        }

        public static UsingConstructor getInstance() {
            if (currentIndex < POOL_SIZE) {
                return pool[currentIndex++];
            }
            return new UsingConstructor(); // Fallback to creating new instance
        }
    }

    // 4. Cloneable
    public static class CloneableClass implements Cloneable {
        @Override
        public CloneableClass clone() throws CloneNotSupportedException {
            return (CloneableClass) super.clone();
        }
    }

    // 5. Serializable
    public static class SerializableClass implements Serializable {
        private static final long serialVersionUID = 1L;
    }

    public static void main(String[] args) throws Exception {
        // 1. Using constructor
        UsingConstructor obj1 = new UsingConstructor();

        // 2. Factory method
        UsingFactory obj2 = UsingFactory.createInstance();

        // 3. Object pool
        UsingConstructor obj3 = ObjectPool.getInstance();

        // 4. Clone method
        CloneableClass original = new CloneableClass();
        CloneableClass obj4 = original.clone();

        // 5. Deserialization
        SerializableClass serObj = new SerializableClass();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        new ObjectOutputStream(bos).writeObject(serObj);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        SerializableClass obj5 = (SerializableClass) new ObjectInputStream(bis).readObject();

        // 6. Reflection
        Constructor<UsingConstructor> constructor = UsingConstructor.class.getConstructor();
        UsingConstructor obj6 = constructor.newInstance();

        System.out.println("All instances created successfully");

    }
}
