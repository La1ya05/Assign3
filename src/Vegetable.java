import javafx.scene.paint.Color;

public class Vegetable extends GardenComponent {
    private Flower shape;

    public Vegetable(double x, double y, Color color) {
        shape = new Flower(x, y, color);
    }

    @Override
    public boolean contains(double x, double y) {
        return shape.contains(x, y);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        shape.move(deltaX, deltaY);
    }

    @Override
    public javafx.scene.Node getNode() {
        return shape.getNode();
    }
}
