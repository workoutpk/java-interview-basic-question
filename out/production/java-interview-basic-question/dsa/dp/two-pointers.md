The **Two Pointers** technique is a common algorithmic strategy used to solve problems involving arrays or lists efficiently. It involves using two pointers, typically starting at different ends of the array or moving at different speeds.

---

### **Code Example: Two Pointers to Find a Pair with Given Sum**

Here’s an example using the Two Pointers technique to find a pair of numbers in a sorted array that adds up to a given target sum.

```java
public class TwoPointersExample {

    // Method to find a pair with the given target sum using two pointers
    public static boolean findPairWithSum(int[] arr, int target) {
        int left = 0; // Pointer starting from the beginning
        int right = arr.length - 1; // Pointer starting from the end

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println("Pair found: (" + arr[left] + ", " + arr[right] + ")");
                return true;
            } else if (sum < target) {
                // Move the left pointer to the right to increase the sum
                left++;
            } else {
                // Move the right pointer to the left to decrease the sum
                right--;
            }
        }

        System.out.println("No pair found with the given sum.");
        return false;
    }

    public static void main(String[] args) {
        // Sorted input array
        int[] arr = {1, 2, 3, 4, 6, 8, 9};

        // Target sum to find
        int target = 10;

        // Call the method
        findPairWithSum(arr, target);
    }
}
```

---

### **Explanation**

1. **Input Array**: The input array must be sorted for the Two Pointers technique to work efficiently.
2. **Two Pointers**:
    - `left`: Starts at the beginning of the array.
    - `right`: Starts at the end of the array.
3. **Logic**:
    - Compute the sum of the elements at `left` and `right`.
    - If the sum matches the target, a pair is found.
    - If the sum is smaller than the target, move the `left` pointer to the right to increase the sum.
    - If the sum is greater than the target, move the `right` pointer to the left to decrease the sum.
4. **Output**: The method prints the pair if found, or a message if no pair exists.

---

### **Example**

#### Input:
```java
int[] arr = {1, 2, 3, 4, 6, 8, 9};
int target = 10;
```

#### Output:
```
Pair found: (2, 8)
```

---

### **Advantages of Two Pointers**
1. **Efficiency**: Runs in \(O(n)\) time for sorted arrays.
2. **Simplicity**: Straightforward to implement for problems like finding pairs, triplets, or merging sorted arrays.

---

### **Variants of the Two Pointers Technique**
1. **Finding Triplets**: Extend the logic to use three pointers.
2. **Merging Sorted Arrays**: Use two pointers to merge two sorted arrays.
3. **Removing Duplicates**: Use two pointers to compress arrays in-place.