package dsa.map;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExamples {
    static class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
        }

        public String getName() { return name; }
        public List<Employee> getEmployees() { return employees; }
    }

    static class Employee {
        private String name;
        private List<Skill> skills;

        public Employee(String name, List<Skill> skills) {
            this.name = name;
            this.skills = skills;
        }

        public String getName() { return name; }
        public List<Skill> getSkills() { return skills; }
    }

    static class Skill {
        private String name;
        private int level;

        public Skill(String name, int level) {
            this.name = name;
            this.level = level;
        }

        public String getName() { return name; }
        public int getLevel() { return level; }

        @Override
        public String toString() {
            return name + " (Level " + level + ")";
        }
    }

    List<Department> departments = Arrays.asList(
            new Department("IT", Arrays.asList(
                    new Employee("John", Arrays.asList(
                            new Skill("Java", 5),
                            new Skill("Python", 4)
                    )),
                    new Employee("Jane", Arrays.asList(
                            new Skill("JavaScript", 5),
                            new Skill("React", 4)
                    ))
            )),
            new Department("HR", Arrays.asList(
                    new Employee("Bob", Arrays.asList(
                            new Skill("Communication", 5),
                            new Skill("Leadership", 4)
                    ))
            ))
    );
    public static void main(String[] args) {
        // Example 1: Students and Courses
        System.out.println("Example 1: Students and Their Courses");
        List<Student> students = Arrays.asList(
                new Student("John", Arrays.asList(
                        new Course("Java", "Prof. Smith"),
                        new Course("Python", "Prof. Johnson")
                )),
                new Student("Jane", Arrays.asList(
                        new Course("Database", "Prof. Wilson"),
                        new Course("JavaScript", "Prof. Davis")
                ))
        );


        // Get all courses using flatMap
        List<Course> allCourses = students.stream()
                .flatMap(student -> student.getCourses().stream())
                .toList();

        System.out.println("All courses:");
        allCourses.forEach(System.out::println);

        // Get all unique instructors
        List<String> allInstructors = students.stream()
                .flatMap(student -> student.getCourses().stream())
                .map(Course::getInstructor)
                .distinct()
                .toList();

        System.out.println("\nAll instructors:");
        allInstructors.forEach(System.out::println);

        // Example 2: Working with nested lists
        System.out.println("\nExample 2: Working with Nested Lists");
        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedNumbers = nestedNumbers.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Flattened numbers: " + flattenedNumbers);

        // Calculate squares of flattened numbers
        List<Integer> squares = nestedNumbers.stream()
                .flatMap(List::stream)
                .map(n -> n * n)
                .toList();

        System.out.println("Squares: " + squares);


        // Example 3: Working with Optional
        System.out.println("\nExample 3: Working with Optional");
        List<Optional<String>> optionals = Arrays.asList(
                Optional.of("Hello"),
                Optional.empty(),
                Optional.of("World"),
                Optional.empty(),
                Optional.of("!")
        );

        List<String> nonEmptyStrings = optionals.stream()
                .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))
                .toList();

        System.out.println("Non-empty strings: " + nonEmptyStrings);


        List<Department> departments = Arrays.asList(
                new Department("IT", Arrays.asList(
                        new Employee("John", Arrays.asList(
                                new Skill("Java", 5),
                                new Skill("Python", 4)
                        )),
                        new Employee("Jane", Arrays.asList(
                                new Skill("JavaScript", 5),
                                new Skill("React", 4)
                        ))
                )),
                new Department("HR", Arrays.asList(
                        new Employee("Bob", Arrays.asList(
                                new Skill("Communication", 5),
                                new Skill("Leadership", 4)
                        ))
                ))
        );

        // Get all skills across departments
        List<Skill> allSkills = departments.stream()
                .flatMap(dept -> dept.getEmployees().stream())
                .flatMap(emp -> emp.getSkills().stream())
                .collect(Collectors.toList());

        System.out.println("All skills across departments:");
        allSkills.forEach(System.out::println);

        // Get employees with high-level skills (level >= 5)
        Map<String, List<String>> highLevelSkillsByDepartment = departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        dept -> dept.getEmployees().stream()
                                .flatMap(emp -> emp.getSkills().stream()
                                        .filter(skill -> skill.getLevel() >= 5)
                                        .map(skill -> emp.getName() + ": " + skill.getName()))
                                .collect(Collectors.toList())
                ));

        System.out.println("\nEmployees with high-level skills by department:");
        highLevelSkillsByDepartment.forEach((dept, skills) ->
                System.out.println(dept + ": " + skills));

        // Example 5: String Operations
        System.out.println("\nExample 5: String Operations");
        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java Programming",
                "Stream API"
        );


        // Split sentences into words and get unique words
        List<String> uniqueWords = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .toList();

        System.out.println("Unique words: " + uniqueWords);

        // Count characters in all words
        long totalChars = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .mapToInt(String::length)
                .sum();

        System.out.println("Total characters in all words: " + totalChars);
    }
}
