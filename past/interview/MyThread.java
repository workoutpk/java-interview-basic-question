package past.interview;

public class MyThread extends Thread{
    Hello h;

    public MyThread(Hello h) {
        this.h = h;
    }
    public void run(){
        h.show();
    }
}
