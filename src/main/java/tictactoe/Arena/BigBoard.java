package tictactoe.Arena;

import tictactoe.gameLogic.Logic;
import javafx.scene.layout.GridPane;

public class BigBoard extends GridPane {

    public static final int HEIGHT = 900;
    public static final int WIDTH = 900;
    private static final int[][] COORDS = new int[9][2];
    private final Logic bigLogic;

    public BigBoard() {
        bigLogic = new Logic();
        getStyleClass().add("BigBoard");
        setPrefSize(WIDTH, HEIGHT);

        generateSmallBoards();
    }

    private void generateSmallBoards() {
        int ids = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SmallBoard smallBoard = new SmallBoard(ids, this);
                COORDS[ids - 1][0] = i;
                COORDS[ids - 1][1] = j;
                ids++;
                add(smallBoard, i, j);
            }
        }
    }

    public void updateLogic(int boardID, int won) {
        char c = won == 1 ? 'x' : 'o';

        bigLogic.update(COORDS[boardID - 1][0], COORDS[boardID - 1][1], c);
        int w = bigLogic.checkForWin();
        if (w != 0)
            setPlayerWon(w);
    }

    public void setPlayerWon(int won) {
        if (won == 1)
            System.out.println(
                    "-------- X WON WHOLE GAME --------");
        else if (won == 2)
            System.out.println(
                    "-------- O WON WHOLE GAME --------");
        else if (won == 3)
            System.out.println(
                    "-------- DRAW OMG WHAT A MATCH --------");
    }
}
