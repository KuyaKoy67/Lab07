package carl.lab07_carl;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        Duration segmentDuration = Duration.millis(1250);

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
        
        Circle shapeA = new Circle(15, Color.BLUE);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(segmentDuration);
        pathTransition.setPath(pathMNPQ);
        pathTransition.setNode(shapeA);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);

        topPane.getChildren().add(shapeA);
        
        // Part 2
        Ellipse shapeB = new Ellipse(300, 175, 40, 20);
        shapeB.setFill(Color.CORAL);
        shapeB.setStroke(Color.BLACK);

        FadeTransition fadeB = new FadeTransition(segmentDuration, shapeB);
        fadeB.setFromValue(1.0);
        fadeB.setToValue(0.2);

        ScaleTransition scaleB = new ScaleTransition(segmentDuration, shapeB);
        scaleB.setFromX(1.0);
        scaleB.setFromY(1.0);
        scaleB.setToX(2.0);
        scaleB.setToY(2.0);

        RotateTransition rotateB = new RotateTransition(segmentDuration, shapeB);
        rotateB.setByAngle(360.0);

        TranslateTransition translateB = new TranslateTransition(segmentDuration, shapeB);
        translateB.setByY(-60.0);

        SequentialTransition seqTransitionB = new SequentialTransition(fadeB, scaleB, rotateB, translateB);

        topPane.getChildren().addAll(shapeA, shapeB);
        
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("JavaFX Animations A and B");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}