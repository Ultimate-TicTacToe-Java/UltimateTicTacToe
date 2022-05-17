package main;

import bigBoard.BigBoard;
import gameInfo.gameInfo;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.util.Objects;

public class Game extends Application {

    //TU DAJEMY WSZYSTKIE KOMPONENTY
    public Parent createContent(){
        FlowPane root = new FlowPane();

        root.setPrefSize(1400, 950);

        gameInfo info = new gameInfo();
        BigBoard bigBoard = new BigBoard(info);

        // DODAJ BIG BOARD I GAME INFO DO FLOWPANE
        root.getChildren().add(bigBoard);
        root.getChildren().add(info);


        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = createContent();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("/main/style.css")).toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Ultimate Tic Tac Toe!");
        primaryStage.setScene(scene);
        primaryStage.show();


        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void main(String[] args) {
        launch();
    }
}