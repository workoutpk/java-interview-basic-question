package past.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static boolean isNumber(String str) {
        try {
            if(str.contains("Infinity") || str.contains("f")){
                return false;
            }

            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,1};
        Arrays.sort(nums);
        Set<Integer> integerSet = new HashSet<>();
        for (int a : nums) {
            integerSet.add(a);
        }
        System.out.println("Set element is " + integerSet);
        int positiveNums = 1;
        for (int i = 1; i <= nums.length; i++) {

            if (!integerSet.contains(i)) {
                positiveNums = i;
                break;
            }else {
                positiveNums = nums[i-1] +1;
            }

        }
        System.out.println("Smallest Positive Integer ::: " + positiveNums);
        String numberString = "123.45";
        String nonNumberString = "959440.94f";

        System.out.println(isNumber(numberString)); // Output: true
        System.out.println(isNumber(nonNumberString)); // Output: false
    }




}
