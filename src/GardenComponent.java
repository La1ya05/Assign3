import javafx.scene.Node;

public abstract class GardenComponent {
    private int zIndex = 0; 

    public abstract boolean contains(double x, double y);
    public abstract void move(double deltaX, double deltaY);
    public abstract Node getNode();

    public int getZIndex() {
        return zIndex;
    }

    public void setZIndex(int zIndex) {
        this.zIndex = zIndex;
        getNode().toFront(); 
    }
}