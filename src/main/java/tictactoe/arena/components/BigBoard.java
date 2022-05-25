package tictactoe.arena.components;

import tictactoe.arena.controllers.GameInfo;
import tictactoe.logic.Logic;
import javafx.scene.layout.GridPane;

public class BigBoard extends GridPane {

    private static final int[][] coords = new int[9][2];
    private final Logic bigLogic;

    public BigBoard() {
        bigLogic = new Logic();
        getStyleClass().add("BigBoard");
        generateSmallBoards();
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
    //TODO: check if game is finished
    public void setPlayerWon(int won) {
        switch (won) {
            case 1 -> {
                System.out.println("-------- X WON WHOLE GAME --------");
                GameInfo.showFinal("X Won");
                GameInfo.stopTimer();
            }
            case 2 -> {
                System.out.println("-------- O WON WHOLE GAME --------");
                GameInfo.showFinal("O Won");
                GameInfo.stopTimer();
            }
            case 3 -> {
                System.out.println("-------- DRAW OMG WHAT A MATCH --------");
                GameInfo.showFinal("Draw");
                GameInfo.stopTimer();
            }
        }
    }
}
