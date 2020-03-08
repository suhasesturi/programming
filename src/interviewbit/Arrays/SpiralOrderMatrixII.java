package interviewbit.Arrays;

import java.util.ArrayList;

public class SpiralOrderMatrixII {
	public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				temp.add(0);
			}
			result.add(temp);
		}

		int top = 0, bottom = n - 1, left = 0, right = n - 1;
		int direction = 0;
		int count = 1;
		while (top <= bottom && left <= right) {
			if (direction == 0) {
				for (int i = left; i <= right; i++) result.get(top).set(i, count++);
				top++;
				direction = 1;
			} else if (direction == 1) {
				for (int i = top; i <= bottom; i++) result.get(i).set(right, count++);
				right--;
				direction = 2;
			} else if (direction == 2) {
				for (int i = right; i >= left; i--) result.get(bottom).set(i, count++);
				bottom--;
				direction = 3;
			} else {
				for (int i = bottom; i >= top ; i--) result.get(i).set(left, count++);
				left++;
				direction = 0;
			}
		}

		return result;
	}
}
