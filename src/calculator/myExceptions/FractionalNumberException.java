package calculator.myExceptions;

public class FractionalNumberException extends RuntimeException{
    public FractionalNumberException() {
        super("В введённом выражение присутствует дробное число" );
    }
}