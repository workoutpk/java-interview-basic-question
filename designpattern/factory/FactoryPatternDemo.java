package designpattern.factory;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape rectangle = factory.createShape("rectangle");
        rectangle.draw();

        Shape circle = factory.createShape("circle");
        circle.draw();
    }
}
