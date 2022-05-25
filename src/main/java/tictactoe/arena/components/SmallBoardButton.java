package tictactoe.arena.components;

import javafx.scene.control.Button;

public class SmallBoardButton extends Button {


    private SmallBoard gameBoard;

    public SmallBoardButton(int x, int y, SmallBoard board) {
        this.gameBoard = board;
        setFocused(false);

        // CO SIE DZIEJE PO KLIKNIECIU
        setOnAction(e -> {

            // Check for bitBoard win
            if (BigBoard.checkForWin() != 0) {
                return;
            }

            // Check for smallBoard win
            if (gameBoard.checkBoardWin() != 0) {
                return;
            }
            if (!this.getText().isEmpty())
                return;
            setText(String.valueOf(gameBoard.getGameLogic().getMark()));

            // Update game logic board
            gameBoard.updateLogic(x, y);

            int won = gameBoard.checkBoardWin();
            if (won != 0) {
                // Set board to complete state
                gameBoard.setPlayerWon(won);
            }
        });
    }

}
