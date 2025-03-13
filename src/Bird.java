import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bird extends GardenComponent {
    private ImageView imageView;

    public Bird(double x, double y) {
        imageView = new ImageView(new Image(getClass().getResource("/bird.png").toExternalForm()));
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
    }

    @Override
    public boolean contains(double x, double y) {
        return imageView.contains(x, y);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        imageView.setX(imageView.getX() + deltaX);
        imageView.setY(imageView.getY() + deltaY);
    }

    @Override
    public ImageView getNode() {
        return imageView;
    }
}
