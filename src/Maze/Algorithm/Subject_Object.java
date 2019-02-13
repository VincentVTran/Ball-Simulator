package Maze.Algorithm;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Arrays;

public class Subject_Object extends Circle {
    private int distance = 0;
    public Subject_Object(int size){
        setRadius(size);
        int random_placement = (int)(Math.random()*15);
        setLayoutX(216+random_placement);
        setLayoutY(325+random_placement);
        setStroke(Color.BLACK);
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.AQUA,Color.RED,Color.BLUEVIOLET,Color.CYAN,Color.GREEN));
        setFill(colors.get((int)(Math.random()*5)));
    }
}
