package interview;

import stream.BiFunctionExample;

import java.util.List;
import java.util.function.BiFunction;

public class CallAndApplyExample {

        public static void main(String[] args) {
                BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction = new BiFunctionExample();
                BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
                System.out.println(add.apply(10,20));
        }
}
