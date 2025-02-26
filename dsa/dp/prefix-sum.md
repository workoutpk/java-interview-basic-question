## Prefix Sum
Here’s an example of using **Prefix Sum** in Java. Prefix Sum is a technique where you preprocess an array to calculate cumulative sums, allowing you to answer range sum queries efficiently.
specific range [i, j]
To find the sum between indices i and j, use the formula: P[j] - P[i-1].
---

### **Code Example: Prefix Sum in Java**

```java
public class PrefixSumExample {

    // Method to compute the prefix sum array
    public static int[] computePrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0]; // Initialize the first element

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        return prefixSum;
    }

    // Method to calculate the sum of a range [l, r] using the prefix sum array
    public static int rangeSum(int[] prefixSum, int l, int r) {
        if (l == 0) {
            return prefixSum[r];
        } else {
            return prefixSum[r] - prefixSum[l - 1];
        }
    }

    public static void main(String[] args) {
        // Input array
        int[] arr = {2, 4, 6, 8, 10};
        
        // Compute prefix sum
        int[] prefixSum = computePrefixSum(arr);

        // Example range queries
        int l1 = 1, r1 = 3; // Sum of elements from index 1 to 3
        int l2 = 0, r2 = 4; // Sum of elements from index 0 to 4

        System.out.println("Prefix Sum Array: ");
        for (int val : prefixSum) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println("Sum of range [" + l1 + ", " + r1 + "]: " + rangeSum(prefixSum, l1, r1));
        System.out.println("Sum of range [" + l2 + ", " + r2 + "]: " + rangeSum(prefixSum, l2, r2));
    }
}
```

---

### **Explanation**

1. **Input Array**: `{2, 4, 6, 8, 10}`.
2. **Prefix Sum Array**:
    - `prefixSum[0] = arr[0] = 2`
    - `prefixSum[1] = prefixSum[0] + arr[1] = 2 + 4 = 6`
    - `prefixSum[2] = prefixSum[1] + arr[2] = 6 + 6 = 12`
    - `prefixSum[3] = prefixSum[2] + arr[3] = 12 + 8 = 20`
    - `prefixSum[4] = prefixSum[3] + arr[4] = 20 + 10 = 30`

   Final Prefix Sum Array: `{2, 6, 12, 20, 30}`.

3. **Range Queries**:
    - For range `[1, 3]`:
      \[
      \text{Sum} = \text{prefixSum}[3] - \text{prefixSum}[0] = 20 - 2 = 18
      \]
    - For range `[0, 4]`:
      \[
      \text{Sum} = \text{prefixSum}[4] = 30
      \]

---

### **Output**
```
Prefix Sum Array: 
2 6 12 20 30 
Sum of range [1, 3]: 18
Sum of range [0, 4]: 30
```

---

### **Advantages of Prefix Sum**
- Efficient for multiple range sum queries.
- Time Complexity:
    - **Preprocessing**: \(O(n)\) (to compute the prefix sum array).
    - **Range Sum Query**: \(O(1)\).