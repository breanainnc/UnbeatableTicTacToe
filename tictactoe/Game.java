package tictactoe;

/**
 *
 * @author brean
 */
public class Game {
    private int[][] gameState = new int[3][3];
    
    
    public Game(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                gameState[row][col] = 0;
            }
        }
    }
    public void setState(int row, int col, char letter){
        gameState[row][col] = (int)letter;
        
    }
    public int[][] getState(){
        return gameState;
        
    }
    public int getStatePos(int row, int col){
        return gameState[row][col];
    }
    public boolean checkWin(){
        boolean win = false;
        
            for(int i = 0; i < 3; i++){
                if(gameState[i][0] != 0 && gameState[i][0] == gameState[i][1]
                        && gameState[i][1] == gameState[i][2]){
                    win = true;
                }
                if(gameState[0][i] != 0 && gameState[0][i] == gameState[1][i]
                        && gameState[1][i] == gameState[2][i]){
                    win = true;
                }
            }
            if(gameState[0][0] != 0 && gameState[0][0] == gameState[1][1]
                    && gameState[1][1] == gameState[2][2] ){
                win = true;
            }
            if(gameState[0][2] != 0 && gameState[0][2] == gameState[1][1] 
                    && gameState[1][1] == gameState[2][0] ){
                win = true;
            }
            return win;
    }
    
}
