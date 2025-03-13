import java.util.ArrayList;
import java.util.List;

public abstract class CompositeComponent extends GardenComponent {
    protected List<GardenComponent> children = new ArrayList<>();

    public void add(GardenComponent component) {
        if (!children.contains(component)) {
            children.add(component);
        }
    }

    public void moveChildren(double deltaX, double deltaY) {
        children.forEach(child -> child.move(deltaX, deltaY));
    }
}
