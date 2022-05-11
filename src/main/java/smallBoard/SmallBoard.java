package smallBoard;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SmallBoard extends GridPane {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;

    public SmallBoard(){
        setPrefSize(WIDTH,HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.color(Math.random(),Math.random(),Math.random()), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
