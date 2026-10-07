package carl.lab07_carl;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        Duration animDuration = Duration.millis(5000);

        // PART 1:
        Pane topPane = new Pane();
        topPane.setPrefSize(600, 300);
        topPane.setStyle("-fx-border-color: black; -fx-border-width: 1;");

        Polyline pathMNPQ = new Polyline(
            100.0, 50.0,   
            500.0, 50.0,   
            500.0, 250.0,  
            100.0, 250.0,  
            100.0, 50.0    
        );
        
        Circle circleA = new Circle(15, Color.BLUE);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(animDuration);
        pathTransition.setPath(pathMNPQ);
        pathTransition.setNode(circleA);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);

        topPane.getChildren().add(circleA);
        
        root.getChildren().add(topPane);
        
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("JavaFX Animations A and B");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}