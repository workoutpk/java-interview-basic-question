package past.interview;

import java.util.HashSet;
import java.util.Set;

public class CommonCharacters {
    public static void main(String[] args) {
        String[] words = {"plan", "plot", "play"};
        Set<Character> commonChars = findCommonCharacters(words);

        System.out.println("Common characters: " + commonChars);
    }

    public static Set<Character> findCommonCharacters(String[] words) {
        // Use a set to store characters from the first word
        Set<Character> commonChars = new HashSet<>();

        // Add all characters of the first word to the set
        for (char c : words[0].toCharArray()) {
            commonChars.add(c);
        }

        // Iterate through the remaining words
        for (int i = 1; i < words.length; i++) {
            Set<Character> currentWordChars = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                currentWordChars.add(c);
            }
            // Retain only characters that are present in both sets
            commonChars.retainAll(currentWordChars);
        }

        return commonChars;
    }
}
