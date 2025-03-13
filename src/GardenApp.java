import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Random;

public class GardenApp extends Application {
    private GardenCanvas gardenCanvas; 
    private static final int SIDEBAR_WIDTH = 200; 

    @Override
    public void start(Stage primaryStage) {
        
        VBox sidebar = new VBox();
        sidebar.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #4CAF50, #81C784);" + 
            "-fx-padding: 20px;" + 
            "-fx-spacing: 15px;" +
            "-fx-border-color: #2E7D32;" + 
            "-fx-border-width: 2px;" + 
            "-fx-border-radius: 10px;" + 
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);"
        );
        sidebar.setPrefWidth(SIDEBAR_WIDTH);

        
        Label flowersLabel = createStyledLabel("Flowers");
        Label vegetablesLabel = createStyledLabel("Vegetables");
        Label flowerBedLabel = createStyledLabel("Flower Bed");
        Label treeLabel = createStyledLabel("Tree");
        Label birdLabel = createStyledLabel("Bird");

        
        HBox flowerIcons = new HBox(
            createClickableCircle(Color.YELLOW),
            createClickableCircle(Color.ORANGE),
            createClickableCircle(Color.RED),
            createClickableCircle(Color.GRAY),
            createClickableCircle(Color.BROWN)
        );
        flowerIcons.setSpacing(10);

        
        HBox vegetableIcons = new HBox(
            createClickableCircle(Color.GREEN),
            createClickableCircle(Color.LIGHTGREEN),
            createClickableCircle(Color.PURPLE)
        );
        vegetableIcons.setSpacing(10);

        
        Rectangle flowerBedIcon = new Rectangle(40, 40, Color.PINK);
        flowerBedIcon.setStyle("-fx-stroke: #C2185B; -fx-stroke-width: 2px;");
        flowerBedIcon.setOnMouseClicked(event -> addFlowerBed());

        
        Circle treeIcon = new Circle(20, Color.DARKGREEN);
        treeIcon.setStyle("-fx-stroke: #1B5E20; -fx-stroke-width: 2px;");
        treeIcon.setOnMouseClicked(event -> addTree());

      
        ImageView birdIcon = new ImageView(new Image(getClass().getResource("/bird.png").toExternalForm()));
        birdIcon.setFitWidth(30);
        birdIcon.setFitHeight(30);
        birdIcon.setOnMouseClicked(event -> addBird());

        
        sidebar.getChildren().addAll(flowersLabel, flowerIcons, vegetablesLabel, vegetableIcons,
                                     flowerBedLabel, flowerBedIcon, treeLabel, treeIcon, birdLabel, birdIcon);

        
        gardenCanvas = new GardenCanvas();
        gardenCanvas.setStyle("-fx-background-color: #87CEEB;"); 
        gardenCanvas.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);

        
        HBox rootLayout = new HBox(sidebar, gardenCanvas);
        HBox.setHgrow(gardenCanvas, javafx.scene.layout.Priority.ALWAYS);

        
        Scene scene = new Scene(rootLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Garden Layout");
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }

    
    private Label createStyledLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
        return label;
    }

   
    private Circle createClickableCircle(Color color) {
        Circle circle = new Circle(10, color);
        circle.setStyle("-fx-stroke: black; -fx-stroke-width: 1px;");
        circle.setOnMouseClicked(event -> addFlowerOrVegetable(color));
        return circle;
    }

    
    private void addFlowerOrVegetable(Color color) {
        Random random = new Random();
        double x = SIDEBAR_WIDTH + 10 + random.nextDouble() * (gardenCanvas.getWidth() - 40);
        double y = 10 + random.nextDouble() * (gardenCanvas.getHeight() - 40);
        Flower flower = new Flower(x, y, color);
        gardenCanvas.addComponent(flower);
    }

   
    private void addFlowerBed() {
        Random random = new Random();
        double x = SIDEBAR_WIDTH + 10 + random.nextDouble() * (gardenCanvas.getWidth() - 120);
        double y = 10 + random.nextDouble() * (gardenCanvas.getHeight() - 100);
        FlowerBed flowerBed = new FlowerBed(x, y, 100, 80);
        gardenCanvas.addComponent(flowerBed);
    }

   
    private void addTree() {
        Random random = new Random();
        double x = SIDEBAR_WIDTH + 10 + random.nextDouble() * (gardenCanvas.getWidth() - 60);
        double y = 10 + random.nextDouble() * (gardenCanvas.getHeight() - 60);
        Tree tree = new Tree(x, y);
        gardenCanvas.addComponent(tree);
    }

    
    private void addBird() {
        Random random = new Random();
        double x = SIDEBAR_WIDTH + 10 + random.nextDouble() * (gardenCanvas.getWidth() - 40);
        double y = 10 + random.nextDouble() * (gardenCanvas.getHeight() - 40);
        Bird bird = new Bird(x, y);
        gardenCanvas.addComponent(bird);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
