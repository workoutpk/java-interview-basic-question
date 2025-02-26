package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        System.out.println("Original object: " + person);
        // Serialization
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person); //writeObject
            System.out.println("Object has been serialized");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
