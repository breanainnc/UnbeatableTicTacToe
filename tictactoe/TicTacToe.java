package tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
/**
 *
 * @author brean
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Text text = new Text();
        text.setFont(new Font(20));
        text.setWrappingWidth(300);
        text.setTextAlignment(TextAlignment.CENTER);

        Updater updater = new Updater(text);
        
        BoardController boardController = new BoardController(updater);
        updater.setController(boardController);

        
        
        VBox root = new VBox();
        root.getChildren().add(boardController);
        root.getChildren().add(text);
        
        Scene scene = new Scene(root, 290, 330);
        
        
        primaryStage.setTitle("X's and O's");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
