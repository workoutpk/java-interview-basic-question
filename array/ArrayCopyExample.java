package array;

public class ArrayCopyExample {
    public static void main(String[] args) {
        // Source array
        int[] sourceArray = {1, 2, 3, 4, 5};

        // Destination array
        int[] destArray = new int[7];  // Larger than source array

        // Initialize destArray with some values
        destArray[5] = 6;
        destArray[6] = 7;

        // Print initial arrays
        System.out.println("Source array: " + java.util.Arrays.toString(sourceArray));
        System.out.println("Initial destination array: " + java.util.Arrays.toString(destArray));

        // Use System.arraycopy()
        System.arraycopy(sourceArray, 0, destArray, 2, sourceArray.length);

        // Print the result
        System.out.println("Final destination array: " + java.util.Arrays.toString(destArray));

        /*The parameters are:

        sourceArray: The array from which we're copying elements.
        0: The starting index in the source array.
        destArray: The array into which we're copying elements.
        2: The starting index in the destination array.
        sourceArray.length: The number of elements to copy.
        When you run this program, you'll see output similar to this:*/
    }
}
