package unit05.hilo.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import unit05.hilo.model.HiLo;

public class HiLoUpdate implements EventHandler<ActionEvent>{
    private TextField text;
    private Label hint;
    private Label guess;
    private HiLo game;

    public HiLoUpdate(TextField text, Label hint, Label guess,HiLo game){
        this.text = text;
        this.hint = hint;
        this.guess = guess;
        this.game = game;
    }

    @Override
    public void handle(ActionEvent event){
        hint.setText(game.getHint());
        guess.setText(game.getAvailableGuesses());
        text.setText("");
    }
}
