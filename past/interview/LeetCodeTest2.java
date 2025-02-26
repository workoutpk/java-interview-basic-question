package past.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCodeTest2 {
    public static void main(String[] args) {
        String name = "rick";
        String typed = "kric";

        Map<String, Long> namegLongMap = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(namegLongMap);
        Map<String, Long> stringLongMap = Arrays.stream(typed.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(stringLongMap);
        String[] nameWord = name.split("");
        Boolean isTyped =true;
        List<Long> integerList = new ArrayList<>();
        for (int i = 0; i < nameWord.length; i++) {
            if(namegLongMap.containsKey(nameWord[i]) && stringLongMap.containsKey(nameWord[i])){
                if(namegLongMap.get(nameWord[i]) == stringLongMap.get(nameWord[i])){
                    integerList.add(namegLongMap.get(nameWord[i]));
                    if(integerList.size() == namegLongMap.size()){
                        isTyped = false;
                    }
                }
                else if(namegLongMap.get(nameWord[i]) > stringLongMap.get(nameWord[i])){
                    isTyped = false;
                }
            }else{
                isTyped =false;
            }

        }

        System.out.println("isTyped :: "+isTyped);



    }
}
