package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SockMerchant {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int pairNumber = 0;
        Map<Integer, Long> integerIntegerMap = integerList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().filter(ele -> ele.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(integerIntegerMap);
        if (integerIntegerMap.size() > 0) {
            List<Long> mapSum = integerIntegerMap.values().stream()
                    .map(aLong -> {
                        return aLong / 2;
                    }).toList();
            Long aLong = mapSum.stream().reduce(Long::sum).get();
            pairNumber = Math.toIntExact(aLong);
        }
        System.out.println(pairNumber);
    }
}
