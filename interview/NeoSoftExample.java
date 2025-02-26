package interview;

public class NeoSoftExample {
    private static void m1(String str){
        System.out.println("str");
    }
    private static void m1(Object obj){
        System.out.println("obj");
    }

    public static void main(String[] args) {
        m1(null);

    }
}
