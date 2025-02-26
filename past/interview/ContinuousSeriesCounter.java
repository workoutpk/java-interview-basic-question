package past.interview;

import java.util.List;

public class ContinuousSeriesCounter {
    public static int countContinuousSeries(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        }

        int count = 1; // Start with 1 as the first character is always a series
        char previousChar = number.charAt(0);

        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) != previousChar) {
                count++;
                previousChar = number.charAt(i);
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String number = "00011101010110010010";
        int result = countContinuousSeries(number);
        System.out.println("Number of continuous series: " + result);
//        Employee employee = new Employee();
//        List<String> empName= emplList.stream().filter(e->e.getEmpDept.equals("IT")).map(Employee::getEmpName).collect(Collectors.toList());

    }
}
