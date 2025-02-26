package file;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class Employees implements Externalizable {
    // Transient variables won't be serialized by default
    private int employeeId;
    private String name;
    private transient int age;
    private Department department;
    private transient Date createdAt;

    // No-arg constructor required for Externalizable
    public Employees() {
        // Default constructor
        this.createdAt = new Date(); // Set current time during deserialization
    }

    // Parameterized constructor
    public Employees(int employeeId, String name, int age, Department department) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.createdAt = new Date();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Custom serialization process
        // Control exactly what and how to write
        out.writeInt(employeeId);
        out.writeObject(name);

        // Custom handling of transient and sensitive fields
        out.writeInt(age);
        out.writeObject(department);

        // Optionally write additional metadata
        out.writeLong(createdAt.getTime());
    }



    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Custom deserialization process
        // Must read in the same order as written
        this.employeeId = in.readInt();
        this.name = (String) in.readObject();

        // Read transient fields
        this.age = in.readInt();
        this.department = (Department) in.readObject();

        // Reconstruct Date from stored timestamp
        this.createdAt = new Date(in.readLong());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", createdAt=" + createdAt +
                '}';
    }


}
