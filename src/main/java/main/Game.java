package main;

import bigBoard.BigBoard;
import gameInfo.gameInfo;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.util.Objects;

public class Game extends Application {

    //TU DAJEMY WSZYSTKIE KOMPONENTY
    public Parent createContent(){
        FlowPane root = new FlowPane();

        root.setPrefSize(1400, 900);

        gameInfo info = new gameInfo();
        BigBoard bigBoard = new BigBoard(info);

        // DODAJ BIG BOARD I GAME INFO DO FLOWPANE
        root.getChildren().add(bigBoard);
        root.getChildren().add(info);
        return root;
    }

    @Override
    public void start(Stage stage) {
        Parent root = createContent();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("/main/style.css")).toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("Ultimate Tic Tac Toe!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}