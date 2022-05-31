package tictactoe.arena.components;

import tictactoe.arena.controllers.GameInfo;
import tictactoe.logic.Logic;
import javafx.scene.layout.GridPane;

public class BigBoard extends GridPane {

    private static final int[][] coords = new int[9][2];
    public static final Logic bigLogic = new Logic();

    public BigBoard() {
        getStyleClass().add("BigBoard");
        generateSmallBoards();
    }

    public static int checkForWin() {
        return bigLogic.checkForWin();
    }

    private void generateSmallBoards() {
        int ids = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SmallBoard smallBoard = new SmallBoard(ids, this);
                coords[ids - 1][0] = i;
                coords[ids - 1][1] = j;
                ids++;
                add(smallBoard, i, j);
            }
        }
    }

    public void updateLogic(int boardID, int won) {
        char c = won == 1 ? 'x' : 'o';

        bigLogic.update(coords[boardID - 1][0], coords[boardID - 1][1], c);
        int w = bigLogic.checkForWin();
        if (w != 0) {
            setPlayerWon(w);
        }
    }

    public void setPlayerWon(int won) {
        switch (won) {
            case 1 -> {
                System.out.println("-------- X WON WHOLE GAME --------");
                GameInfo.showFinal("X wygrywa");
                GameInfo.stopTimer();
                GameInfo.disableXO();
            }
            case 2 -> {
                System.out.println("-------- O WON WHOLE GAME --------");
                GameInfo.showFinal("O wygrywa");
                GameInfo.stopTimer();
                GameInfo.disableXO();
            }
            case 3 -> {
                System.out.println("-------- DRAW OMG WHAT A MATCH --------");
                GameInfo.showFinal("Remis");
                GameInfo.stopTimer();
                GameInfo.disableXO();
            }
        }
    }
}
