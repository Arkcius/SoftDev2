package unit04.connectfour.view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import unit04.connectfour.model.ConnectFour;
import unit04.connectfour.model.ConnectFourException;

public class ButtonPress implements EventHandler<ActionEvent>{
        private int col;
        private ConnectFour connectFour;
        private int row;
        private GridPane pane;
        private Label label;
        private ImageView view;

        public ButtonPress(int col, ConnectFour connectFour,GridPane pane,int row){
            this.col=col;
            this.connectFour = connectFour;
            this.pane = pane;
            this.row =row;
        }
        @Override
        public void handle(ActionEvent event){
            try{
                connectFour.move(col);
                pane.add(new Label("",view), col, row);
                label.setText("Good Move "+connectFour.getCurrentPlayer());
            }
            catch(ConnectFourException cfe){
                label.setText(cfe.getMessage());
            }
        }
        
        }

