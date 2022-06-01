package tictactoe;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
import tictactoe.logic.Logic;

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
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        GameInfo info = new GameInfo(scene);
    }

    public Parent sceneBuilder() throws IOException {
        Pane mainScene = laodFxmlScene();
        addBigBoardToScene(mainScene);
        addExitButton(mainScene);
        addResetButton(mainScene);
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



    private void addResetButton(Pane backgroundPane){
        GridPane timebox = (GridPane) backgroundPane.lookup("#buttonsContainer");
        Button resetButton = new Button("Reset");
        resetButton.getStyleClass().add("menuButton");
        timebox.add(resetButton, 1, 0);

        resetButton.setOnAction(event ->{
            System.out.println("Reset");

            Pane bg = (Pane)backgroundPane.lookup("#GameArenaContainer");
            bg.getChildren().removeIf(node -> node instanceof BigBoard);

            addBigBoardToScene(backgroundPane);

            GameInfo.reset();
        });


    }

    private void addExitButton(Pane backgroundPane){
        GridPane timebox = (GridPane) backgroundPane.lookup("#buttonsContainer");
        Button exitButton = new Button("Exit");
        exitButton.getStyleClass().add("menuButton");
        timebox.add(exitButton, 0, 0);

        exitButton.setOnAction(event ->{
            System.out.println("Exit");
            Platform.exit();
        });
    }
}