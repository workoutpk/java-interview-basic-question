package past.interview;

import java.util.*;

public class Harman {
    public static void main(String[] args) {
        List<PersonNew> persons = new ArrayList<>();
        persons.add(new PersonNew(1, "Ram" , "india", 22));
        persons.add(new PersonNew(2, "Amrit" , "india", 25));
        persons.add(new PersonNew(3, "Jack" , "india", 22));
        persons.add(new PersonNew(4, "Rahim" , "india", 27));
        persons.add(new PersonNew(5, "Amrit" , "india", 23));
        //sort name sort by age

        List<PersonNew> sortByPerson  = persons.stream().sorted(Comparator.comparing(PersonNew::getName)
                        .thenComparing(PersonNew::getAge))
                        .toList();
        System.out.println("Sort By Person" + sortByPerson);


        //Shift negative elements to the left of the array

        int[] array = {4,-3,8,9,-1,5,2,-10,-11,45};

        //expected output: {-3,-1,-10,-11,4,8,9,5,2,45};

        //1. don't sort the array
        //2. don't declare new array or collections
        //3. don't use any library function
        int countNegative =0;
        int countPositive =array.length-1;
        for (int i = 0; i < array.length; i++) {

            if(array[i] < 0){
                int num = array[countNegative];
                System.out.println(array[i] + " --- " +countNegative + "  : " +num);
                array[countNegative] = array[i];
                countNegative++;
                array[i] = num;
            }

        }
        System.out.println("array ::: " +Arrays.toString(array));
    }
}
