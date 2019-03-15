module Maze.Neural.Network {
    requires javafx.controls;
    requires javafx.fxml;
    exports Maze;
    opens Maze to javafx.graphics,javafx.fxml;
}