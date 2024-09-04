package designpattern.facade;

public class ShapeFacade {
        private Square square;
        private Rectangle rectangle;
        private  Circle circle;

        public ShapeFacade() {
                circle = new Circle();
                rectangle = new Rectangle();
                square = new Square();
        }

        public void drawCircle() {
                circle.draw();
        }

        public void drawRectangle() {
                rectangle.draw();
        }

        public void drawSquare() {
                square.draw();
        }
}
