package array;

import java.util.Arrays;
import java.util.List;

public class ArrayRotatingExample {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8};
        int shiftTimes = 11;
        if(shiftTimes > list.length){
            shiftTimes = shiftTimes % list.length;
        }
        int[] arr1 = Arrays.stream(list).limit(list.length -shiftTimes).toArray();
        int[] arr2 = Arrays.stream(list).skip(list.length-shiftTimes).toArray();
        int[] arr3 = new int[list.length];
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.arraycopy(arr2,0, arr3, 0, arr2.length);
        System.arraycopy(arr1,0, arr3, arr2.length, arr1.length);
        System.out.println(Arrays.toString(arr3));
    }
}
