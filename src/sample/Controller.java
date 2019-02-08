package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;

import javafx.scene.control.Button;


public class Controller {
    Physics mover = new Physics();

    @FXML
    Button left_button,right_button,up_button,down_button;
    @FXML
    Circle subject;

    @FXML
    private void move_left() {
        mover.moveleft(subject,50,1);
    }

    @FXML
    private void move_right() {
        mover.moveright(subject,50,1);
    }

    @FXML
    private void move_up() {
        mover.moveup(subject,50,1);
    }

    @FXML
    private void move_down() {
        mover.movedown(subject,50,1);
    }
}
