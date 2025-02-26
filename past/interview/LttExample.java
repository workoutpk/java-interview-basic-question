package past.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LttExample {

    public static void main(String[] args) {
        String s = "java is programing language";

        // Get the first character and convert it to uppercase
        List<String> stringList = Arrays.stream(s.split(" ")).map(m->{
            String string = String.valueOf(Character.toUpperCase(m.charAt(0)));
            return string.concat(m.substring(1));
        }).collect(Collectors.toList());
        System.out.println(stringList);

    }



}
