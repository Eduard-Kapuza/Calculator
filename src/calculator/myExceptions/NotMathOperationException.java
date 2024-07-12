package calculator.myExceptions;

public class NotMathOperationException extends RuntimeException {
    public NotMathOperationException() {
        super("Введённая строка не является математической операцией");
    }
}