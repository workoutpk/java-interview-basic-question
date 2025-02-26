package file;

import java.io.*;

public class ExternalizationExample2 {
    // Method to serialize Employee object
    private static void serializeEmployee(Employees employee) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("employee.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employee);
            System.out.println("Employee object serialized successfully.");
        }
    }

    // Method to deserialize Employee object
    private static Employee deserializeEmployee() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("employee.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Employee employee = (Employee) ois.readObject();
            System.out.println("Employee object deserialized successfully.");
            return employee;
        }
    }
    public static void main(String[] args) {
        try {
            // Create an Employee object
            Employees originalEmployee = new Employees(
                    1001,
                    "John Doe",
                    30,
                    new Department("Engineering", "Tech Division")
            );

            // Serialization
            serializeEmployee(originalEmployee);

            // Deserialization
            Employee deserializedEmployee = deserializeEmployee();

            // Print original and deserialized objects
            System.out.println("Original Employee: " + originalEmployee);
            System.out.println("Deserialized Employee: " + deserializedEmployee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
