package smallBoard;

import bigBoard.BigBoard;
import gameInfo.GameInfo;
import gameLogic.Logic;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class SmallBoard extends GridPane {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;
    public static int WON = 0;
    private int ID;

    public Logic getGameLogic() {
        return gameLogic;
    }

    private Logic gameLogic;
    private BigBoard bb;

    // Debug to check if player won
    public int boardWin = 0;

    public SmallBoard(int id, BigBoard bb) {
        this.ID = id;
        this.bb = bb;
        gameLogic = new Logic();

        setPrefSize(WIDTH, HEIGHT);
        getStyleClass().add("SmallBoard");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SmallBoardButton button = new SmallBoardButton(i, j, this);
                add(button, i, j);
            }
        }
    }

    public int checkBoardWin() {
        return gameLogic.checkForWin();
    }

    public void setPlayerWon(int won) {
        WON = won;
        System.out.printf("[ board %d ] -> ", ID);

        switch (WON) {
            case 1 -> {
                System.out.println("X WON");
                getStyleClass().add("WonX");
                setBoardFull("X");
            }
            case 2 -> {
                System.out.println("O WON");
                getStyleClass().add("WonO");
                setBoardFull("O");
            }

            case 3 -> {
                System.out.println("DRAW");
                getStyleClass().add("Draw");
                setBoardFull("X/O");
            }
        }

        // Update BigBoard logic
        bb.updateLogic(ID, won);
    }

    public void updateLogic(int x, int y) {
        gameLogic.update(x, y, gameLogic.getMark());
        gameLogic.setNextPlayer();
        GameInfo.update(gameLogic.getMark());
    }

    public void setBoardFull(String text) {
        getChildren().removeIf(node -> node instanceof SmallBoardButton);
        Label label = new Label(text);
        label.setPrefHeight(HEIGHT);
        label.setPrefWidth(WIDTH);
        label.setAlignment(Pos.CENTER);
        setValignment(label, VPos.CENTER);
        setHalignment(label, HPos.CENTER);
        getChildren().add(label);
    }
}
