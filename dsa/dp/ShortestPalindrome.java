package dsa.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShortestPalindrome {
    public  String shortestPalindrome(String s){
        String ss =  String.valueOf(s);
        String append = null;
        String palindrom=null;
        String palidromString = "";
        List<String>  stringListOrginal =  new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                stringListOrginal.add(s.substring(i, j));
            }


        }
        List<String> stringList = stringListOrginal.stream().filter(f->f.length() > 2)
                .sorted(Comparator.comparingInt(String::length).reversed()).toList();
        System.out.println(stringList);
        String shortest = null;
        if(!stringList.isEmpty()){
            for (String sl:stringList) {
                String sr= String.valueOf(new StringBuffer(sl).reverse());
                if(sl.equals(sr)){
                    shortest =sl;
                    System.out.println("Shortest substring ::  " + sl);
                    break;
                }
            }

            if(shortest != null){
                append = s.substring(s.indexOf(shortest) +shortest.length());
                palindrom = shortest.concat(append);
                String reverseString = String.valueOf(new StringBuffer(append).reverse());
                palidromString = reverseString.concat(palindrom);
            }else {

                String a = String.valueOf(new StringBuffer(ss).reverse());
                palidromString = a.concat(ss.substring(1));
            }
        }else {
            if(ss.isEmpty()){
                palidromString ="";
            }else{
                String a = String.valueOf(new StringBuffer(ss).reverse());
                palidromString = a.concat(ss.substring(1));
            }

        }


        return palidromString;
    }
    public static void main(String[] args) {
        //Input: s = "aacecaaa"
        //Output: "aaacecaaa"
        String s = "aabba";
        ShortestPalindrome palindrome =  new ShortestPalindrome();
        System.out.println(palindrome.shortestPalindrome(s));
    }

}
