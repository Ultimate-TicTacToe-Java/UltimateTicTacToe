package main;

import bigBoard.BigBoard;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {

    //TU DAJEMY WSZYSTKIE KOMPONENTY
    public Parent createContent(){

        BigBoard bigBoard = new BigBoard();

        return bigBoard;
    }

    @Override
    public void start(Stage stage) {
        Parent root = createContent();
        Scene scene = new Scene(root);
        stage.setTitle("Ultimate Tic Tac Toe!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}