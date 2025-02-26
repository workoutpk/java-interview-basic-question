package file;

import java.io.Serializable;

public class Person implements Serializable {
    // It's a good practice to define serialVersionUID
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String tempData; // transient fields are not serialized

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.tempData = "This won't be serialized";
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", tempData='" + tempData + "'}";
    }
}
