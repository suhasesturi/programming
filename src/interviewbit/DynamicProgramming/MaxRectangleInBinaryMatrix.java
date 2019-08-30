package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> matrix) {
        int result = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (i != 0 && matrix.get(i).get(j) != 0) {
                    matrix.get(i).set(j, matrix.get(i - 1).get(j) + 1);
                }
            }
            result = Math.max(result, maxAreaHistogram(matrix.get(i)));
        }
        return result;
    }

    private int maxAreaHistogram(ArrayList<Integer> row) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int i = 0;
        while (i < row.size()) {
            if (stack.isEmpty() || (row.get(stack.peek()) <= row.get(i))) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int area = row.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                result = Math.max(result, area);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = row.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            result = Math.max(result, area);
        }
        return result;
    }
}
