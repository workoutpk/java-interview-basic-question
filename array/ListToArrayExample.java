package array;

import java.util.Arrays;
import java.util.List;

public class ListToArrayExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 5, 6, 7, 8);
        Integer[] arrays1 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arrays1));
    }
}
