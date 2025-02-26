package file;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee implements Externalizable {
    private String name;
    private int age;
    private transient String password; // Will not be serialized unless explicitly handled

    // Public no-argument constructor
    public Employee() {
    }

    public Employee(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    // Implementing writeExternal to serialize the object's state
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(age);
        // Explicitly serialize the password
        out.writeUTF(password != null ? password : "");
    }

    // Implementing readExternal to deserialize the object's state
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        name = in.readUTF();
        age = in.readInt();
        password = in.readUTF();
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", password='" + password + "'}";
    }
}
