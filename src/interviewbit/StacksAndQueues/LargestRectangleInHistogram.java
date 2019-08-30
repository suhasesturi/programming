package interviewbit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> lengths = new Stack<>();
        int i = 0;
        int result = 0;
        while (i < A.size()) {
            if (lengths.isEmpty() || A.get(lengths.peek()) <= A.get(i)) {
                lengths.push(i++);
            } else {
                int area = getArea(A, lengths, i);
                result = Math.max(area, result);
            }
        }

        while (!lengths.isEmpty()) {
            int area = getArea(A, lengths, i);
            result = Math.max(area, result);
        }

        return result;
    }

    private int getArea(ArrayList<Integer> A, Stack<Integer> lengths, int i) {
        int top = lengths.pop();
        return A.get(top) * (lengths.isEmpty() ? i : i - lengths.peek() - 1);
    }
}
