package tictactoe;

import tictactoe.arena.BigBoard;
import tictactoe.gameLogic.GameInfo;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;

public class Main extends Application {

    // TU DAJEMY WSZYSTKIE KOMPONENTY
    public Parent createContent() {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/GameWindow/main.fxml"));
        StackPane root = new StackPane();
        try {
            Pane backgroundPane = fxml.load();
            BigBoard bigBoard = new BigBoard();
            root.getChildren().addAll(backgroundPane, bigBoard);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return root;
        }
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

        GameInfo info = new GameInfo(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}