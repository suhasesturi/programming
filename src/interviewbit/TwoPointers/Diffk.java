package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.HashSet;

public class Diffk {
	public int diffPossible(ArrayList<Integer> A, int B) {
		int i = 0, j = 1;
		while (i < A.size() && j < A.size()) {
			int diff = A.get(j) - A.get(i);
			if (diff == B && i != j) return 1;
			if (diff < B) j++;
			else i++;
		}
		return 0;
	}
}
