package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < A.size(); i++) {
			if (i == 0 || !A.get(i - 1).equals(A.get(i))) {
				for (int j = i + 1; j < A.size(); j++) {
					if (j == i + 1 || !A.get(j - 1).equals(A.get(j))) {
						set.clear();

						ArrayList<ArrayList<Integer>> twoSum = new ArrayList<>();
						int required = B - A.get(i) - A.get(j);
						for (int k = j + 1; k < A.size(); k++) {
							if (twoSum.isEmpty() || !twoSum.get(twoSum.size() - 1).get(1).equals(A.get(k))) {
								if (set.contains(required - A.get(k))) {
									twoSum.add(new ArrayList<>(Arrays.asList(required - A.get(k), A.get(k))));
								}
							}
							set.add(A.get(k));
						}

						for (ArrayList<Integer> list : twoSum) {
							result.add(new ArrayList<>(Arrays.asList(A.get(i), A.get(j))));
							result.get(result.size() - 1).addAll(list);
						}
					}
				}
			}
		}

		result.sort((a, b) -> {
			for (int i = 0; i < 4; i++) {
				if (!a.get(i).equals(b.get(i))) return a.get(i) - b.get(i);
			}
			return -1;
		});
		return result;
	}
}
