import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower extends GardenComponent {
    private Circle shape;

    public Flower(double x, double y, Color color) {
        shape = new Circle(x, y, 10, color);
    }

    @Override
    public boolean contains(double x, double y) {
        return shape.contains(x, y);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        shape.setCenterX(shape.getCenterX() + deltaX);
        shape.setCenterY(shape.getCenterY() + deltaY);
    }

    @Override
    public Circle getNode() {
        return shape;
    }
}
