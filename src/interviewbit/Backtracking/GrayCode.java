package interviewbit.Backtracking;

import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int a) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < Math.pow(2, a); i++) {
			result.add(i ^ (i >> 1));
		}
		return result;
	}
}
