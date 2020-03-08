package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixI {
	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		int top = 0, bottom = matrix.size() - 1, left = 0, right = matrix.get(0).size() - 1, direction = 0;
		while (top <= bottom && left <= right) {
			if (direction == 0) {
				for (int i = left; i <= right; i++) result.add(matrix.get(top).get(i));
				top++;
				direction = 1;
			} else if (direction == 1) {
				for (int j = top; j <= bottom; j++) result.add(matrix.get(j).get(right));
				right--;
				direction = 2;
			} else if (direction == 2) {
				for (int i = right; i >= left; i--) result.add(matrix.get(bottom).get(i));
				bottom--;
				direction = 3;
			} else {
				for (int j = bottom; j >= top; j--) result.add(matrix.get(j).get(left));
				left++;
				direction = 0;
			}
		}
		return result;
	}
}
