package past.interview;


import java.util.*;

public class Test2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            result.add(nums[i]);
        }
        for (int i = 0; i < result.size(); i++) {
            if(i +k <= nums.length){
                List<Integer> integerList = result.subList(i, i+k);
                Optional<Integer> max= integerList.stream().sorted(Comparator.reverseOrder()).findFirst();
                output.add(max.get());
            }
        }
        int[] maxNum = new int[output.size()];

        for (int i = 0; i < output.size(); i++) {
            maxNum[i] = output.get(i);
        }
        return maxNum;
    }
    public static void main(String[] args) {
        int[] testArray = {1};
        System.out.println(Arrays.toString(maxSlidingWindow(testArray, 1)));


    }
}
