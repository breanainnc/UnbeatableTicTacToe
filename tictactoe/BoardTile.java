package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
/**
 *
 * @author brean
 */
public class BoardTile extends Button{
    final private int row, col;
    Updater updater;
    
    public BoardTile(int row, int col,Updater updater){
        this.updater = updater;
        this.row = row;
        this.col = col;
        this.setMinSize(100, 100);
        this.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                updater.playerMove(row, col, true);
            }}); 
    }    
}