Let me explain how to calculate time complexity in Java with practical examples:

```java
// O(1) - Constant Time
void constantTime(int[] arr) {
    System.out.println(arr[0]);  // Direct access
}

// O(n) - Linear Time
void linearTime(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }
}

// O(n²) - Quadratic Time
void quadraticTime(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[i] + arr[j]);
        }
    }
}

// O(log n) - Logarithmic Time
int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}

// O(n log n) - Linearithmic Time
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
```

Common Time Complexities and their Characteristics:

1. **O(1) - Constant Time**
```java
// Examples of O(1) operations:
HashMap<String, Integer> map = new HashMap<>();
map.put("key", 1);     // O(1)
map.get("key");        // O(1)
arr[0] = 5;           // O(1)
```

2. **O(n) - Linear Time**
```java
// Finding maximum element
int findMax(int[] arr) {
    int max = arr[0];  // O(1)
    for (int i = 1; i < arr.length; i++) {  // O(n)
        if (arr[i] > max) max = arr[i];
    }
    return max;
}
```

3. **O(n²) - Quadratic Time**
```java
// Bubble Sort
void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap arr[j] and arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

4. **O(log n) - Logarithmic Time**
```java
// Binary Search Tree operations
class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
    }
}

Node search(Node root, int key) {
    if (root == null || root.data == key) return root;
    if (root.data > key) return search(root.left, key);
    return search(root.right, key);
}
```

5. **Space Complexity Examples**:
```java
// O(n) Space
int[] createArray(int n) {
    int[] arr = new int[n];  // Space grows with input
    return arr;
}

// O(1) Space
int findSum(int[] arr) {
    int sum = 0;  // Constant extra space
    for (int num : arr) {
        sum += num;
    }
    return sum;
}
```

6. **Combined Time Complexities**:
```java
// O(n) + O(n²) = O(n²)
void combinedComplexity(int[] arr) {
    // O(n)
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }
    
    // O(n²)
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[i] + arr[j]);
        }
    }
}
```

Key Points to Remember:
1. Always consider worst-case scenario
2. Drop constants and lower order terms
3. Consider both time and space complexity
4. Look for nested loops and recursion
5. Consider input size impact

Would you like me to elaborate on any specific aspect of time complexity or provide more examples?