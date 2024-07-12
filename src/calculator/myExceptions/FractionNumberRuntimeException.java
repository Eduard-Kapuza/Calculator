package calculator.myExceptions;

public class FractionNumberRuntimeException extends RuntimeException{
    public FractionNumberRuntimeException() {
        super("В введённом выражение присутствует дробное число");
    }
}