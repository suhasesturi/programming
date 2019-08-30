package interviewbit.StacksAndQueues;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> elements = new Stack<>();
    private Stack<Integer> minimum = new Stack<>();

    public void push(int x) {
        elements.push(x);
        if (minimum.isEmpty() || minimum.peek() >= x) minimum.add(x);
    }

    public void pop() {
        if (!elements.isEmpty()) {
            if (minimum.peek().equals(elements.pop())) minimum.pop();
        }
    }

    public int top() {
        return elements.isEmpty() ? -1 : elements.peek();
    }

    public int getMin() {
        return minimum.isEmpty() ? -1 : minimum.peek();
    }
}




