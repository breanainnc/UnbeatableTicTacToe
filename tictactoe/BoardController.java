package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author brean
 */
public class BoardController extends GridPane{
    BoardTile[][] btns = new BoardTile[3][3];
    Updater updater;
    
    public BoardController(Updater updater){
        this.updater = updater;
        
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){                                  
                btns[row][col] = new BoardTile(row,col,updater);                
                this.add(btns[row][col], row, col);
            }
        }   
    }

    public void setImage(char letter, int row, int col){
        
        if(letter == 'x'){
            Image image = new Image("Images/X.png");
            btns[row][col].setGraphic(new ImageView(image));            
        }
        else{
            Image image = new Image("Images/O.png");
            btns[row][col].setGraphic(new ImageView(image));            
        }
        btns[row][col].setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("ButtonUsed");                        
            }}); 
    }
}
