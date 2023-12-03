package unit04;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Updater implements EventHandler<ActionEvent>{
    private TextField text;
    private Label label;

    public Updater(TextField text, Label label){
        this.text = text;
        this.label = label;
    }
    
    @Override
    public void handle(ActionEvent event){
        label.setText(text.getText());
    }
}