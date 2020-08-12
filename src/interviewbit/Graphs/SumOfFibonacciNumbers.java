package interviewbit.Graphs;

import java.util.ArrayList;

public class SumOfFibonacciNumbers {
	public int fibsum(int A) {
		ArrayList<Integer> series = new ArrayList<>();
		series.add(1);
		series.add(1);
		int a = 1, b = 1, c;
		while (true) {
			c = a + b;
			if (c > A) break;
			series.add(c);
			a = b;
			b = c;
		}

		int count = 0;
		for (int i = series.size() - 1; i >= 0 & A != 0; ) {
			if (series.get(i) <= A) {
				count++;
				A -= series.get(i);
			} else {
				i--;
			}
		}
		return count;
	}
}
