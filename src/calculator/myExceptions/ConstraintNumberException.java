package calculator.myExceptions;

public class ConstraintNumberException extends RuntimeException{
    public ConstraintNumberException() {
        super("� �������� ��������� ������������ �����(�) ������ 1 ��� ������ 10");
    }
}
