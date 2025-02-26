Let me explain the differences between Intermediate and Terminal operations in Java Streams:

Intermediate Operations:
- These operations return a new Stream
- Lazy evaluation (only executed when terminal operation is called)
- Can be chained together
- Don't produce final result

Common Intermediate Operations:
```java
// Examples of Intermediate Operations
1. filter()    - filters elements based on condition
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   numbers.stream().filter(n -> n > 2)

2. map()       - transforms elements
   numbers.stream().map(n -> n * 2)

3. sorted()    - sorts elements
   numbers.stream().sorted()

4. distinct()  - removes duplicates
   numbers.stream().distinct()

5. peek()      - performs operation without modifying stream
   numbers.stream().peek(System.out::println)

6. limit()     - limits stream size
   numbers.stream().limit(3)

7. skip()      - skips elements
   numbers.stream().skip(2)
```

Terminal Operations:
- Produce final result
- End stream pipeline
- Trigger actual execution of stream operations
- Can only be used once per stream

Common Terminal Operations:
```java
// Examples of Terminal Operations
1. collect()   - collects results into collection
   List<Integer> result = numbers.stream()
                                .filter(n -> n > 2)
                                .collect(Collectors.toList());

2. forEach()   - iterates through elements
   numbers.stream().forEach(System.out::println);

3. count()     - counts elements
   long count = numbers.stream().count();

4. reduce()    - reduces stream to single value
   Optional<Integer> sum = numbers.stream()
                                 .reduce((a, b) -> a + b);

5. min()/max() - finds min/max element
   Optional<Integer> min = numbers.stream()
                                 .min(Comparator.naturalOrder());

6. anyMatch()  - checks if any element matches
   boolean hasEven = numbers.stream()
                           .anyMatch(n -> n % 2 == 0);

7. allMatch()  - checks if all elements match
   boolean allPositive = numbers.stream()
                               .allMatch(n -> n > 0);

8. noneMatch() - checks if no elements match
   boolean noNegatives = numbers.stream()
                               .noneMatch(n -> n < 0);

9. findFirst() - returns first element
   Optional<Integer> first = numbers.stream()
                                   .findFirst();

10. findAny()  - returns any element
    Optional<Integer> any = numbers.stream()
                                  .findAny();
```

Complete Example:
```java
List<String> names = Arrays.asList("John", "Jane", "Jack", "Joe");

// Combining intermediate and terminal operations
List<String> result = names.stream()           // Create stream
    .filter(name -> name.startsWith("J"))      // Intermediate
    .map(String::toUpperCase)                  // Intermediate
    .sorted()                                  // Intermediate
    .collect(Collectors.toList());             // Terminal

// Example with multiple operations
int sum = numbers.stream()
    .filter(n -> n > 2)                        // Intermediate
    .map(n -> n * 2)                          // Intermediate
    .reduce(0, Integer::sum);                 // Terminal
```

Key Differences:
1. Execution:
    - Intermediate: Lazy evaluation
    - Terminal: Immediate execution

2. Result:
    - Intermediate: Returns new Stream
    - Terminal: Returns concrete result

3. Usage:
    - Intermediate: Can be chained
    - Terminal: Ends the chain

4. Frequency:
    - Intermediate: Multiple allowed
    - Terminal: Only one per stream

5. Purpose:
    - Intermediate: Transform data
    - Terminal: Produce final result