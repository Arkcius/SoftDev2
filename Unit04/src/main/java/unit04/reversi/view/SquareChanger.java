package unit04.reversi.view;

import javafx.scene.image.ImageView;
import unit04.reversi.model.Square;
import unit04.reversi.model.SquareObserver;

public class SquareChanger implements SquareObserver{
    private ImageView view;
    public SquareChanger(ImageView view){
        this.view=view;
    }
    @Override
    public void squareChanged(Square s){
        switch(s.getOccupyingColor()){
            case WHITE:
                view.setImage(ReversiGUI.whitepiece);
                break;
            case BLACK:
                view.setImage(ReversiGUI.blackpiece);
                break;
            case EMPTY:
                view.setImage(ReversiGUI.blank);
                break;
            
        }
    }

    }

