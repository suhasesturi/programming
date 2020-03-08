package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatAndMissingNumberArray {
	public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
		int n = A.size();
		long expectedSum = ((long) n * (n + 1)) / 2;
		long expectedSumSquare = ((long) n * (n + 1) * (2 * n + 1)) / 6;
		long actualSum = 0;
		long AsMEs = -expectedSumSquare;
		for (Integer value : A) {
			actualSum += value;
			AsMEs += ((long) value * value);
		}

		int aPb = (int) (AsMEs / (actualSum - expectedSum));
		int a = (int) ((aPb + actualSum - expectedSum) / 2);
		int b = (int) (a + expectedSum - actualSum);

		return new ArrayList<>(Arrays.asList(a, b));
	}
}
