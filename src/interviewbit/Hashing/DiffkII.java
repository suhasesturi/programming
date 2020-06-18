package interviewbit.Hashing;

import java.util.HashSet;
import java.util.List;

public class DiffkII {
	public int diffPossible(final List<Integer> A, int B) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < A.size(); i++) {
			if (set.contains(A.get(i) + B)) return 1;
			set.add(A.get(i));
		}

		set.clear();
		for (int i = A.size() - 1; i >= 0; i--) {
			if (set.contains(A.get(i) + B)) return 1;
			set.add(A.get(i));
		}
		return 0;
	}
}
