package array;

public class MergeArrayExample {
    public static int[] mergeArrays(int[] a, int[] b) {
        // Create a new array to hold the merged result
        int[] merged = new int[a.length + b.length];

        // Copy elements from the first array
        System.arraycopy(a, 0, merged, 0, a.length);

        // Copy elements from the second array
        System.arraycopy(b, 0, merged, a.length, b.length);

        return merged;

    }
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5};
        int[] b = {6, 7, 8, 9};

        // Merging the two arrays
        int[] mergedArray = mergeArrays(a, b);

        // Printing the merged array
        System.out.print("Merged Array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
