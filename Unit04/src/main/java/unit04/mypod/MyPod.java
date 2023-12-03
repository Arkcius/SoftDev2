
package unit04.mypod;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyPod extends Application{

    private Song curSong;
    public ImageView imageview;
    public Song getCurSong(){return curSong;}
    public void setCurSong(Song song){this.curSong = song;}
    public void setCurImage(Image image){this.imageview = new ImageView(image);}

    @Override
    public void start(Stage stage) throws Exception{

        HBox playmenu = new HBox();
        VBox songlist = new VBox();
        setCurImage(new Image("file:media/images/square.png"));
        imageview.setFitHeight(100);
        imageview.setFitWidth(100);
        setCurSong(null);
        BorderPane pane = new BorderPane();
        Button song1 = makeSongButton("media/sounds/start.wav", "PacMan Start", "file:media/images/smb.gif");
        Button song2 = makeSongButton("src/main/java/unit04/mypod/first.mp3", "a song i found online for FREE ", "file:media/images/sunflowers.jpg");
        Button song3 = makeSongButton("media/sounds/Chomp.wav", "PacMan Chomp", "file:media/images/smb/brick.png");
        songlist.getChildren().addAll(song1,song2,song3);
        Button play = makeActionButton("play");
        Button pause = makeActionButton("pause");
        Button rewind = makeActionButton("rewind");
        Button stop = makeActionButton("stop");
        Button ff = makeActionButton("fast forward");
        playmenu.getChildren().addAll(rewind,pause,play,stop,ff);
        pane.setLeft(imageview);
        pane.setRight(songlist);
        pane.setBottom(playmenu);
        Scene scene = new Scene(pane);
        stage.setTitle("Songs");
        stage.setScene(scene);
        stage.show();

        
    }

    public Button makeSongButton(String pathAud, String description, String pathImg){
        Song song = new Song(pathAud, description, pathImg);
        Button but = new Button(description);
        but.setMaxWidth(200);
        but.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                setCurSong(song);
                imageview.setImage(song.getImage());
            }
        });
        return but;
    }

    public Button makeActionButton(String name){
        Button but = new Button(name);
        if(name=="play"){
            ImageView playe = new ImageView(new Image("file:src/main/java/unit04/mypod/play.jpg"));
            playe.setFitHeight(20);
            playe.setFitWidth(20);
            but.setGraphic(playe);
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                getCurSong().play();}
            });
        }
        else if(name=="rewind"){
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                getCurSong().rewind();}
            });
        }
        else if(name=="stop"){
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                getCurSong().stop();}
            });
        }
        else if(name=="fast forward"){
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                getCurSong().fastForward();}
            });
        }
        else if(name=="pause"){
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                getCurSong().pause();}
            });
        }


        return but;


}

public static void main(String[] args){
    launch(args);
}

}
