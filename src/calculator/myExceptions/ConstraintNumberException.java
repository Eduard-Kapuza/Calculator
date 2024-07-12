package calculator.myExceptions;

public class ConstraintNumberException extends RuntimeException{
    public ConstraintNumberException() {
        super("В введённом выражение присутствует число(а) меньше 1 или больше 10");
    }
}