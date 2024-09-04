package interview;

import java.util.Scanner;

public class PageCount {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int i = scanner.nextInt();

                Double aDouble = scanner.nextDouble();
//                StringBuilder hugeText = new StringBuilder();
               scanner.nextLine();
                String line = scanner.nextLine();

                // Close the scanner
                scanner.close();

                // Print the entered line
                System.out.println("You entered: " + line);
                System.out.println("String: " + line);
                System.out.println("Double: " + aDouble);
                System.out.println("Int: " + i);

                int n =2;
                int p =1;
                int pageTurn=0;
                if(n-p==1 || n-p==0){
                        if(n%2==0 && n-p!=0 && n-p!=1){
                                pageTurn = 1;
                        }else if(n%2!=0 && n-p==1){
                                if(p%2==0){
                                        pageTurn = 0;
                                }else{
                                        pageTurn = 1;
                                }

                        } else if (n%2==0 && n-p==1) {
                                if(p%2==0){
                                        pageTurn = 0;
                                } else if (n==2) {
                                        pageTurn=0;
                                } else{
                                        pageTurn = 1;
                                }
                        } else {
                                pageTurn=0;
                        }
                }else if(n-p==2 || n-p==3 || n-p==1){
                        pageTurn = 1;
                }else if(n/2< p){
                        pageTurn =(n- p)/2;
                }else {
                        pageTurn = p/2;
                }
                System.out.println(pageTurn);
        }
}
