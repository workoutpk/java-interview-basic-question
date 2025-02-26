package demo;

import java.util.Arrays;
import java.util.List;

public class PredicateDemo {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = List.of(2,3,4,6,8);
		list1.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.println("print  Even: " + t));
		list2.stream().filter(l-> l % 2 == 0).forEach(System.out::println);
	}
}
