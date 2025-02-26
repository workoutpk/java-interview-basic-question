package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EyInterview {
    public static void main(String[] args) {
        int arr[] = {10, 22, 12, 3, 0, 6}; //22 12 6
        int nextNum= arr[arr.length-2];
        int j=0;
        Set<Integer> intigers = new HashSet<Integer>();
        for (int i = arr.length; i >=0  ; i--) {

            for (int k = i; k < arr.length; k++) {
                if(arr[i] < arr[k]){
                    intigers.add(arr[k]);
                }
            }
        }
        System.out.println(intigers);
    }

}
