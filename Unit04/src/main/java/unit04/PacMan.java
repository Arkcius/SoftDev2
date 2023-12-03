package unit04;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PacMan extends Application{
    @Override
    public void start(Stage stage)throws Exception{
        HBox hbox = new HBox();
        Button start = makeButton("Start", "media/sounds/start.wav");
        Button chomp = makeButton("Chomp", "media/sounds/chomp.wav");
        hbox.getChildren().addAll(start,chomp);
        Scene scene = new Scene(hbox);
        stage.setTitle("PacMan");
        stage.setScene(scene);
        stage.show();
    }


    private static Button makeButton(String name, String path){
        Button but = new Button(name);
        String uri = new File(path).toURI().toString();
        Media media = new Media(uri);
        MediaPlayer player = new MediaPlayer(media);
        but.setOnAction(new SoundPlayer(player));
        return but;
    }
}