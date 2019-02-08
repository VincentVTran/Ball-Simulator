package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Physics {
    public void moveleft(Circle object,int distance, int speed) {
        double desired_stance = object.getCenterX() - distance - object.getRadius();
        Timeline moving_action = new Timeline(new KeyFrame(Duration.seconds(speed), new KeyValue(object.centerXProperty(),desired_stance)));
        moving_action.setCycleCount(1);
        moving_action.play();
    }

    public void moveright(Circle object,int distance, int speed) {
        double desired_stance = object.getCenterX() + distance - object.getRadius();
        Timeline moving_action = new Timeline(new KeyFrame(Duration.seconds(speed), new KeyValue(object.centerXProperty(),desired_stance)));
        moving_action.setCycleCount(1);
        moving_action.play();
    }

    public void moveup(Circle object,int distance, int speed) {
        double desired_stance = object.getCenterY() - distance - object.getRadius();
        Timeline moving_action = new Timeline(new KeyFrame(Duration.seconds(speed), new KeyValue(object.centerYProperty(),desired_stance)));
        moving_action.setCycleCount(1);
        moving_action.play();
    }

    public void movedown(Circle object,int distance, int speed) {
        double desired_stance = object.getCenterY() + distance - object.getRadius();
        Timeline moving_action = new Timeline(new KeyFrame(Duration.seconds(speed), new KeyValue(object.centerYProperty(),desired_stance)));
        moving_action.setCycleCount(1);
        moving_action.play();
    }

}
