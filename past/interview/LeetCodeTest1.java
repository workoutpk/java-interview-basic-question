package past.interview;

import java.util.*;

public class LeetCodeTest1 {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        List<Integer> sortedHeights = Arrays.stream(heights).sorted().boxed().toList();
        System.out.println(sortedHeights);
        List<Integer> count= new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            int a = sortedHeights.get(i);
            if(heights[i] != a){
                count.add(i);
            }
        }
        System.out.println("Totol Count .... " + count.size());
    }
}
