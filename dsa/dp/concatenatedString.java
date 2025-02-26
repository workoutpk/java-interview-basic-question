package dsa.dp;

import java.util.*;
import java.util.stream.Collectors;

public class concatenatedString {
    public static String[] rotatingArrayNormalOrder(String[] arr1, int times){
        if(times > arr1.length){
            times = arr1.length/times;
        }
        Arrays.sort(arr1);
        Object[] word1 = Arrays.stream(arr1).limit(times).toArray();
        Object[] word2 = Arrays.stream(arr1).skip(times).toArray();
        String[] word3 = new String[word1.length + word2.length];
        System.arraycopy(word2, 0, word3, 0, word2.length);
        System.arraycopy(word1, 0, word3, word2.length,word1.length);
        return word3;
    }
    public static String[] rotatingArrayReverseOrder(String[] arr1, int times){
        if(times > arr1.length){
            times = arr1.length/times;
        }
        // Sort the array in reverse order
        Arrays.sort(arr1, Collections.reverseOrder());
        Arrays.stream(arr1).sorted(Comparator.reverseOrder()).toArray();
        Object[] word1 = Arrays.stream(arr1).limit(times).toArray();
        Object[] word2 = Arrays.stream(arr1).skip(times).toArray();
        String[] word3 = new String[word1.length + word2.length];
        System.arraycopy(word2, 0, word3, 0, word2.length);
        System.arraycopy(word1, 0, word3, word2.length,word1.length);
        return word3;
    }

    private static void generatePermutations(String[] words, int index, List<String> result) {
        if (index == words.length) {
            // Concatenate the permutation into a single string and add to result
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = index; i < words.length; i++) {
            swap(words, index, i);
            generatePermutations(words, index + 1, result);
            swap(words, index, i); // backtrack
        }
    }

    private static void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
    // Method to get all starting indices of a substring in a string
    private static List<Integer> getAllIndices(String s, String word) {
        List<Integer> indices = new ArrayList<>();
        int index = s.indexOf(word);

        // Loop to find all occurrences
        while (index != -1) {
            indices.add(index);
            index = s.indexOf(word, index + 1); // Search for next occurrence
        }

        return indices;
    }
    public static void main(String[] args) {
        String s ="wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<String> stringList = new ArrayList<>();


        for (int i = 0; i < words.length; i++) {;
            String[] ra = rotatingArrayNormalOrder(words, i);
            String[] na = rotatingArrayReverseOrder(words, i);
            Optional<String> subStringList1 = Arrays.stream(ra).reduce(String::concat);
            Optional<String> subStringList2 = Arrays.stream(na).reduce(String::concat);
            stringList.add(subStringList1.get());
            stringList.add(subStringList2.get());
        }
        List<List<Integer>> indexOfSubstring = new ArrayList<>();


        List<String> concatenations = new ArrayList<>();

        generatePermutations(words, 0, concatenations);
        // Map to hold the results
        HashMap<String, List<Integer>> matchIndices = new HashMap<>();

        // Find all indices for each word in the array
        for (String word : concatenations) {
            matchIndices.put(word, getAllIndices(s, word));
        }
        for (int i = 0; i < concatenations.size(); i++) {
            indexOfSubstring.add(matchIndices.get(concatenations.get(i)));
        }
        Set<Integer> set1 = new HashSet<>(indexOfSubstring.stream().flatMap(List::stream).toList());
        List<Integer> result = new ArrayList<>(set1);
        System.out.println("IndexOfSubstring ::  " +result);
        System.out.println(concatenations);
    }
}
