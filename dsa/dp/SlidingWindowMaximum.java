package dsa.dp;

import java.util.*;

class SlidingWindowMaximum {
    // Approach 1: Brute Force (Naive Solution)
    public int[] bruteForceMaxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            result[i] = max;
        }

        return result;
    }

    // Approach 2: Deque-based Optimal Solution
    public int[] optimizedMaxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        // Store indices of elements in deque
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices outside current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from rear
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element's index
            deque.offerLast(i);

            // Start storing maximum when first window is formed
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // Approach 3: Priority Queue Solution
    public int[] priorityQueueMaxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        // Max heap to store elements with their indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < nums.length; i++) {
            // Remove elements outside current window
            maxHeap.offer(new int[]{nums[i], i});

            // Remove elements outside window
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // Start storing maximum when first window is formed
            if (i >= k - 1) {
                result[ri++] = maxHeap.peek()[0];
            }
        }

        return result;
    }

    // Main method to demonstrate and test solutions
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Window Size: " + k);

        System.out.println("\nBrute Force Solution:");
        int[] bruteForceSolution = solution.bruteForceMaxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(bruteForceSolution));

        System.out.println("\nDeque-based Optimal Solution:");
        int[] dequeOptimalSolution = solution.optimizedMaxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(dequeOptimalSolution));

        System.out.println("\nPriority Queue Solution:");
        int[] priorityQueueSolution = solution.priorityQueueMaxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(priorityQueueSolution));
    }
}
