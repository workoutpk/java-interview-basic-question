package dsa.dp;

public class BinarySearchRecursive {
    public static int binarySearch(int[] array, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the target is present at mid
            if (array[mid] == target) {
                return mid;
            }

            // If target is smaller, search the left half
            if (array[mid] > target) {
                return binarySearch(array, low, mid - 1, target);
            }

            // If target is larger, search the right half
            return binarySearch(array, mid + 1, high, target);
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = binarySearch(array, 0, array.length - 1, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
