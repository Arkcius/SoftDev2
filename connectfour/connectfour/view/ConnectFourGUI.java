package unit04.connectfour.view;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import unit04.connectfour.model.Checker;
import unit04.connectfour.model.ConnectFour;
import unit04.connectfour.model.ConnectFourException;
import unit04.connectfour.model.ConnectFourObserver;

public class ConnectFourGUI extends Application {
    private ConnectFour connectFour;
    public static final Image EMPTY_IMG = new Image("file:media/images/connect_four/connect-four-empty.png");
    public static final Image RED_IMG = new Image("file:media/images/connect_four/connect-four-red.png");
    public static final Image YELLOW_IMG = new Image("file:media/images/connect_four/connect-four-yellow.png");
    public static final Image BLANK_IMG = new Image("file:media/images/connect_four/connect-four-blank.png");

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.connectFour = new ConnectFour();

        GridPane board = new GridPane();
        ImageView[][] boardImg = new ImageView[7][7];
        board.setPadding(new Insets(10));

        Label status = new Label("Player Yellow will start the game.");
        status.setFont(new Font("Helvetica", 15));
        status.setTextFill(Color.BLACK);
        status.setPrefHeight(80);
        status.setPrefWidth(500);
        status.setAlignment(Pos.CENTER);
        status.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(10))));

        Button reset = new Button("RESET");
        reset.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        reset.setOnAction(new ResetChecker(connectFour, status));
        reset.setPrefSize(80, 80);
        reset.setFont(new Font("Impact", 20));
        reset.setBackground(new Background(new BackgroundFill(Color.FIREBRICK, null, new Insets(10))));
        reset.setTextFill(Color.WHITE);

        HBox box = new HBox();
        box.getChildren().addAll(reset, status);
        
        BorderPane thisIsPane = new BorderPane();
        thisIsPane.setCenter(board);
        thisIsPane.setBottom(box);
        thisIsPane.setPadding(new Insets(10));

        
        for(int col=0; col<7; col++) {
            for(int row=0; row<7; row++) {
                boardImg[row][col] = new ImageView(EMPTY_IMG);
                if(row == 0){
                    board.add( makeDropButton(col, status), col, row);
                }else{
                    board.add(makeConnectPane(boardImg, col, row), col, row);
                }
            }
        }

        Scene scene = new Scene(thisIsPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Button makeDropButton(int column, Label status) {
        Button button = new Button("DROP");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(new DropChecker(column, connectFour, status));
        button.setPrefHeight(80);
        button.setFont(new Font("Impact", 20));
        return button;
    }
    

    private StackPane makeConnectPane(ImageView[][] board, int col, int row){

        ConnectFour connectFour = this.connectFour;

        ImageView imageView = new ImageView(EMPTY_IMG);
        imageView.setFitHeight(80);
        imageView.setPreserveRatio(true);

        ImageView imagePod = board[row][col];
        imagePod.setFitHeight(80);
        imagePod.setPreserveRatio(true);
        
        connectFour.register(new GUIupdater(connectFour, board));
        
        StackPane pane = new StackPane(imageView, imagePod);
        pane.setPrefSize(80, 80);

        return pane;
    }
    
}

class DropChecker implements EventHandler<ActionEvent>{

    private int column;
    private ConnectFour connectFour;
    private Label status;

    public DropChecker(int column, ConnectFour connectFour, Label status) {
        this.column = column;
        this.connectFour = connectFour;
        this.status = status;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            connectFour.move(column);
            status.setText("Player " + connectFour.getCurrentPlayer().toString() + "'s turn");

        } catch(ConnectFourException cfe) {
            status.setText("Invalid move. Please try again. Player " + connectFour.getCurrentPlayer().toString() + "'s turn");
        }
    }

}

class ResetChecker implements EventHandler<ActionEvent>{

    private ConnectFour connectFour;
    private Label status;

    public ResetChecker(ConnectFour connectFour, Label status) {
        this.connectFour = connectFour;
        this.status = status;
    }

    @Override
    public void handle(ActionEvent event) {
        connectFour.reset();
        status.setText("New Game Started. Player Yellow will start the game.");
    }

}

class GUIupdater implements ConnectFourObserver{

    private ConnectFour connectFour;
    private ImageView[][] board;

    public GUIupdater(ConnectFour connectFour, ImageView[][] board) {
        this.connectFour = connectFour;
        this.board = board;
        

    }

    @Override
    public void checkerPlayed(Checker checker, int col, int row) {

        if(connectFour.getChecker(col, row) == Checker.BLACK){
            board[row+1][col].setImage(ConnectFourGUI.YELLOW_IMG);
        } else if(connectFour.getChecker(col, row) == Checker.RED){
            board[row+1][col].setImage(ConnectFourGUI.RED_IMG);
        }else{
            board[row+1][col].setImage(ConnectFourGUI.BLANK_IMG);
        }
        
    }

}
