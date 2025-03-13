import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Tree extends CompositeComponent {
    private Circle shape;

    public Tree(double x, double y) {
        shape = new Circle(x, y, 30, Color.rgb(0, 100, 0, 0.7));
    }

    @Override
    public boolean contains(double x, double y) {
        return shape.contains(x, y);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        shape.setCenterX(shape.getCenterX() + deltaX);
        shape.setCenterY(shape.getCenterY() + deltaY);
        moveChildren(deltaX, deltaY);
    }

    @Override
    public Circle getNode() {
        return shape;
    }
}
