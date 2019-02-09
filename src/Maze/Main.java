package Maze;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage primary;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main_Screen.fxml")); //Change scenes
        primary = primaryStage;
        primary.setTitle("Maze");
        primary.setScene(new Scene(root, 600, 400));
        primary.show();
    }

    public void set_scene(Parent root){
        primary.setScene(new Scene(root,600,800));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
