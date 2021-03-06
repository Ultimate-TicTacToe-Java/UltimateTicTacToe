package tictactoe.arena.components;

import tictactoe.arena.controllers.GameInfo;
import tictactoe.logic.Logic;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class SmallBoard extends GridPane {
    public static int boardState = 0;
    private final int ID;

    public Logic getGameLogic() {
        return gameLogic;
    }

    private Logic gameLogic;
    private BigBoard bb;

    // Debug to check if player whoWon
    public int boardWin = 0;

    public SmallBoard(int id, BigBoard bb) {
        this.ID = id;
        this.bb = bb;
        gameLogic = new Logic();
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

    public void setPlayerWon(int whoWon) {
        boardState = whoWon;
        System.out.printf("[ board %d ] -> ", ID);

        switch (boardState) {
            case 1 -> {
                getStyleClass().add("WonX");
                setBoardFull("X");
            }
            case 2 -> {
                getStyleClass().add("WonO");
                setBoardFull("O");
            }

            case 3 -> {
                getStyleClass().add("Draw");
                setBoardFull("X/O");
            }
        }

        // Update BigBoard logic
        bb.updateLogic(ID, whoWon);
    }

    public void updateLogic(int x, int y) {
        gameLogic.update(x, y, gameLogic.getMark());
        gameLogic.setNextPlayer();
        GameInfo.update(gameLogic.getMark());
    }

    public void setBoardFull(String text) {
        getChildren().removeIf(node -> node instanceof SmallBoardButton);
        Label label = new Label(text);
        label.setAlignment(Pos.CENTER);
        setValignment(label, VPos.CENTER);
        setHalignment(label, HPos.CENTER);
        getChildren().add(label);
    }
}
