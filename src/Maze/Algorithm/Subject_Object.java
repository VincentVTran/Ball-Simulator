package Maze.Algorithm;

import Maze.Physics;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;

public class Subject_Object extends Circle {
    private int distance = 0;
    private Timeline movement = new Timeline();
    public Subject_Object(int size){
        setRadius(size);
        int random_placement = (int)(Math.random()*15);
        setLayoutX(216+random_placement);
        setLayoutY(325+random_placement);
        setStroke(Color.BLACK);
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.AQUA,Color.RED,Color.BLUEVIOLET,Color.CYAN,Color.GREEN));
        setFill(colors.get((int)(Math.random()*5)));
    }

    public void start_moving() {
        Physics mover = new Physics();
        Timeline timeline = new Timeline();

        KeyFrame move_forward = new KeyFrame(Duration.millis(100), event -> {
            mover.moveup(this, 5, 50);
            if (mover.checkcollision(this, Algorithm_Screen_Controller.boundary) == false) {
                timeline.stop(); //Moves the object out of collison zone before switching
                this.setFill(Color.TRANSPARENT);

            }
        });

        KeyFrame move_backward = new KeyFrame(Duration.millis(100), event -> {
            mover.movedown(this, 2, 50);
            if (mover.checkcollision(this, Algorithm_Screen_Controller.boundary) == false) {
                timeline.stop(); //Moves the object out of collison zone before switching
                this.setFill(Color.TRANSPARENT);

            }
        });
        timeline.getKeyFrames().add(move_forward);
        timeline.setCycleCount(1);
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeline.getKeyFrames().removeAll();
                timeline.getKeyFrames().add(move_backward);
                timeline.playFromStart();
            }
        });
    }
}

