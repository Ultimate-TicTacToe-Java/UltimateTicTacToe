package gameInfo;

import gameLogic.Logic;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;

public class GameInfo extends GridPane {
    public static final int HEIGHT = 900;
    public static final int WIDTH = 500;
    private static final Text text = new Text();

    public GameInfo() {
        setPrefSize(WIDTH,HEIGHT);

        // Add game info
        text.setFont(new Font(40));
        text.setText(String.format("Now moves: X"));
        boolean add = getChildren().add(text);
    }

    public static void changeTurnInfo(char mark){
        text.setText(String.format("Now moves: %c", mark));
    }

    public void setInfo(String info) {
        text.setText(info);
    }
}

