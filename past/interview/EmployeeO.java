package past.interview;


import java.util.Objects;

public class EmployeeO {
    int id;
    String name;
    int age;
    long salary;
    String department;

    public EmployeeO(int id, String name, int age, long salary,String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EmployeeO employeeO = (EmployeeO) object;
        return id == employeeO.id && age == employeeO.age && salary == employeeO.salary && Objects.equals(name, employeeO.name) && Objects.equals(department, employeeO.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary, department);
    }
    // Method to check if any field is null or empty
    public boolean hasNullFields() {
        return name == null ||
                department == null ||
                age == 0 ||  // Assuming 0 is invalid age
                salary == 0;  // Assuming 0 is invalid salary
    }
}

