package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortedList {
    public static void main(String[] args) {
        // Create the outer ArrayList
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();

        // Create inner ArrayLists and add elements
        ArrayList<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(4);
        firstList.add(5);

        ArrayList<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(3);
        secondList.add(4);

        ArrayList<Integer> thirdList = new ArrayList<>();
        thirdList.add(2);
        thirdList.add(6);

        // Add inner lists to the outer list
        listOfLists.add(firstList);
        listOfLists.add(secondList);
        listOfLists.add(thirdList);

        System.out.println(listOfLists);
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1,4,5),
                Arrays.asList(1,3,4),
                Arrays.asList(2,6)
                );

        List<Integer> list1  = lists.stream().flatMap(Collection::stream).toList();
        System.out.println(list1.stream().sorted().toList());
    }
}
