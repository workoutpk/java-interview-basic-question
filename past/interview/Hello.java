package past.interview;

public class Hello {
    synchronized void show(){
        Thread th = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            try {
                wait(1000);
                System.out.println(th.getName() + "-SHOW :" +i+"\t"+this);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
