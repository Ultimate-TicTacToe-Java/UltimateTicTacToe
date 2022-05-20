package main;

import bigBoard.BigBoard;
import gameInfo.GameInfo;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;

public class Game extends Application {

    // TU DAJEMY WSZYSTKIE KOMPONENTY
    public Parent createContent() {
        FXMLLoader temp = new FXMLLoader(getClass().getResource("/GameWindow/main.fxml"));

        Pane root = new Pane();
        try {
            root.getChildren().add(temp.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = createContent();
        Scene scene = new Scene(root);
        Pane boardContainer = (Pane) scene.lookup("#BoardContainer");
        gameInfo info = new gameInfo();
        BigBoard bigBoard = new BigBoard(info);
        boardContainer.getChildren().add(bigBoard);
        boardContainer.getChildren().add(info);
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