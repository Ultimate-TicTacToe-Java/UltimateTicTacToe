package tictactoe.arena.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class GameInfo extends GridPane {

    private static Timeline timeline;
    private static int timeInSeconds = 0;

    private static char STARTING_PLAYER = 'x';

    private static Label labelGameTime;
    private static Label labelWhoseTurn;
    private static ImageView oSymbol;
    private static ImageView xSymbol;

    public GameInfo(Scene scene) {
        labelGameTime = (Label) scene.lookup("#labelGameTime");
        oSymbol = (ImageView) scene.lookup("#oSymbol");
        xSymbol = (ImageView) scene.lookup("#xSymbol");
        labelWhoseTurn = (Label)scene.lookup("#moveLabel");
        startTimer();
        reset();
    }

    public static void reset() {
        timeInSeconds = 0;
        update(STARTING_PLAYER);
        timeline.play();
    }

    public static void update(char player) {
        // Update labels
        disableXO();

        if (player == 'x' || player == 'X') {
            setX();
        } else {
            setO();
        }

        showFinal("Teraz rusza się");
    }

    private static void disableXO() {
        oSymbol.setVisible(false);
        xSymbol.setVisible(false);
    }

    private static void setX() {
        xSymbol.setVisible(true);
    }

    private static void setO() {
        oSymbol.setVisible(true);
    }

    private void startTimer() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
            new KeyFrame(Duration.seconds(1), e -> {
            labelGameTime.setText(secondsToString(timeInSeconds));
            timeInSeconds++;
        }));
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