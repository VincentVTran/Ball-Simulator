package Maze;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;

public class Main_Screen_Controller {

    @FXML
    ChoiceBox Menu_Option;

    @FXML
    Button confirm_button;

    @FXML
    private void OnClick() throws IOException {
       String selection = (String)Menu_Option.getValue();
        if(selection.toLowerCase().equals("controllable subject")) {
            Parent root = FXMLLoader.load(getClass().getResource("development_gui.fxml")); //Change scenes
            Main.primary.setScene(new Scene(root,600,400));
        }
        else if(selection.toLowerCase().equals("automatically moving subject")) {
            Parent root = FXMLLoader.load(getClass().getResource("automatic_movement.fxml")); //Change scenes
            Main.primary.setScene(new Scene(root, 600, 400));
        }
    }

    @FXML
    public void initialize(){
        Menu_Option.getItems().add("Controllable Subject");
        Menu_Option.getItems().add("Automatically Moving Subject");
    }

}
