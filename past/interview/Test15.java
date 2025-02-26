package past.interview;


import java.util.*;
import java.util.stream.Collectors;

public class Test15 {
    static Ao ao;
    static Bo bo;
    static Co co;
    Test15(){

    }


    private static Long maxProduct(String s) {
        List<String> stringList =  new ArrayList<>(List.of(s.split("")));
        List<String> subString = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                List<String> sub= stringList.subList(i, j);
                subString.add(String.join("", sub));
            }

        }
        List<String> palindromes = subString.stream()
                .filter(f->f.contentEquals(new StringBuilder(f).reverse()))
                .toList();
        Long num = null;

        System.out.println(palindromes);
        if(!palindromes.isEmpty()){
            if(palindromes.size() >1){
                num= Long.valueOf(palindromes.stream().map(String::length)
                        .sorted(Comparator.reverseOrder())
                                .filter(f->f %2 !=0)
                        .limit(2)
                        .reduce((a,b) -> a*b).get());
            }else {
                String sb = palindromes.get(0);
                num = Long.valueOf(sb.length());
            }
        }else {
            num = (long) s.length();
        }



        return num;
    }
    public static void main(String[] args) {
        String s = "ggbswiymmlevedhkbdhntnhdbkhdevelmmyiwsbgg";
        String st = "";
        System.out.println(maxProduct(s));

    }

}
