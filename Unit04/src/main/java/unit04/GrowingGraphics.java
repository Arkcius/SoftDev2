package unit04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GrowingGraphics extends Application{
    @Override
    public void start(Stage stage)throws Exception{
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        BorderPane main = new BorderPane();
        Label label = new Label("Idk",new ImageView("file:media/images/smb/mushroom.png"));
        Label label2 = new Label("Idk",new ImageView("file:media/images/smb/mushroom.png"));
        Button button = new Button("Idk",new ImageView("file:media/images/smb/bush_middle.png"));
        Button button2 = new Button("Idk2",new ImageView("file:media/images/smb/bush_middle.png"));

        vbox.getChildren().addAll(label,label2);
        hbox.getChildren().addAll(button,button2);
        main.setLeft(vbox);
        main.setRight(hbox);
        HBox.setHgrow(button, Priority.SOMETIMES);
        VBox.setVgrow(label, Priority.ALWAYS);
        Scene scene = new Scene(main);
        stage.setTitle("Stretch");
        stage.setScene(scene);
        stage.show();

    }
    }
