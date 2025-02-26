package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MedianOfSortedArray {
    public static void main(String[] args) {
        int [] nums1 = {1,3}, nums2 = {2};
        int[] nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
        List<Integer> numbers = Arrays.stream(nums3).sorted().boxed().toList();
        Arrays.sort(nums3);
        System.out.println(numbers);
        Double median = (double) 0;
        if(numbers.size()%2 == 0){
            median = ((double) (nums3[(numbers.size()/2)] + nums3[(numbers.size()/2) -1]))/2;
        }else {
            if(numbers.size() < 2){
                median = (double) nums3[0];
            }else {
                median = (double) nums3[(numbers.size()/2)];
            }

        }
        System.out.println("Median  ::::  " + median);
    }
}
