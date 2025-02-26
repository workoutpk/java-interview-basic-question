package dsa.array;

import java.util.Arrays;

public class ArrayRotateExample {
    public static void main(String[] args) {
        int[] originalArray = {1,2,3,4,5,6,7};
        int n = 10; // number of ratation
        int k;
        if(n > originalArray.length){
            k = n % originalArray.length;
        }else{
            k = n;
        }

        int[] rotationalArray1 = new int[originalArray.length - k];
        int[] rotationalArray2 = new int[k];
        int[] rotationalArray3 = new int[originalArray.length];
        int l = 0;
        for (int i = 0; i < originalArray.length - k; i++) {
            rotationalArray1[i] = originalArray[i];
        }
        for (int i = originalArray.length - k; i < originalArray.length ; i++) {
            rotationalArray2[l] = originalArray[i];
            l++;
        }
        System.out.println(Arrays.toString(rotationalArray1));
        System.out.println(Arrays.toString(rotationalArray2));
        System.arraycopy(rotationalArray1, 0, rotationalArray3, k, originalArray.length-k );
        System.arraycopy(rotationalArray2, 0, rotationalArray3, 0,  k );
        System.out.println("Final RotationalArray ::: "+Arrays.toString(rotationalArray3));
    }
}
