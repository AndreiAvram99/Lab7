package gameComponents;

import customException.JokerIsSetException;
import customException.ValueIsSetException;
import java.util.Objects;

/**
 * Token class
 * @author avram
 */

public class Token {

    private int value = 0;
    private boolean isJoker = false;

    public Token(){}

    Token(int value){
        this.value = value;
    }

    Token(boolean isJoker){
        this.isJoker = isJoker;
    }

    public void setValue(int value) throws JokerIsSetException {
        if (!isJoker) this.value = value;
        else throw new JokerIsSetException("This token is a joker already");
    }

    public int getValue(){
        if(!isJoker)
        return value;
        else return 0;
    }

    public boolean isJoker() {
        return isJoker;
    }

    public void setJoker(boolean joker) throws ValueIsSetException {
        if(value != 0) isJoker = joker;
        else throw new ValueIsSetException("This token have a value already");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return value == token.value &&
                isJoker == token.isJoker;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isJoker);
    }
}
