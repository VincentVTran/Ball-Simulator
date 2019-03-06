package Maze;

import Maze.Algorithm.Subject_Object;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class development_gui_Controller {
    Physics mover = new Physics();
    ArrayList<Rectangle> barrier_list = new ArrayList<>();

    Subject_Object subject;
    @FXML
    Button left_button,right_button,up_button,down_button;
    @FXML
    Text velocity_display;
    @FXML
    Rectangle rectangle_1;
    @FXML
    Slider velocity_slider;
    @FXML
    Pane MainPane;

    double distance = 5;
    DecimalFormat decimal = new DecimalFormat("#.##");
    double velocity = Double.valueOf(decimal.format(distance/.1));

    @FXML
    public void initialize(){
        load();
    }
    private void load(){
        barrier_list.add(rectangle_1);
        velocity_display.setText(Double.toString(velocity)+" pixel/sec");
        slider_setup();
        subject = new Subject_Object(12);
        subject.setFill(Color.DODGERBLUE);
        subject.setLayoutX(300);
        subject.setLayoutY(244);
        MainPane.getChildren().add(subject);
    }

    @FXML
    private void move_left() {
       // mover.moveleft(subject,distance,100);
        mover.checkcollision(subject,barrier_list);
    }
    @FXML
    private void backselected() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main_Screen.fxml"));
        Main.primary.setScene(new Scene(root,600,400));
    }
    private void slider_setup(){
        velocity_slider.setMax(50);
        velocity_slider.setMin(0);
        velocity_slider.setValue(5);
        velocity_slider.setBlockIncrement(10);
        velocity_slider.showTickMarksProperty();
        velocity_slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                distance = velocity_slider.getValue();
                velocity = distance/.1;
                velocity_display.setText(Double.toString(Double.valueOf(decimal.format(distance/.1))) + " pixel/sec");
            }
        });
        velocity_slider.showTickLabelsProperty();
    }

    @FXML
    private void move_right() {
        mover.moveright(subject,distance,100);
        mover.checkcollision(subject,barrier_list);
    }

    @FXML
    private void move_up() {
        mover.moveup(subject,distance,100);
        mover.checkcollision(subject,barrier_list);
    }

    @FXML
    private void move_down() {
        mover.movedown(subject,distance,100);
        mover.checkcollision(subject,barrier_list);
    }
}
