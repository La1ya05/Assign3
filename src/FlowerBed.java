import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;

public class FlowerBed extends CompositeComponent {
    private Rectangle shape;
    private double x, y, width, height;

    public FlowerBed(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        shape = new Rectangle(width, height, Color.rgb(255, 192, 203, 0.7));
        shape.setX(x);
        shape.setY(y);
    }

    @Override
    public boolean contains(double x, double y) {
        return shape.contains(x, y);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
        shape.setX(x);
        shape.setY(y);
        moveChildren(deltaX, deltaY);
    }

    @Override
    public Node getNode() {
        return shape;
    }
}
