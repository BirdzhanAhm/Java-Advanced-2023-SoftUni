/*
8. *Infix to Postfix
        Mathematical expressions are written in an infix notations, for example "5 / ( 3 + 2 )". However, this kind of
        notation is not efficient for computer processing, as you first need to evaluate the expression inside the brackets, so
        there is a lot of back and forth movement. A more suitable approach is to convert it into the so-called postfix
        notations (also called Reverse Polish Notation), in which the expression is evaluated from left to right, for example,
        "3 2 + 5 /".
        Implement an algorithm that converts the mathematical expression from infix notation into a postfix notation. Use
        the famous Shunting-yard algorithm.
        Input
        • You will receive an expression on a single line consisting of tokens.
        • Tokens could be numbers 0-9, variables a-z, operators +, -, *, / and brackets ( or ).
        • Each token is separated by exactly one space.
        Output
        • The output should be on a single line, consisting of tokens separated by exactly one space.

*/

import java.util.*;

public class InfixtoPostfix08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String currentOperator = input[i];
            switch (currentOperator) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                case "(":
                    if (operators.isEmpty() || hasLowerPrecedence(operators.peek(), currentOperator)) {
                        operators.push(currentOperator);
                    } else {
                        while (!hasLowerPrecedence(operators.peek(), currentOperator)) {
                            System.out.print(operators.pop() + " ");
                            if (operators.isEmpty()) {
                                break;
                            }
                        }

                        operators.push(currentOperator);
                    }
                    break;
                case ")":
                    while (!operators.peek().equals("(")) {
                        System.out.print(operators.pop() + " ");
                    }
                    operators.pop();
                    break;
                default:
                    System.out.print(currentOperator + " ");
            }
        }

        while (!operators.isEmpty()) {
            System.out.print(operators.pop() + " ");
        }
    }

    private static boolean hasLowerPrecedence(String current, String next) {
        int currentOperatorPrecedence = precedence(current);
        int nextOperatorPrecedence = precedence(next);
        if (currentOperatorPrecedence < nextOperatorPrecedence) {
            return true;
        } else if (currentOperatorPrecedence == nextOperatorPrecedence) {
            if (currentOperatorPrecedence == 3 || currentOperatorPrecedence == 4) {
                return true;
            } else {
                return false;
            }
        } else {
            if (currentOperatorPrecedence == 4) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static int precedence(String operator) {
        int precedence = 0;
        if (operator.equals("+") || operator.equals("-")) {
            precedence = 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            precedence = 2;
        } else if (operator.equals("^")) {
            precedence = 3;
        } else if (operator.equals("(")) {
            precedence = 4;
        }

        return precedence;

    }
}

