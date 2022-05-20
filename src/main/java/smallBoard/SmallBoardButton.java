package smallBoard;

import javafx.scene.control.Button;

public class SmallBoardButton extends Button {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    // private final int x;
    // private final int y;
    // private static int i = 0;

    private SmallBoard gameBoard;

    public SmallBoardButton(int x, int y, SmallBoard board) {
        this.gameBoard = board;
        // this.x = x;
        // this.y = y;
        setPrefSize(WIDTH, HEIGHT);
        setFocused(false);

        // CO SIE DZIEJE PO KLIKNIECIU
        setOnAction(e -> {
            if (gameBoard.checkBoardWin() != 0)
                return;

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
