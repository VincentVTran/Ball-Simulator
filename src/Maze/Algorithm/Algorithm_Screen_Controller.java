package Maze.Algorithm;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Algorithm_Screen_Controller {
    static ArrayList<Subject_Object> subjects_data;
    static ArrayList<Rectangle> boundary;
    @FXML
    AnchorPane pane1;

    @FXML
    public void initialize() {
        subjects_data = create_subject(4);
        boundary = load_environment();
        NeuralNetwork network = new NeuralNetwork();
    }

    private ArrayList<Rectangle> load_environment() {
        ArrayList<Rectangle> walls = new ArrayList<>();
        for( Node node: pane1.getChildren()) {
            if (node instanceof Rectangle) {
                walls.add((Rectangle) node);
            }
        }
        return walls;
    }

    private ArrayList<Subject_Object> create_subject(int amount_subjects) {
        ArrayList<Subject_Object> subjects = new ArrayList<>();
        for (int i = 0; i < amount_subjects; i++) {
            Subject_Object object = new Subject_Object(3);
            subjects.add(object);
            pane1.getChildren().add(object);
        }
        return subjects;
    }
}
