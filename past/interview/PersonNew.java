package past.interview;

import java.util.Objects;

public class PersonNew {
    int id;
    String name;
    String address;
    int age;

    public PersonNew(int id, String name, String address, int age) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonNew{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PersonNew personNew = (PersonNew) object;
        return id == personNew.id && age == personNew.age && Objects.equals(name, personNew.name) && Objects.equals(address, personNew.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, age);
    }
}
