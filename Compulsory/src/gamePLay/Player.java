package gamePLay;

import customException.TokensNotCreatedException;
import gameComponents.Board;
import gameComponents.Token;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Player class
 * @author avram
 */

public class Player implements Runnable{
    private String name;
    private Board boardGame;
    private List<Token> choseTokens = new ArrayList<>();

    Player(String name, Board boardGame){
        this.name = name;
        this.boardGame = boardGame;
    }

    @Override
    public synchronized void run() {

        List<Token> gameTokens = new ArrayList<>();
        Token choseToken = new Token();
        int listSize;
        int randomTokenIndex;

        boolean available = false;

        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int step = 0;

        while (step != 3) {
            try {
                gameTokens = boardGame.getTokenList();
            } catch (TokensNotCreatedException e) {
                e.printStackTrace();
            }

            listSize = gameTokens.size();
            randomTokenIndex = (int) (Math.random() * listSize);
            choseToken = gameTokens.get(randomTokenIndex);

            this.boardGame.removeToken(choseToken);
            this.choseTokens.add(choseToken);
            this.displayChoseToken(choseToken);

            step++;
        }

        available = true;
        notifyAll();
    }

    public void displayChoseToken(Token token){
        if(token.getValue() != 0)
            System.out.println("Player " + name + ": " + token.getValue());
        else System.out.println("Player " + name + ": " + "Joker");
    }
}
