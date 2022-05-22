package tictactoe;

import tictactoe.arena.components.BigBoard;
import tictactoe.arena.controllers.GameInfo;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = sceneBuilder();
        Scene scene = new Scene(root);

        String css = Objects.requireNonNull(this.getClass().getResource("/fxml/GameWindow/style.css")).toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Ultimate Tic Tac Toe!");
        primaryStage.setScene(scene);
        primaryStage.show();

        GameInfo info = new GameInfo(scene);
    }

    // TU DAJEMY WSZYSTKIE KOMPONENTY
    public Parent sceneBuilder() throws IOException {
        Pane mainScene = laodFxmlScene();
        addBigBoardToScene(mainScene);
        return mainScene;
    }

    private Pane laodFxmlScene() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/GameWindow/main.fxml"));
        Pane mainScene = fxml.load();
        return mainScene;
    }

    private void addBigBoardToScene(Pane backgroundPane) {
        Pane boardsContainer = (Pane) backgroundPane.lookup("#GameArenaContainer");
        BigBoard bigBoard = new BigBoard();
        boardsContainer.getChildren().add(bigBoard);
    }


}