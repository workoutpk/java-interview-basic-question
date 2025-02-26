package dsa.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ArrayConversion {
    public static void main(String[] args) {
        // Input array of words
        String[] words = {"fooo", "barr", "wing", "ding", "wing"};

        // Use a HashSet to get distinct elements
        HashSet<String> distinctWordsSet = new HashSet<>(Arrays.asList(words)); // To Set
        List<String> distinctWordsList = new LinkedList<>(Arrays.asList(words));// To List
        System.out.println("Array to Set ..  "+distinctWordsSet);
        System.out.println("Array to Lis ..  "+distinctWordsList);


        // Convert the HashSet back to an array (optional)
        String[] distinctWordsArray1= distinctWordsSet.toArray(new String[0]);
        String[] distinctWordsArray2 = distinctWordsList.toArray(new String[0]);

        System.out.println("Set to array .." + Arrays.toString(distinctWordsArray1));
        System.out.println("Lis to array .." + Arrays.toString(distinctWordsArray2));
    }
}
