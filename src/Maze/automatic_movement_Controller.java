package Maze;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class automatic_movement_Controller {
    Physics mover = new Physics();
    ArrayList<Rectangle> boundaries = new ArrayList<>();
    @FXML
    Circle subject;
    @FXML
    Rectangle rectangle_1, rectangle_2, rectangle_3, rectangle_4;

    @FXML
    public void initialize() {
        load();

    }

    private void load() {
        boundaries.add(rectangle_1);
        boundaries.add(rectangle_2);
        boundaries.add(rectangle_3);
        boundaries.add(rectangle_4);
    }

    @FXML
    private void start_movement() {
        run();
    }

    //Moves the circle up and down
    private void run() {
        boolean runnable = true;


        KeyFrame move_downward = new KeyFrame(Duration.millis(100), event -> {
            mover.movedown(subject, 5, 100);
        });

        Timeline timeline = new Timeline();
        KeyFrame move_forward = new KeyFrame(Duration.millis(100), event -> {
            mover.moveup(subject, 5, 100);
            if (mover.checkcollision(subject, boundaries) == false) {
                mover.movedown(subject, 10, 10); //Moves the object out of collison zone before switching
            }
        });
        timeline.getKeyFrames().add(move_forward);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}

