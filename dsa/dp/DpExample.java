package dsa.dp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DpExample {
    public static void main(String[] args) {
        TreeMap<String,Integer> longTreeMap = new TreeMap<>();
        longTreeMap.put("ap",4);
        longTreeMap.put("bp",4);
        longTreeMap.put("cp",4);
        longTreeMap.put("dp",4);
        longTreeMap.put("ep",4);
        System.out.println("Before Modification "+longTreeMap);
        Stream<Object> modTreeMap =  longTreeMap.entrySet().stream().map(m-> {
            return new AbstractMap.SimpleEntry<>(m.getKey(), m.getValue() *2 );
        });

        System.out.println(modTreeMap.collect(Collectors.toList()));

        Map<String, Integer> modifiedMap1 = longTreeMap.entrySet().stream()
                .map(m -> {
                    return new AbstractMap.SimpleEntry<>(m.getKey(), m.getValue() * 2);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        // Initialize a TreeMap with some entries

        List<String> words = List.of("apple", "banana", "cherry");

        Map<String, Integer> wordLengthMap = words.stream()
                .collect(Collectors.toMap(
                        word -> word,          // key: the word itself
                        String::length         // value: length of the word
                ));

        System.out.println(wordLengthMap);


        List<Person> people = Arrays.asList(
                new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(3, "Charlie")
        );

        // Collect to Map with id as key and name as value
        Map<Integer, String> personMap = people.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));

        System.out.println(personMap); // Output: {1=Alice, 2=Bob, 3=Charlie}

        Map<Integer, String> personMapNew = people.stream()
                .collect(Collectors.toMap(
                        Person::getId,
                        Person::getName,
                        (existingValue, newValue) -> existingValue // keep the existing value in case of duplicate keys
                ));
    }
}
