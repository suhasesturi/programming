package interviewbit.HeapsAndMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<>();
		if (B > A.size()) return result;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B; i++) {
			map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
		}
		result.add(map.size());

		for (int i = B, j = 0; i < A.size(); i++, j++) {
			Integer previous = A.get(j);
			if (map.get(previous) == 1) {
				map.remove(previous);
			} else {
				map.put(previous, map.get(previous) - 1);
			}

			map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
			result.add(map.size());
		}
		return result;
	}
}
