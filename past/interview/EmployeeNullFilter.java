package past.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeNullFilter {
    // Method 1: Using Stream API
    public static List<EmployeeO> removeNullUsingStream(List<EmployeeO> employees) {
        return employees.stream()
                .filter(Objects::nonNull)  // Remove null Employee objects
                .filter(emp -> !emp.hasNullFields())  // Remove Employee with null fields
                .collect(Collectors.toList());
    }

    // Method 2: Using traditional approach
    public static List<EmployeeO> removeNullTraditional(List<EmployeeO> employees) {
        List<EmployeeO> filteredList = new ArrayList<>();

        for (EmployeeO emp : employees) {
            if (emp != null && !emp.hasNullFields()) {
                filteredList.add(emp);
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        // Create sample data
        List<EmployeeO> employees = new ArrayList<>();
        employees.add(new EmployeeO(1, "John", 30, 50000, "IT"));
        employees.add(null);
        employees.add(new EmployeeO(2, null, 25, 45000, "HR"));
        employees.add(new EmployeeO(3, "Alice", 28, 55000, null));
        employees.add(new EmployeeO(4, "Bob", 35, 60000, "Finance"));

        // Using Stream API
        System.out.println("Using Stream API:");
        List<EmployeeO> filteredStream = removeNullUsingStream(employees);
        filteredStream.forEach(emp ->
                System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName()));

        // Using traditional approach
        System.out.println("\nUsing Traditional Approach:");
        List<EmployeeO> filteredTraditional = removeNullTraditional(employees);
        filteredTraditional.forEach(emp ->
                System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName()));
    }
}

