package unit04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NameTag extends Application{
    private static double MAXHEIGHT = 100;
    private static double MAXWIDTH = 100;
    public void start(Stage stage) throws Exception{
    VBox vbox = new VBox();
    vbox.setAlignment(Pos.CENTER);
    Label name = new Label("Hello my Name is");
    name.setMaxWidth(100);
    name.setMaxHeight(50);

    Label name2 = new Label("Your Name");
    name2.setMaxWidth(100);
    name2.setMaxHeight(50);

    Button clear = new Button("Clear");
    clear.setMaxSize(MAXWIDTH, MAXHEIGHT);
    clear.setAlignment(Pos.CENTER);

    Button update = new Button("Update Name Tag");
    update.setMaxSize(MAXWIDTH, MAXHEIGHT);
    update.setAlignment(Pos.CENTER);   



    TextField text = new TextField();
    text.setPromptText("Enter Your Name");
    text.setMaxSize(MAXWIDTH, MAXHEIGHT);
    text.setAlignment(Pos.CENTER);
    
    Updater updater = new Updater(text, name2);
    update.setOnAction(updater);


    vbox.getChildren().addAll(name,name2,text,update,clear);
    Scene scene = new Scene(vbox);
    stage.setTitle("First");
    stage.setScene(scene);
    stage.show();
    }
}
