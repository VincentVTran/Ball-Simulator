package Maze;

import Maze.Algorithm.Subject_Object;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.ArrayList;

public class Physics {
    //Basic four direction movement
    public void moveleft(Subject_Object object, double distance, int speed) {
        double desired_stance = object.getCenterX() - distance;
        Timeline moving_action = new Timeline(new KeyFrame(Duration.millis(speed), new KeyValue(object.centerXProperty(), desired_stance)));
        moving_action.setCycleCount(1);
        moving_action.play();
    }

    public void moveright(Subject_Object  object, double distance, int speed) {
        double desired_stance = object.getCenterX() + distance;
        Timeline moving_action = new Timeline(new KeyFrame(Duration.millis(speed), new KeyValue(object.centerXProperty(), desired_stance)));
        moving_action.setCycleCount(1);
        moving_action.play();
    }

    public void moveup(Subject_Object  object, double distance, int speed) {
        double desired_stance = object.getCenterY() - distance;
        Timeline moving_action = new Timeline(new KeyFrame(Duration.millis(speed), new KeyValue(object.centerYProperty(), desired_stance)));
        moving_action.setCycleCount(1);
        moving_action.play();
    }

    public void movedown(Subject_Object  object, double distance, int speed) {
        double desired_stance = object.getCenterY() + distance;
        Timeline moving_action = new Timeline(new KeyFrame(Duration.millis(speed), new KeyValue(object.centerYProperty(), desired_stance)));
        moving_action.setCycleCount(1);
        moving_action.play();
    }


    //Collision
    public boolean checkcollision(Subject_Object  object, ArrayList<Rectangle> barriers_list) {
        boolean moveable = true;
        for (int x = 0; x < barriers_list.size(); x++)
            if (object.getBoundsInParent().intersects(barriers_list.get(x).getBoundsInParent())) {
                object.setFill(Color.RED);
                moveable = false;
            }
            else{
                object.setFill(Color.DODGERBLUE);
            }
        return moveable;
    }

}
