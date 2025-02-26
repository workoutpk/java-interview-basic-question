package dsa.dp;

import java.util.*;

public class FibonacciExample {
    public static List<Integer> fibonacciSeries(int n){
        List<Integer> fab= new LinkedList<>();
        fab.add(0);
        fab.add(1);
        int a = 0;
        int b = 0;
        int c = 0;
        while (fab.size() < n){
            a = fab.get(fab.size()-2);
            b = fab.get(fab.size()-1);
            c = a + b;
            fab.add(c);
        }
        return fab;
    }
    public static void main(String[] args) {
        int i =10;
        Optional<Integer> element = fibonacciSeries(i).stream().sorted(Comparator.reverseOrder()).findFirst();
        System.out.println("fibonacciSeries .... " + fibonacciSeries(i));
        System.out.println("Ith Element is  ....  "+element.get());
    }
}
