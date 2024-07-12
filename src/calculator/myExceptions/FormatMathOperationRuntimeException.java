package calculator.myExceptions;

public class FormatMathOperationRuntimeException extends RuntimeException{
    public FormatMathOperationRuntimeException() {
        super("формат математической операции не удовлетворяет заданию - два операнда (целые числа) и один оператор (+, -, /, *)" );
    }
}