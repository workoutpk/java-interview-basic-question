package dsa.dp;

import java.math.BigInteger;

public class LargeNumberSum {
    public static BigInteger largSum(BigInteger s1, BigInteger s2){
        return s1.add(s2);
    }
    public static void main(String[] args) {
        String s1  = "9999999999999999999999999999999999999999999999999999";
        String s2  = "12";
        BigInteger bigInteger1 = new BigInteger(s1);
        BigInteger bigInteger2 = new BigInteger(s2);
        System.out.println(largSum(bigInteger1,bigInteger2));
    }
}
