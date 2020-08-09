package interviewbit.DynamicProgramming;

import java.util.ArrayList;

public class TusharsBirthdayBombs {
	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		int min = Integer.MAX_VALUE;
		for (Integer integer : B) min = Math.min(integer, min);

		int length = A / min;
		int remainder = A - min * length;
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < B.size() && result.size() < length; ) {
			int diff = B.get(i) - min;
			if (diff <= remainder) {
				result.add(i);
				remainder -= diff;
			} else {
				i++;
			}
		}

		return result;
	}
}
