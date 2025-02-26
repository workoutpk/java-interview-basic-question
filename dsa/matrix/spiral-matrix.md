Here's a Java code to traverse and print a matrix in spiral order:

```java
class SpiralMatrix {
    public static void printSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // Print top row
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            
            // Print right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            
            if (top <= bottom) {
                // Print bottom row
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            
            if (left <= right) {
                // Print left column
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1,  2,  3,  4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9,  8,  7}
        };
        
        System.out.println("Matrix in spiral order:");
        printSpiral(matrix);
    }
}
```

How it works:

1. We use four pointers to track boundaries:
    - `top`: tracks top row
    - `bottom`: tracks bottom row
    - `left`: tracks leftmost column
    - `right`: tracks rightmost column

2. For each iteration of the outer loop:
   ```
   → → → →     First print top row
   ↓     ↓     Then print right column
   ↓     ↓     Then print bottom row
   ← ← ← ←     Finally print left column
   ```

3. After printing each boundary:
    - Increment `top` after printing top row
    - Decrement `right` after printing right column
    - Decrement `bottom` after printing bottom row
    - Increment `left` after printing left column

4. Additional checks to handle cases when matrix has single row or column

For the example matrix:
```
1  2  3  4
12 13 14 5
11 16 15 6
10 9  8  7
```

Output will be:
```
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
```

Time Complexity: O(m×n) where m and n are dimensions of matrix
Space Complexity: O(1) as we only use constant extra space

Alternative Version (returning list instead of printing):

```java
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
        return result;
    }
    
    int rows = matrix.length;
    int cols = matrix[0].length;
    int top = 0, bottom = rows - 1;
    int left = 0, right = cols - 1;
    
    while (top <= bottom && left <= right) {
        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
        top++;
        
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        right--;
        
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
        }
        
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
    }
    
    return result;
}
```

This version returns a List<Integer> containing the elements in spiral order instead of printing them directly.