package unit04.connectfour.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import unit04.connectfour.model.ConnectFour;
import unit04.connectfour.view.ButtonPress;

public class ConnectFourGUI extends Application {
    static final Image blank = new Image("file:media/images/reversi/square.png");
    static final Image blackpiece = new Image("file:media/images/reversi/blackpiece.png");
    static final Image whitepiece = new Image("file:media/images/reversi/whitepiece.png");
    public ConnectFour game;
    public GridPane pane;


    @Override
    public void start(Stage stage) throws Exception{
        pane = new GridPane();
        game = new ConnectFour();
        for(int i=0;i<ConnectFour.COLS;i++){
            int j;
            for(j=0;j<ConnectFour.ROWS;j++){
                pane.add(makeLabel(i,j),i,j);
            }
            pane.add(makeButton(i),i,(j+1));
        }
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("connect four");
        stage.show();
    }

    public Label makeLabel(int col, int row){
        ImageView view = new ImageView(blank);
        game.setOnChange(new dropChanger(view,col,row));
        Label label = new Label("",view);

        return label;
    }

    public Button makeButton(int col){
        Button but = new Button("Col "+col);
        int row =0;
        but.setOnAction(new ButtonPress(col, game,pane,row));


        return but;
    }
}
