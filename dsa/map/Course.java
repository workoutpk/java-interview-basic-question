package dsa.map;

public class Course {
    private String name;
    private String instructor;

    public Course(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    public String getName() { return name; }
    public String getInstructor() { return instructor; }

    @Override
    public String toString() {
        return "Course{name='" + name + "', instructor='" + instructor + "'}";
    }
}
