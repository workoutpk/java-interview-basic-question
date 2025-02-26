package past.interview;


import java.util.*;

public class Test12 {
    public static String getPermutation(String str, int k) {
        // Convert string to character array
        char[] chars = str.toCharArray();
        Arrays.sort(chars); // Sort characters to handle lexicographical order

        // Create a list for easy removal
        List<Character> charList = new ArrayList<>();
        for (char c : chars) {
            charList.add(c);
        }

        // Adjust k to be zero-based index
        k--;

        StringBuilder sb = new StringBuilder();

        int n = str.length();

        // Compute factorials
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        // Build the k-th permutation
        for (int i = 0; i < n; i++) {
            int idx = k / factorials[n - 1 - i]; // Determine which index to use
            sb.append(charList.get(idx)); // Append the character at that index
            charList.remove(idx); // Remove used character from list
            k %= factorials[n - 1 - i]; // Update k for next iteration
        }

        return sb.toString();
    }
    public static int[] rotatingArray(int[] arr, int s){
        int numOfRotation;
        if(s > arr.length){
            numOfRotation= s/arr.length;
        }else {
            numOfRotation=s;
        }
        int[] result = new int[arr.length];
        int[] arr1 = Arrays.stream(arr).limit(numOfRotation).toArray();
        int[] arr2 = Arrays.stream(arr).skip(numOfRotation).toArray();
        System.arraycopy(arr2, 0, result, 0, arr2.length);
        System.arraycopy(arr1, 0, result, arr2.length, arr1.length);
        return result;
    }
    public static List<Integer> shifting(List<Integer> integerList){
        List<Integer> shiftingList = new ArrayList<>();

        return shiftingList;
    }
//    public static String getPermutation(int[] arr, int k){
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            list.add(arr[i]);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            List<Integer>  integerList = new ArrayList<>();
//            int[] shiftingAray = rotatingArray(arr, i);
//            for (int j = 0; j < shiftingAray.length; j++) {
//                integerList.add(shiftingAray[j]);
//            }
//            System.out.println(integerList);
//
//        }
//
//        return "s";
//    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        String str = "2314";
        int k =4;
        int n =4;
        String s = getPermutation(str,k);
        System.out.println( "Permutation String ::  "+s.toString() );
        // Compute factorials
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        System.out.println(Arrays.toString(factorials));
    }
}
