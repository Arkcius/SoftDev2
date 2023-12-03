package unit04.reversi.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import unit04.reversi.model.Reversi;
import unit04.reversi.model.ReversiException;
import unit04.reversi.model.Square;

public class ReversiGUI extends Application{
        private static final Image square = new Image("file:media/images/reversi/square.png");
        static final Image blank = new Image("file:media/images/reversi/blank.png");
        static final Image blackpiece = new Image("file:media/images/reversi/blackpiece.png");
        static final Image whitepiece = new Image("file:media/images/reversi/whitepiece.png");
        private Reversi board;
        private Label status;
        private Label player1score;
        private Label player2score; 
    @Override
    public void start(Stage stage) throws Exception{
        GridPane pane = new GridPane();
        board = new Reversi();
        for(int i=0;i<Reversi.COLS;i++){
            for(int j=0;j<Reversi.ROWS;j++){
                pane.add(makeReversiButton(i,j),i,j);
            }
        }
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Reversi");
        stage.show();
        //makeMove(2, 4);


    }

    public void makeMove(int row, int col){
        try{
        board.move(row, col);
        System.err.println("Good Move");
        }
        catch (ReversiException e){
            System.err.println("Bad Move");
        }
    }

    public Button makeReversiButton(int col, int row){
        ImageView view = new ImageView(blank);
        Button but = new Button("",view);
        but.setBackground(new Background(new BackgroundImage(square, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        but.setPadding(new Insets(0));
        Square square = board.getSquare(row, col);
        MoveMaker move = new MoveMaker(row,col,this);

    
        switch(square.getOccupyingColor()){
            case BLACK:
                view.setImage(blackpiece);
                break;
            case WHITE:
                view.setImage(whitepiece);
                break;
            default:
                view.setImage(blank);
                break;
        }
        
        but.setOnAction(move);
        square.setOnChange(new SquareChanger(view));    
        return but;
    }
}