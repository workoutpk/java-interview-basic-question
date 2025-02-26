package dsa.dp;

import java.util.*;

public class SlidingWindowExamples {

    // 1. Fixed Size Sliding Window - Maximum Sum Subarray
    public static int maxSumSubarray(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        // First window calculation
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;

        // Sliding window
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // 2. Variable Size Sliding Window - Minimum Size Subarray Sum
    public static int minSubarraySum(int[] arr, int target) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            // Shrink window from left side
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // 3. Longest Substring with K Distinct Characters
    public static int longestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Expand window
            charFrequency.put(s.charAt(right),
                    charFrequency.getOrDefault(s.charAt(right), 0) + 1);

            // Contract window if more than k distinct characters
            while (charFrequency.size() > k) {
                charFrequency.put(s.charAt(left),
                        charFrequency.get(s.charAt(left)) - 1);

                if (charFrequency.get(s.charAt(left)) == 0) {
                    charFrequency.remove(s.charAt(left));
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // 4. Find All Anagrams in a String
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // If pattern is longer than string, return empty
        if (p.length() > s.length()) return result;

        // Frequency maps
        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];

        // Populate pattern frequency
        for (char c : p.toCharArray()) {
            patternFreq[c - 'a']++;
        }

        // First window
        for (int i = 0; i < p.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(patternFreq, windowFreq)) {
            result.add(0);
        }

        // Slide the window
        for (int i = p.length(); i < s.length(); i++) {
            // Add new character
            windowFreq[s.charAt(i) - 'a']++;

            // Remove oldest character
            windowFreq[s.charAt(i - p.length()) - 'a']--;

            // Check if current window is an anagram
            if (Arrays.equals(patternFreq, windowFreq)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println("Max Sum Subarray (k=3): " + maxSumSubarray(arr1, 3));

        int[] arr2 = {2, 3, 1, 2, 4, 3};
        System.out.println("Min Subarray Sum (target=7): " + minSubarraySum(arr2, 7));

        String s1 = "aabacbebebe";
        System.out.println("Longest Substring (k=3): " +
                longestSubstringKDistinct(s1, 3));

        String s2 = "cbaebabacd";
        String p = "abc";
        System.out.println("Anagram Indices: " + findAnagrams(s2, p));
    }
}
