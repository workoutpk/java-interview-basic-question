package past.interview;


import java.util.concurrent.atomic.AtomicInteger;

public class Test5 {
    public  static  int num=10;
    public static int  counter = 1;
    private static final AtomicInteger  ATOMIC_INTEGER= new AtomicInteger(1);
    public void printOddNumber() throws InterruptedException {
        synchronized (this){
            while (counter <10){
                if(counter%2 == 0){
                    wait();
                }
                System.out.print(ATOMIC_INTEGER+", ");
                ATOMIC_INTEGER.getAndIncrement();
                counter ++;
                notify();
            }
        }

    }
    public void printEvenNumber() throws InterruptedException {
        synchronized (this){
            while (counter <10){
                if(counter%2 != 0){
                    wait();
                }

                System.out.println(ATOMIC_INTEGER+", ");
                ATOMIC_INTEGER.getAndIncrement();
                counter ++;
                notify();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int[] a= {1, 3, 5, 7, 9};

        int[] b= {2, 4, 6, 8, 10};
        Test5 test5 =  new Test5();
        Thread t1 = new Thread(()->{

            try {

                test5.printOddNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()->{
            try {
                test5.printEvenNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
