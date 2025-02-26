package past.interview;

import java.util.*;

public class BInterviewExample2 {
    public static void main(String[] args) {
        String chars = "atach";
        String[] words ={"cat","bt","hat","tree"};
//        String[] words = {"hello","world","leetcode"};
//        String chars = "welldonehoneyr";
        Set<String> charSet  = new HashSet<>();
        String[] charArray = chars.split("");
        System.out.println(Arrays.toString(charArray));
        Collections.addAll(charSet, charArray);
        System.out.println(charSet);
        Set<String> stringList = new HashSet<>();

        for (String word : words) {
            String[] indexWord = word.split("");
            boolean allContain = true;
            for (String s : indexWord) {
                if (!charSet.contains(s)) {
                    allContain =false;
                    break;
                }

            }
            if(allContain){
                stringList.add(word);
            }
        }
        Optional<String> goodWordCount = stringList.stream().reduce((a,b)-> String.valueOf(Integer.valueOf(a.length()+ b.length())));
        int count  = 0;
        if(goodWordCount.isPresent()){
            count =Integer.parseInt(goodWordCount.get());
        }
        System.out.println("List of good words..... " + count);
    }
}
