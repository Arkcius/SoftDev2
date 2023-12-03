package unit04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneActivity extends Application{
    @Override
    public void start(Stage stage)throws Exception{
        StackPane pane = new StackPane();
        pane.getChildren().addAll(
        new ImageView("file:media/images/emojis/headred.png"),
        new ImageView("file:media/images/emojis/eyesblue.png"),
        new ImageView("file:media/images/emojis/browshuh.png"),
        new ImageView("file:media/images/emojis/mouthbasic.png"),
        new ImageView("file:media/images/emojis/noseblue.png"));
        Scene scene = new Scene(pane);
        stage.setTitle("IMAGE");
        stage.setScene(scene);
        stage.show();
    }
}