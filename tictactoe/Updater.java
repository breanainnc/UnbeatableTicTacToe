
package tictactoe;

import javafx.scene.text.Text;


/**
 *
 * @author brean
 */
public class Updater {
    Text prompt;
    BoardController boardController;
    Game game;
    AIPlayer AI;
    boolean plyrX;
    
    public Updater(Text prompt){
        this.prompt = prompt;
        game = new Game();       
        boolean plyrX;
        setPrompt("Player 1");
        AI = new AIPlayer(this);
    }
    
    public void setController(BoardController boardController){
        this.boardController = boardController;
    }
    public void setPrompt(String text){
        prompt.setText(text);
    }
    public void playerMove(int row, int col, boolean player){        
        if(game.getStatePos(row, col) == 0 && player == true){
            game.setState(row, col, 'x');
            boardController.setImage('x', row, col);
        }
        if(game.getStatePos(row, col) == 0 && player == false){
            game.setState(row, col, 'o');
            boardController.setImage('o', row, col);
        }
        boolean win = game.checkWin();
        if(player == true && !win){
            AI.AIMove(game.getState());
        }
        if(win){
            if(player){
                prompt.setText("You WIN!");
            }
            else{
                prompt.setText("You LOSE!");
            }
        }
        
    }
}
