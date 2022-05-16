package smallBoard;

import javafx.scene.layout.*;


public class SmallBoard extends GridPane {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;

    public SmallBoard(){
        setPrefSize(WIDTH,HEIGHT);
        getStyleClass().add("smallBoard");

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                SmallBoardButton button = new SmallBoardButton();
                add(button,i,j);
            }
        }
    }
}
