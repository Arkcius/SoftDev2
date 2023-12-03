package unit04.mypod;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class Song {
    private String pathAud;
    private String description;
    private String pathImg;
    private MediaPlayer player;

    public Song(String pathAud, String description, String pathImg){
        this.description = description;
        this.pathImg = pathImg;
        this.pathAud = pathAud;
        String uri = new File(pathAud).toURI().toString();
        Media media = new Media(uri);
        this.player = new MediaPlayer(media);
}
    public String getPath(){return pathAud;}
    public Image getImage(){return new Image(pathImg);}
    public String getDesc(){return this.description;}

    public void play(){
        player.play();
    }
    public void stop(){
        player.stop();
    }
    public void pause(){
        if(player.getStatus()==Status.PAUSED){
            player.play();
        }
        else{
            player.pause();
        }
    }
    public void rewind(){
        player.seek(player.getCurrentTime().subtract(new Duration(10000)));
    }
    public void fastForward(){
        player.seek(player.getCurrentTime().add(new Duration(10000)));
    }
}
