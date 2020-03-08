package interviewbit.Arrays;

import java.util.ArrayList;

public class MinStepsInInfiniteGrid {
	public int coverPoints(ArrayList<Integer> first, ArrayList<Integer> second) {
		int result = 0;
		for (int i = 1; i < first.size(); i++) {
			result += Math.max(Math.abs(first.get(i) - first.get(i - 1)), Math.abs(second.get(i) - second.get(i - 1)));
		}
		return result;
	}
}
