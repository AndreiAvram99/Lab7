package customException;

public class ValueIsSetException extends Exception{
    public ValueIsSetException(String errorMessage){
        super(errorMessage);
    }
}
