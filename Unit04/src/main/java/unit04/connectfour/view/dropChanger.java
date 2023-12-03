package unit04.connectfour.view;

import javafx.scene.image.ImageView;
import unit04.connectfour.model.ConnectFour;
import unit04.connectfour.model.ConnectObserver;

public class dropChanger implements ConnectObserver{
    private ImageView view;
    private int col;
    private int row;
    public dropChanger(ImageView view,int col,int row){
        this.view=view;
        this.row=row;
        this.col=col;

    }
    @Override
    public void dropChange(ConnectFour connectFour){
        switch(connectFour.getChecker(col,row)){
            case RED:
                view.setImage(ConnectFourGUI.whitepiece);
                break;
            case BLACK:
                view.setImage(ConnectFourGUI.blackpiece);
                break;
            default:
                view.setImage(ConnectFourGUI.blank);
                break;
            
        }
    }
}
