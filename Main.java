package com.company;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        String[] expressionArray = expression.split(" ");
        char symbol = expressionArray[1].charAt(0);
        int a = 1;
        int b = 1;
        int finalResult = 0;

        if (expressionArray.length != 3) {
            System.out.println("throws Exception");
            System.exit(0);
        }
        class ResultOfExpression {
            public static int resultOfExpression(int x, char sym, int y) {
                int result = 0;
                switch (sym) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x / y;
                        break;
                    default:
                        System.out.println("throws Exception");
                        System.exit(0);
                }
                return result;
            }

            public static String resultOfExpressionRome(int result) {
                StringBuilder sb = new StringBuilder();
                String[] arab = {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String[] rome = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
                if ((result - 50) >= 0) {
                    sb.append("L");
                    result = result - 50;
                }
                while (((result - 10) >= 0)) {
                    sb.append("X");
                    result = result - 10;
                }
                String result1 = Integer.toString(result);
                for (int i = 0; i < 10; i++) {
                    if (result1.equals(arab[i])) {
                        sb.append(rome[i]);
                    }
                }
                return sb.toString();

            }
        }
        ResultOfExpression result = new ResultOfExpression();
        String[] arab = {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] rome = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        int check = 1;
        for (int i = 0; i < 10; i++) {

            if (expressionArray[0].equals(rome[i])) {
                a = Integer.parseInt(arab[i]);
                for (int j = 0; j < 10; j++) {
                    if (expressionArray[2].equals(rome[j])) {
                        b = Integer.parseInt(arab[j]);
                        int result2 = result.resultOfExpression(a, symbol, b);
                        if (result2 <=0) {
                            System.out.println("throws Exception");
                            System.exit(0);
                        }
                        ResultOfExpression middlresult = new ResultOfExpression();
                        String finalResult2 = middlresult.resultOfExpressionRome(result2);
                        System.out.println(finalResult2);
                        break;
                    } else check++;

                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if (expressionArray[0].equals(arab[i])) {
                a = Integer.parseInt(arab[i]);
                for (int j = 0; j < 10; j++) {
                    if (expressionArray[2].equals(arab[j])) {
                        b = Integer.parseInt(arab[j]);
                        finalResult = result.resultOfExpression(a, symbol, b);
                        System.out.println(finalResult);
                        break;
                    } else check++;
                }
            }
        }
        if (check == 11) {
            System.out.println("throws Exception");
            System.exit(0);
        }
    }
}