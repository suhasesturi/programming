package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class OrderOfPeopleHeight {
	public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> inFronts) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < heights.size(); i++) {
			map.put(heights.get(i), inFronts.get(i));
			result.add(-1);
		}

		for (int height : map.keySet()) {
			int count = map.get(height);
			for (int i = 0; i < result.size(); i++) {
				if (count <= 0 && result.get(i) == -1) {
					result.set(i, height);
					break;
				} else if (result.get(i) == -1) count--;
			}
		}
		return result;
	}
}
