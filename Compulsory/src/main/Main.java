package main;

import customException.TokensNotCreatedException;
import gamePLay.Game;

/**
 * Main class
 * @author avram
 */

public class Main {

    public static void main(String[] args) throws TokensNotCreatedException {
        Game newGame = new Game();
        newGame.initGame();
        newGame.playGame();
    }
}
