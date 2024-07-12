package calculator;

import calculator.myExceptions.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    static String signOperation;
    static String[] massString;
    static int[] massInt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                ����������� ����� ��������� ��������:
                        ��������, ���������, ��������� � �������
                        � ����� ������ �������: a + b, a - b, a * b, a / b.
                ������� ���������
                """);
        String inputData = scanner.nextLine();
        String result = calc(inputData);
        System.out.println(result);
    }

    public static String calc(String input) {
        return run(input);
    }

    private static String run(String inputData) {

        validateInputData(inputData);

        String result = "������ ������ :)";
        switch (signOperation) {
            case "+" -> {
                return String.valueOf(massInt[0] + massInt[1]);
            }
            case "-" -> {
                return String.valueOf(massInt[0] - massInt[1]);
            }
            case "/" -> {
                return String.valueOf(massInt[0] / massInt[1]);
            }
            case "*" -> {
                return String.valueOf(massInt[0] * massInt[1]);
            }
        }
        return result;
    }

    private static void validateInputData(String inputData) {

        if (inputData.length() < 3) {
            throw new NotMathOperationException();
        }

        String regex = "^\\d{1,2} ?[+-/*] ?\\d{1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputData);

        Matcher matcher1 = Pattern.compile("[+-/*]").matcher(inputData);
        int countOperator = 0;
        while (matcher1.find()) {
            countOperator++;
        }

        if (matcher.matches()) {
            findSignOperation(inputData);
        } else if (countOperator > 1) {
            throw new FormatMathOperationException();
        } else if (Pattern.compile("[.,]").matcher(inputData).find()) {
            throw new FractionalNumberException();
        } else {
            throw new InvalidInputDataException();
        }
    }

    private static void findSignOperation(String inputData) {

        String regex = "[+-/*]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputData);

        if (matcher.find()) {
            signOperation = matcher.group();
            findOperands(inputData, regex);
        }
    }

    private static void findOperands(String inputData, String regex) {
        massString = inputData.split(regex);
        validateOperands();
    }

    private static void validateOperands() {
        massInt = new int[massString.length];
        for (int i = 0; i < massString.length; i++) {
            massInt[i] = Integer.parseInt(massString[i].trim());
            if (massInt[i] < 1 || massInt[i] > 10) {
                throw new ConstraintNumberException();
            }
        }
    }
}


