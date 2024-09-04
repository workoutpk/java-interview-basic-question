package interview;

public class BrillioExample {
        final int  num=10;
        int a;
        int b=10 ;
        public  int sum(){
                return a+b;
        }
        public  int add(){
                 int r = new BrillioExample().sum() ;
                 return r;
        }
        public  void display(){
                int num =15;
                Runnable r  = new Runnable() {
                        final int num=20;
                        public void run() {
                                int num=25;
                                System.out.println(this.num);

                        }
                };
                r.run();
        }
        public static void main(String[] args) {
                BrillioExample brillioExample = new BrillioExample();
                brillioExample.display();
                int val=1;
                System.out.println(brillioExample.sum()+brillioExample.add());
        }
}
