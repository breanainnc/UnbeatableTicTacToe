package tictactoe;

/**
 *
 * @author brean
 */
public class AIPlayer {
    int[][] gameState;
    Updater updater;
    int moveR = 0, moveC = 0;
    
    public AIPlayer(Updater updater){
        this.updater = updater;
    }
    
    public void AIMove(int[][] gameState){
        this.gameState = gameState;
        playSides();
        playCorner();
        playOppCorner();
        playCenter();
        playFork('x');
        playFork('o');
        playWinOrBlock('x');
        playWinOrBlock('o');
        
      
        updater.playerMove(moveR, moveC, false);
        
    }
    //PLAYS THE SIDES IF THEY ARE FREE
    private void playSides() {
        if(gameState[0][1] == 0){
            moveR = 0;
            moveC = 1;
        }
        if(gameState[1][0] == 0){
            moveR = 1;
            moveC = 0;
        }
        if(gameState[1][2] == 0){
            moveR = 1;
            moveC = 2;
        }
        if(gameState[2][1] == 0){
            moveR = 2;
            moveC = 1;
        }
    }
    //PLAYS THE CORNERS IF THEY ARE FREE
    private void playCorner() {
        if(gameState[0][0] == 0){
            moveR = 0;
            moveC = 0;
        }
        if(gameState[2][2] == 0){
            moveR = 2;
            moveC = 2;
        }
        if(gameState[0][2] == 0){
            moveR = 0;
            moveC = 2;
        }
        if(gameState[2][0] == 0){
            moveR = 2;
            moveC = 0;
        }
    }
    //play Opposite side to opponent 
    private void playOppCorner() {
        int opp = (int)'x';
        if(gameState[0][0] == opp && gameState[2][2] == 0){
            moveR = 2;
            moveC = 2;
        }
        if(gameState[2][2] == opp && gameState[0][0] == 0){
            moveR = 0;
            moveC = 0;
        }
        if(gameState[0][2] == opp && gameState[2][0] == 0){
            moveR = 2;
            moveC = 0;
        }
        if(gameState[2][0] == opp && gameState[0][2] == 0){
            moveR = 0;
            moveC = 2;
        }
    }
    //PLAY THE CENTER IF FREE
    private void playCenter() {
        if(gameState[1][1] == 0){
            moveR = 1;
            moveC = 1;
        }
    }
    //BLOCK A PLAYER FROM WINNING/MAKE A WINNING MOVE
    private void playWinOrBlock(char letter) {
        int opp = (int)letter;
        int r = 0, c = 0;
        int count = 0;
        boolean emptySquare = false;
        
        //CHECKS EACH ROW FOR A WIN/BLOCK MOVE
        for(int row = 0; row < 3; row++){
            count = 0;
            emptySquare = false;
            for(int i = 0; i < 3; i++){
                if(gameState[row][i] == opp){
                    count++;
                }
                if(gameState[row][i] == 0){
                    r = row;
                    c = i;
                    emptySquare = true;
                }
            }
            if(count == 2 && emptySquare == true){
                moveR = r;
                moveC = c;
            }
        }
        //CHECKS EACH COLUMN FOR A WIN/BLOCK MOVE
        for(int col = 0; col < 3; col++){
            count = 0;
            emptySquare = false;
            for(int i = 0; i < 3; i++){
                if(gameState[i][col] == opp){
                    count++;
                }
                if(gameState[i][col] == 0){
                    r = i;
                    c = col;
                    emptySquare = true;
                }
            }
            if(count == 2 && emptySquare == true){
                moveR = r;
                moveC = c;
            }
        }
        //CHECKS ACCROSS FOR A WIN/BLOCK MOVE
        count = 0;
        emptySquare = false;
        for(int cross = 0; cross < 3; cross++){
            if(gameState[cross][cross] == opp){
                    count++;
                }
                if(gameState[cross][cross] == 0){
                    r = cross;
                    c = cross;
                    emptySquare = true;
                }
            }
        if(count == 2 && emptySquare == true){
                moveR = r;
                moveC = c;
            }
        
        //CHECKS ACCROSS FOR A WIN/BLOCK MOVE
        int bcross = 2;
        count = 0;
        emptySquare = false;
        for(int cross = 0; cross < 3; cross++){
            if(gameState[cross][bcross] == opp){
                    count++;
                }
            if(gameState[cross][bcross] == 0){
                    r = cross;
                    c = cross;
                    emptySquare = true;
                }
            bcross--;
            }
        if(count == 2 && emptySquare == true){
                moveR = r;
                moveC = c;
            }
    }
    //BLOCK A FORK FROM FORMING OR CREATE FORK
    private void playFork(char l) {
        int letter = (int)l;
        //CHECK TOP LEFT CORNER FOR FORK MOVE
        int r = 0, c = 0;
        if(gameState[r][c] == 0){
            int Rcount = 0;
            int Ccount = 0;
            int emptySquares = 0;
            for(int i = 1; i < 3; i++){
                if(gameState[r][i] == letter){
                    Ccount++;
                }
                else if(gameState[r][i] == 0){
                    emptySquares++;
                }
                if(gameState[i][c] == letter){
                    Rcount++;
                }
                else if(gameState[i][c] == 0){
                    emptySquares++;
                }                
            }
            if(Rcount == 1 && Ccount == 1 && emptySquares == 2){
                moveR = r; moveC = c;
            }
        }
        //CHECK TOP RIGHT CORNER FOR FORK MOVE
        r = 0; c = 2;
        if(gameState[r][c] == 0){
            int Rcount = 0;
            int Ccount = 0;
            int colCount = 0;
            int emptySquares = 0;
            for(int i = 1; i < 3; i++){
                if(gameState[r][colCount] == letter){
                    Ccount++;
                }
                else if(gameState[r][colCount] == 0){
                    emptySquares++;
                }
                if(gameState[i][c] == letter){
                    Rcount++;
                }
                else if(gameState[i][c] == 0){
                    emptySquares++;
                }
                colCount++;
            }
            if(Rcount == 1 && Ccount == 1 && emptySquares == 2){
                moveR = r; moveC = c;

            }
        }
        //CHECK BOTTOM LEFT CORNER FOR FORK MOVE
        r = 2; c = 0;
        if(gameState[r][c] == 0){
            int Rcount = 0;
            int Ccount = 0;
            int rowCount = 0;
            int emptySquares = 0;
            for(int i = 1; i < 3; i++){
                if(gameState[r][i] == letter){
                    Ccount++;
                }
                else if(gameState[r][i] == 0){
                    emptySquares++;
                }
                if(gameState[rowCount][c] == letter){
                    Rcount++;
                }
                else if(gameState[rowCount][c] == 0){
                    emptySquares++;
                }
                rowCount++;
            }
            if(Rcount == 1 && Ccount == 1 && emptySquares == 2){
                moveR = r; moveC = c;
            }
        }
        //CHECK BOTTOM RIGHT CORNER FOR FORK MOVE
        r = 2; c = 2;
        if(gameState[r][c] == 0){
            int Rcount = 0;
            int Ccount = 0;
            int emptySquares = 0;
            for(int i = 0; i < 2; i++){
                if(gameState[r][i] == letter){
                    Ccount++;
                }
                else if(gameState[r][i] == 0){
                    emptySquares++;
                }
                if(gameState[i][c] == letter){
                    Rcount++;
                }
                else if(gameState[i][c] == 0){
                    emptySquares++;
                }                
            }
            if(Rcount == 1 && Ccount == 1 && emptySquares == 2){
                moveR = r; moveC = c;
            }
        }
    }
}
