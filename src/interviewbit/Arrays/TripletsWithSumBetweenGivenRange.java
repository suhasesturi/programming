package interviewbit.Arrays;

import java.util.ArrayList;

public class TripletsWithSumBetweenGivenRange {
	public int solve(ArrayList<String> A) {
		ArrayList<Double> list = new ArrayList<>();
		for (String s : A) {
			list.add(Double.parseDouble(s));
		}
		list.add(0.0);

		double a = list.get(0), b = list.get(1), c = list.get(2);
		for (int i = 3; i < list.size(); i++) {
			if (a + b + c > 1 && a + b + c < 2) return 1;
			else if (a + b + c > 2) {
				if (a > b && a > c) a = list.get(i);
				else if (b > c && b > a) b = list.get(i);
				else c = list.get(i);
			} else {
				if (a < b && a < c) a = list.get(i);
				else if (b < a && b < c) b = list.get(i);
				else c = list.get(i);
			}
		}
		return 0;
	}
}
