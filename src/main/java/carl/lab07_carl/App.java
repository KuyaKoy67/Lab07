package carl.lab07_carl;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
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

        Duration segmentDuration = Duration.millis(1250);
        Duration totalLoopDuration = Duration.millis(5000);

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

        PathTransition pathTransitionA = new PathTransition();
        pathTransitionA.setDuration(totalLoopDuration);
        pathTransitionA.setPath(pathMNPQ);
        pathTransitionA.setNode(shapeA);
        pathTransitionA.setOrientation(PathTransition.OrientationType.NONE);

        Ellipse shapeB = new Ellipse(300, 150, 40, 20);
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
        
        HBox controlBox = new HBox(20);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setPrefHeight(60);
        controlBox.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-padding: 10;");

        Button btnStart = new Button("Start");
        Button btnReset = new Button("Reset");
        Button btnExit = new Button("Exit");

        btnStart.setOnAction(e -> {
            pathTransitionA.playFromStart();
            seqTransitionB.playFromStart();
        });

        btnReset.setOnAction(e -> {
            pathTransitionA.stop();
            seqTransitionB.stop();
            
            pathTransitionA.jumpTo(Duration.ZERO);

            shapeB.setOpacity(1.0);
            shapeB.setScaleX(1.0);
            shapeB.setScaleY(1.0);
            shapeB.setRotate(0);
            shapeB.setTranslateY(0);
        });

        btnExit.setOnAction(e -> Platform.exit());

        controlBox.getChildren().addAll(btnStart, btnReset, btnExit);

        root.getChildren().addAll(topPane, controlBox);
        
        Scene scene = new Scene(root, 600, 380);
        stage.setTitle("JavaFX Animations A and B");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}