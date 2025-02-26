package past.interview;

import java.util.ArrayList;
import java.util.List;

public class LLP {

    public static  boolean isValidPatternString(String a, String b){

        if(a.isEmpty() || b.isEmpty()){
            return false;
        } else if (a.length() != b.length()) {
            return false;
        }

        String[] first  = a.split("");
        String[] second  = b.split("");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            stringList.add(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            stringList.remove(second[i]);
        }
        if (stringList.isEmpty()){
            return true;
        }else {
            return false;
        }

    }
    public static void main(String[] args) {
        String a = "aab";
        String b = "abb";
        System.out.println("Output  ::: "+isValidPatternString(a,b));
    }
}
