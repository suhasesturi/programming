package interviewbit.Hashing;

import java.util.*;

public class Anagrams {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < A.size(); i++) {
			String s = A.get(i);
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String str = Arrays.toString(chars);
			if (map.containsKey(str)) {
				result.get(map.get(str)).add(i + 1);
			} else {
				result.add(new ArrayList<>(Collections.singletonList(i + 1)));
				map.put(str, result.size() - 1);
			}
		}
		return result;
	}
}
