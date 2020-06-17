package interviewbit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for (String s : A) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
