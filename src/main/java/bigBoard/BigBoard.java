package bigBoard;

import javafx.scene.layout.GridPane;
import smallBoard.SmallBoard;

public class BigBoard extends GridPane{

    public static final int HEIGHT = 900;
    public static final int WIDTH = 900;

    public BigBoard(){
        setPrefSize(WIDTH,HEIGHT);

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                SmallBoard smallBoard =  new SmallBoard();
                add(smallBoard,i,j);
            }
        }
    }
}
