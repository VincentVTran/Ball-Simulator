package Maze.Algorithm;
import Maze.Physics;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class NeuralNetwork {

    public NeuralNetwork(){
        main_network();
    }
    private void main_network(){
        for(Subject_Object runners: Algorithm_Screen_Controller.subjects_data){
            runners.start_moving();
        }
    }


    private void calculate_distance(ArrayList<Subject_Object> objects){ //y2-y1^2+x2-x1^2 = sqrt answer

    }


}
