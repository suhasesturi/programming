package interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct {
	public int maxp3(ArrayList<Integer> A) {
		if (A.size() < 3) return 0;
		Collections.sort(A);

		int n = A.size() - 1;
		return Math.max(
				A.get(0) * A.get(1) * A.get(2),
				Math.max(A.get(n) * A.get(n - 1) * A.get(n - 2), A.get(n) * A.get(0) * A.get(1))
		);
	}
}
