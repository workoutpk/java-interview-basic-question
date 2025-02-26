package past.interview;

public class SumFunctional {
    public static void main(String[] args) {
        NewAdd  add =  (a,b) ->  a + b ;
        System.out.println(add.sumOfNumber(2,4));
    }
}
