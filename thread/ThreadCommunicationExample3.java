package thread;

public class ThreadCommunicationExample3 {
    int counter =1;
    static int N;
    public void printOddNumber(){
        synchronized (this){
            while (counter < N){
                while (counter % 2== 0)
                try {
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(counter + "");
                counter ++;
                notify();
            }
        }
    }
    public void printEvenNumber(){
        synchronized (this){
            while (counter < N){
                while (counter % 2 != 0)
                    try {
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                System.out.println(counter + "");
                counter ++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        N=10;
        ThreadCommunicationExample3 threadCommunicationExample3= new ThreadCommunicationExample3();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadCommunicationExample3.printOddNumber();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadCommunicationExample3.printEvenNumber();
            }
        });

        thread1.start();
        thread2.start();

    }

}
