package interviewbit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<String> expression = new Stack<>();
        for (String a : A) {
            if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/")) {
                int first = Integer.parseInt(expression.pop());
                int second = Integer.parseInt(expression.pop());

                switch (a) {
                    case "+":
                        expression.push(String.valueOf(first + second));
                        break;
                    case "-":
                        expression.push(String.valueOf(second - first));
                        break;
                    case "*":
                        expression.push(String.valueOf(first * second));
                        break;
                    case "/":
                        expression.push(String.valueOf(second / first));
                        break;
                }
            } else {
                expression.push(a);
            }
        }

        return Integer.parseInt(expression.pop());
    }
}
