package gameInfo;

import javafx.scene.layout.GridPane;
import javafx.scene.text.*;

public class gameInfo extends GridPane {
    public static final int HEIGHT = 900;
    public static final int WIDTH = 500;
    private final Text text = new Text();

    public gameInfo() {
        setPrefSize(WIDTH,HEIGHT);

        // Add game info
        text.setFont(new Font(40));
        text.setText("\n\n\n\n\n\n\n   Now moves: [ X / O ]");
        boolean add = getChildren().add(text);
    }

    public void setInfo(String info) {
        text.setText(info);
    }
}

