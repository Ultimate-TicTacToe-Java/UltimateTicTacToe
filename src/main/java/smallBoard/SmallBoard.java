package smallBoard;

import bigBoard.BigBoard;
import gameInfo.gameInfo;
import gameLogic.logic;
import javafx.scene.layout.*;


public class SmallBoard extends GridPane {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;
    public static int WON = 0;
    private int ID;
    private logic gameLogic;
    private BigBoard bb;

    // Debug to check if player won
    public int boardWin = 0;

    public SmallBoard(gameInfo info, int id, BigBoard bb){
        this.ID = id;
        this.bb = bb;
        gameLogic = new logic(id);

        setPrefSize(WIDTH,HEIGHT);
        getStyleClass().add("smallBoard");

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                SmallBoardButton button = new SmallBoardButton(i, j, info, this);
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

        if(won == 1)
            System.out.println("X WON");
        else if(won == 2)
            System.out.println("O WON");
        else if(won == 3)
            System.out.println("DRAW");

        // Update BigBoard logic
        bb.updateLogic(ID, won);
    }

    public void updateLogic(int x, int y, char choice) {
        gameLogic.update(x, y, choice);
    }
}
