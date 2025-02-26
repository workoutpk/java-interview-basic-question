package past.interview;

public class MultiThread {
    public static void main(String[] args) {
        Hello hello= new Hello();
        MyThread th1 = new MyThread(hello);
        MyThread th2 = new MyThread(hello);
        th1.start();
        th2.start();
    }
}
