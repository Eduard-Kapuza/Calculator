package calculator.myExceptions;

public class FormatMathOperationException extends RuntimeException{
    public FormatMathOperationException() {
        super("������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
    }
}