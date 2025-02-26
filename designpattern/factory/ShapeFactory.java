package designpattern.factory;

public class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        return switch (shapeType.toLowerCase()) {
            case "rectangle" -> new Rectangle();
            case "circle" -> new Circle();
            case "triangle" -> new Triangle();
            default -> throw new IllegalArgumentException("Unknown shape type");
        };
    }
}
