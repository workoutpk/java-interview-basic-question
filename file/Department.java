package file;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Department implements Externalizable {
    private String name;
    private String division;

    // No-arg constructor required for Externalizable
    public Department() {}

    public Department(String name, String division) {
        this.name = name;
        this.division = division;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Custom writing of object's state
        out.writeObject(name);
        out.writeObject(division);
    }



    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Custom reading of object's state
        this.name = (String) in.readObject();
        this.division = (String) in.readObject();
    }

    @Override
    public String toString() {
        return "Department{name='" + name + "', division='" + division + "'}";
    }


}
