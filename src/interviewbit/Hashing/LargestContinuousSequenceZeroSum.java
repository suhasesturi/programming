package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {
	public ArrayList<Integer> lszero(ArrayList<Integer> A) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		map.put(0, new ArrayList<>(Collections.singletonList(-1)));
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			sum += A.get(i);
			if (map.containsKey(sum)) {
				map.get(sum).add(i);
			} else {
				map.put(sum, new ArrayList<>(Collections.singletonList(i)));
			}
		}

		int start = Integer.MAX_VALUE, end = -1, length = 0;
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> list = entry.getValue();
			if (list.size() > 1) {
				if (list.get(list.size() - 1) - list.get(0) > length ||
						(list.get(list.size() - 1) - list.get(0) == length && list.get(0) < start)) {
					start = list.get(0);
					end = list.get(list.size() - 1);
					length = end - start;
				}
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = start + 1; i <= end; i++) {
			result.add(A.get(i));
		}
		return result;
	}
}
