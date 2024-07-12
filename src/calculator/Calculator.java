package calculator;

import calculator.myExceptions.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    static String regex;
    static String signOperation;
    static String[] massString;
    static int[] massInt;
    static Matcher matcher;
    static Pattern pattern;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Калькулятор умеет выполнять операции:
                        сложения, вычитания, умножения и деления
                        с двумя целыми числами: a + b, a - b, a * b, a / b.
                Введите выражение
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

        String result = "пустая строка :)";
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

        if (inputData.contains(".") || inputData.contains(",")) {
            throw new FractionalNumberException();
        }

        regex = "^\\d{1,2} ?[+-/*] ?\\d{1,2}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(inputData);

        if (matcher.matches()) {
            findSignOperation(inputData);
        } else {
            throw new FormatMathOperationException();
        }

    }

    private static void findSignOperation(String inputData) {

        regex = "[+-/*]";
        pattern=Pattern.compile(regex);
        matcher = pattern.matcher(inputData);

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