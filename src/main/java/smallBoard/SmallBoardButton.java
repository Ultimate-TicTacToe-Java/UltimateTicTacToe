package smallBoard;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class SmallBoardButton extends Button {

    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;

    public SmallBoardButton(){
        setPrefSize(WIDTH,HEIGHT);
        setFocused(false);

        //CO SIE DZIEJE PO KLIKNIECIU
        setOnAction(e ->{
            setText((int)(Math.random() * 10) % 2 == 1 ? "X" : "O");
        });
    }



}
