package lintcode;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> primary;
    private Stack<Integer> secondary;

    public MinStack() {
        primary = new Stack<>();
        secondary = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        primary.push(number);
        if (secondary.isEmpty() || secondary.peek() >= number)
            secondary.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (primary.isEmpty()) throw new EmptyStackException();
        int top = primary.pop();
        if (top == secondary.peek())
            secondary.pop();
        return top;
    }

    /*
     * @return: An integer
     */
    public int min() {
        return secondary.peek();
    }
}
