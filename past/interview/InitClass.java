package past.interview;

import java.util.*;
import java.util.stream.Collectors;

public class InitClass {
    public static void main(String[] args) {
        List<String> stringList = List.of("syed-76","prajapati-90","arshul-12", "hasan-36"); //arshul
        Map<String, String> map = new HashMap<>();
        List<String> integerList = new ArrayList<>();
        Map<String, String> map1 = stringList.stream()
                .map(ele-> {
                    List<String > list1 = Arrays.stream(ele.split("-")).toList();
                   return new AbstractMap.SimpleEntry<>(list1.get(0),list1.get(1));
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function in case of duplicates
                        LinkedHashMap::new // Ensures insertion order is maintained (sorted order)
                ));



        System.out.println(map1);

        String nameOfString = stringList.stream()
                .map(ele -> {
                    List<String> stringList1 = Arrays.stream(ele.split("-")).toList();
                    integerList.add(stringList1.get(1));
                    return stringList1.get(1);
                }).min(Comparator.naturalOrder()).get();

        System.out.println("String smallest value  :::: " + stringList.get(integerList.indexOf(nameOfString)));
        //.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
    }
}
