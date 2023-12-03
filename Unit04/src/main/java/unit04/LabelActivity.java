package unit04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        Label label = makeLabel("Top", Color.RED, Color.BLUE);
        Label label1 = makeLabel("Middle", Color.PINK, Color.GREEN);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(label,label1);
        Scene scene = new Scene(hbox);
        stage.setTitle("First");
        stage.setScene(scene);
        stage.show();
    }

private static Label makeLabel(String text,Color foreground,Color background){
    Label label = new Label(text);
    label.setFont(new Font("Arial", 24));
    label.setMaxWidth(150.0);
    label.setPadding(new Insets(10));
    label.setTextFill(foreground);
    label.setBackground(new Background(new BackgroundFill(background, new CornerRadii(5),new Insets(1, 1, 1, 1))));
    label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2, 2, 2, 2))));
    return label;
}
    public static void main(String[] args){
        launch(args);
    }
}