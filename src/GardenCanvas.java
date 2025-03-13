import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GardenCanvas extends Pane {
    private final List<GardenComponent> components = new ArrayList<>();
    private GardenComponent selectedComponent;
    private double lastX, lastY;

    public GardenCanvas() {
        setOnMousePressed(this::handleMousePressed);
        setOnMouseDragged(this::handleMouseDragged);
    }

    public void addComponent(GardenComponent component) {
        components.add(component);
        getChildren().add(component.getNode());
    }

    private void handleMousePressed(MouseEvent event) {
        for (GardenComponent component : components) {
            if (component.contains(event.getX(), event.getY())) {
                selectedComponent = component;
                lastX = event.getX();
                lastY = event.getY();
                component.getNode().toFront();
                break;
            }
        }
    }

    private void handleMouseDragged(MouseEvent event) {
        if (selectedComponent == null) return;

        double deltaX = event.getX() - lastX;
        double deltaY = event.getY() - lastY;
        selectedComponent.move(deltaX, deltaY);
        lastX = event.getX();
        lastY = event.getY();

        for (GardenComponent component : components) {
            if (component instanceof CompositeComponent && component != selectedComponent &&
                component.contains(event.getX(), event.getY())) {
                
                if ((component instanceof Tree && selectedComponent instanceof Bird) ||
                    (component instanceof FlowerBed && (selectedComponent instanceof Vegetable || selectedComponent instanceof Flower))) {
                    ((CompositeComponent) component).add(selectedComponent);
                }
                break;
            }
        }
    }
}
