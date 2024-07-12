package calculator.myExceptions;

public class InvalidInputDataException extends RuntimeException{
    public InvalidInputDataException() {
        super("Введённое выражение НЕ соответствуют требованиям или некорректно");
    }
}