package gamePLay;

import customException.TokensNotCreatedException;
import gameComponents.Board;

/**
 * Game class
 * @author avram
 */

public class Game {
    private Board boardGame = new Board(20, 55);
    private Runnable playerOne = new Player("Andrei", boardGame);
    private Runnable playerTwo = new Player("George", boardGame);

    public void initGame(){
        boardGame.createTokens();
    }

    public void playGame() throws TokensNotCreatedException {
        Thread t1 = new Thread(playerOne);
        Thread t2 = new Thread(playerTwo);

        t1.start();
        t2.start();

    }

}
