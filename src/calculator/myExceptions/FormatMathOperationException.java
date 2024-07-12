package calculator.myExceptions;

public class FormatMathOperationException extends RuntimeException{
    public FormatMathOperationException() {
        super("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
    }
}