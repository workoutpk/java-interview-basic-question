package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("person.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person deserializedPerson = (Person) objectInputStream.readObject();
            System.out.println("Object has been deserialized");
            System.out.println("Deserialized object: " + deserializedPerson);
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
