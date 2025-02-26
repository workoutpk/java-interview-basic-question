package past.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Test16 {
    public static void main(String[] args) {
        //Output - average salary of employee who's age is greater than 30
        List<Employee>  employeeList = new ArrayList<>();
        employeeList.add(null);
        OptionalDouble averageSalaryOfEmployee  = employeeList.stream().filter(f->f.getAge() > 30 ).map(m->m.getSalary())
                .mapToInt(mi->mi.intValue()).average();

        System.out.println("Average Salary Of Employee :::  " + averageSalaryOfEmployee);

        List<EmployeeO> employeeOS = new ArrayList<>();
    }
}
