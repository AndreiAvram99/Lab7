package gameComponents;

import customException.TokensNotCreatedException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Board class
 * @author avram
 */

public class Board {
    private int dimension = 0;
    private int tokenMaxDimension = 0;
    private final List<Token> tokenList = new ArrayList<>();

    public Board(int dimension, int tokenMaxDimension){
        this.dimension = dimension;
        this.tokenMaxDimension = tokenMaxDimension;
    }

    public void createTokens(){
        int dimensionCopy = dimension;
        int currentValue = 1;

        for (int index = 0; index < dimension; index++) {
                Token token = new Token(currentValue);
                tokenList.add(token);
                dimensionCopy--;
                if(currentValue + 3 <= tokenMaxDimension)
                    currentValue += 3;
                else break;
        }

        for (int index = 0; index < dimensionCopy; index++){
            Token token = new Token(true);
            tokenList.add(token);
        }

    }

    public List<Token> getTokenList() throws TokensNotCreatedException {
        if(tokenList.size() != 0)
            return tokenList;
        else throw new TokensNotCreatedException("You should create tokens first");
    }

    public void removeToken(Token token){
        tokenList.remove(token);
    }
}
