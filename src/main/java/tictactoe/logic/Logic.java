package tictactoe.logic;

public class Logic {

    /*
        0 - ` ` clear field
        1 - `x` on the field
        2 - `o` on the field
    */

    private int[][] game = new int[3][3];
    private int moveCount = 9;
    private static char currentPlayer = 'x';

    public Logic() {
        clearBoard();
    }

    private void clearBoard() {

        // Initialize board with `0`
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                game[i][j] = 0;
            }
        }
    }

    public int checkForWin() {

        // Winning codes:

        //    0 - No winner
        //    1 - `x` is the winner
        //    2 - `o` is the winner
        //    3 - draw

        // Check diagonals
        if(game[0][0] == game[1][1] && game[1][1] == game[2][2])
            if(game[0][0] != 0)
                return game[0][0];
        if(game[2][0] == game[1][1] && game[1][1] == game[0][2])
            if(game[1][1] != 0)
                return game[1][1];

        for(int i = 0; i < 3; i++) {

            // Check rows
            if(game[i][0] == game[i][1] && game[i][1] == game[i][2])
                if(game[i][0] != 0)
                    return game[i][0];

            // Check columns
            if(game[0][i] == game[1][i] && game[1][i] == game[2][i])
                if(game[0][i] != 0)
                    return game[0][i];
        }

        if(moveCount == 0)
            return 3;

        return 0;
    }

    public int update(int x, int y, char c) {
        // Error codes:
        // 1 - incorrect argument
        // 2 - there is already `x` or `o` on the field
        if(moveCount == 0)
            return 2;

        if(x < 0|| x > 2 || y < 0 || y > 2)
            return 1;
        if(game[x][y] != 0)
            return 2;

        if(c == 'o' || c == 'O') {
            game[x][y] = 2;
            moveCount--;
            return 0;
        }
        if(c == 'x' || c == 'X') {
            game[x][y] = 1;
            moveCount--;
            return 0;
        }

        return 1;
    }

    public void setNextPlayer(){
        if(currentPlayer == 'x') currentPlayer = 'o';
        else currentPlayer = 'x';
    }

    public char getMark(){
        return currentPlayer;
    }
}
