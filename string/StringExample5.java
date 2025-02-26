package string;

public class StringExample5 {
    StringExample5(){
        sendMessage(null); // Where ever position of sendMessage() function String method will call;
    }
    public void sendMessage(Object object){
        System.out.println("Object Method will call");
    }

    public void sendMessage(String s){
        System.out.println("String Method will call");
    }
    public static void main(String[] args) {
        StringExample5 stringExample5 = new StringExample5();
        System.out.println(0.1*3 == 0.3); // false
        Double a = 0.1 *3;
        Double b = 0.3;
        System.out.println(a);
        System.out.println(b);
    }
}
