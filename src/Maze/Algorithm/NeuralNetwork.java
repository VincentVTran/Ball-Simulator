package Maze.Algorithm;
import Maze.Physics;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class NeuralNetwork {

    public NeuralNetwork(){
        main_network();
    }
    private void main_network(){
        random_movement(Algorithm_Screen_Controller.subjects_data,Algorithm_Screen_Controller.boundary);
    }

    private void random_movement(ArrayList<Subject_Object> objects, ArrayList<Rectangle> walls) {
        Physics mover = new Physics();
        for (Subject_Object subject : objects) {
            Timeline timeline = new Timeline();
            KeyFrame move_forward = new KeyFrame(Duration.millis(100), event -> {
                mover.moveup(subject, 5, 100);
                if (mover.checkcollision(subject, walls) == false) {
                    timeline.stop(); //Moves the object out of collison zone before switching
                    subject.setFill(Color.TRANSPARENT);
                    calculate_distance(objects);
                }
            });
            timeline.getKeyFrames().add(move_forward);
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    private void calculate_distance(ArrayList<Subject_Object> objects){ //y2-y1^2+x2-x1^2 = sqrt answer

    }


}
