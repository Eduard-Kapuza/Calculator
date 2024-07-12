package calculator.myExceptions;

public class ConstraintNumberRuntimeException extends RuntimeException{
    public ConstraintNumberRuntimeException() {
        super("В введённом выражение присутствует число(а) меньше 1 или больше 10");
    }
}