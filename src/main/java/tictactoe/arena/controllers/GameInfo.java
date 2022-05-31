package tictactoe.arena.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe.Main;
import tictactoe.arena.components.BigBoard;

import java.io.IOException;

public class GameInfo extends GridPane {

    private static Timeline timeline;
    private int timeInSeconds = 0;

    private char STARTING_PLAYER = 'x';

    private static Label labelGameTime;
    private static Label labelWhoseTurn;
    private static ImageView oSymbol;
    private static ImageView xSymbol;

    private Button exitButton;
    private Button resetButton;

    public GameInfo(Scene scene) {
        labelGameTime = (Label) scene.lookup("#labelGameTime");
        oSymbol = (ImageView) scene.lookup("#oSymbol");
        xSymbol = (ImageView) scene.lookup("#xSymbol");
        labelWhoseTurn = (Label)scene.lookup("#moveLabel");
        //TIMELINE
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1), e -> {
                    labelGameTime.setText(secondsToString(timeInSeconds));
                    timeInSeconds++;
                }));
        //EXIT
        exitButton = (Button)scene.lookup("#exitButton");
        exitButton.setOnAction(e -> {
            Platform.exit();
        });
        //RESTART
        resetButton = (Button)scene.lookup("#resetButton");
        resetButton.setOnAction( e -> {
            timeline.stop();

            Parent mainScene = scene.getRoot();
            Pane boardsContainer = (Pane) mainScene.lookup("#GameArenaContainer");
            boardsContainer.getChildren().clear();

            BigBoard bigBoard = new BigBoard();
            BigBoard.bigLogic.clearBoard();
            boardsContainer.getChildren().add(bigBoard);
            showFinal("Teraz rusza się:");
            labelGameTime.setText(secondsToString(0));
            timeInSeconds = 1;
            timeline.play();
            disableXO();
            setX();
        });
        reset();
        timeline.play();
    }

    private void reset() {
        timeInSeconds = 0;
        update(STARTING_PLAYER);
    }

    public static void update(char player) {
        // Update labels
        disableXO();

        if (player == 'x' || player == 'X') {
            setX();
        } else {
            setO();
        }
    }

    public static void disableXO() {
        oSymbol.setVisible(false);
        xSymbol.setVisible(false);
    }

    private static void setX() {
        xSymbol.setVisible(true);
    }

    private static void setO() {
        oSymbol.setVisible(true);
    }

    public static void stopTimer() {
        timeline.stop();
    }

    public static void showFinal(String text) {
        labelWhoseTurn.setText(text);
    }

    private String secondsToString(int pTime) {
        return String.format("%02d:%02d", pTime / 60, pTime % 60);
    }

}