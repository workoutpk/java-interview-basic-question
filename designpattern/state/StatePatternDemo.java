package designpattern.state;

import java.util.Scanner;

public class StatePatternDemo {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Create a context object
                Context context = new Context();

                // Set the initial state
                context.setState(new OnState());

                System.out.println("Current state: " + context.getState().toString());

                System.out.println("Press 1 to turn off the light");
                System.out.println("Press 2 to turn on the light");

                int choice = scanner.nextInt();

                switch (choice) {
                        case 1:
                                context.setState(new OffState());
                                break;
                        case 2:
                                context.setState(new OnState());
                                break;
                        default:
                                System.out.println("Invalid choice");
                }

                System.out.println("Current state: " + context.getState().toString());
        }
}
