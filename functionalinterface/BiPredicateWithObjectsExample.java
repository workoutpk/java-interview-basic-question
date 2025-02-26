package functionalinterface;

import java.util.function.BiPredicate;

public class BiPredicateWithObjectsExample {
    public static void main(String[] args) {
        BiPredicate<Person, Person> areAgesEqual = (p1, p2) -> p1.age == p2.age;

        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 30);

        // Comparing the ages of person1 and person2
        System.out.println(areAgesEqual.test(person1, person2));  // Output: true

        // Comparing the ages of person1 and person3
        System.out.println(areAgesEqual.test(person1, person3));  // Output: false
    }
}
