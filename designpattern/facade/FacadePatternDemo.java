package designpattern.facade;

import java.util.Scanner;

public class FacadePatternDemo {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter the shape you want to draw: ");
                String shape = scanner.nextLine();

                // Create a facade object
                ShapeFacade facade = new ShapeFacade();

                // Call the appropriate method on the facade object
                switch (shape) {
                        case "Circle":
                                facade.drawCircle();
                                break;
                        case "Rectangle":
                                facade.drawRectangle();
                                break;
                        case "Square":
                                facade.drawSquare();
                                break;
                        default:
                                System.out.println("Invalid shape");
                }
        }
}
