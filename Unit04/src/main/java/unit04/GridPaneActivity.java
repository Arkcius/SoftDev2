package unit04;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneActivity extends Application{
    public void start(Stage primary) throws Exception{
    GridPane gridPane = new GridPane();
    //Label results = new Label("123.456");
    gridPane.add(new Label("1"),0,4);
    gridPane.add(new Label("1"),1,4);
    gridPane.add(new Label("1"),2,4);
    gridPane.add(new Label("1"),3,4);
    }
}
