package interview;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class LegatoInterview {
        public static void main(String[] args) {
                Integer[] intArr = {0,1,0,1,1,0,1,0,0,1,1,1};
                for (int i = 1; i <=20; i++) {
                        if(i%3==0){
                                if(i%5==0){
                                        System.out.println("My World");
                                }else {
                                        System.out.println("Hello");
                                }
                        } else if (i%5==0) {
                                System.out.println("World");
                        }else {
                                System.out.println(i);
                        }
                }


        }
}
