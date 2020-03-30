package customException;

public class TokensNotCreatedException extends Exception{
    public TokensNotCreatedException(String errorMessage){
        super(errorMessage);
    }
}
