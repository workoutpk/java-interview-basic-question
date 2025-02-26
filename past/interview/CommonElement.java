package past.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonElement {
    public static void main(String[] args) {
        int[] arr1 = {2,4,6,7,8,0};
        int[] arr2 = {2,3,6,11,8,0};

        Set<Integer>  s1 = new HashSet<>();
        Set<Integer>  s2 = new HashSet<>();
        for (Integer a: arr1) {
            s1.add(a);
        }

        for (Integer a: arr2) {
            if (s1.contains(a)) {
                s2.add(a); // Add to common set if found
            }
        }
        System.out.println((s2));
    }
}
