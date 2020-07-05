package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {
	public static void main(String[] args) {
		System.out.println(new SubstringConcatenation().findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar")));
	}

	public ArrayList<Integer> findSubstring(String A, final List<String> B) {
		ArrayList<Integer> result = new ArrayList<>();
		if (B.isEmpty()) return result;

		HashMap<String, Integer> map = new HashMap<>();
		for (String s : B) map.put(s, map.getOrDefault(s, 0) + 1);
		int m = B.get(0).length();
		int n = m * B.size();

		for (int i = 0; i + n <= A.length(); i++) {
			String word = A.substring(i, i + m);
			if (map.containsKey(word)) {
				HashMap<String, Integer> tempMap = (HashMap<String, Integer>) map.clone();
				for (int j = i; j + m <= A.length(); j += m) {
					word = A.substring(j, j + m);
					Integer count = tempMap.get(word);
					if (count == null) break;
					if (count == 1) {
						tempMap.remove(word);
					} else {
						tempMap.put(word, count - 1);
					}
				}
				if (tempMap.isEmpty()) result.add(i);
			}
		}
		return result;
	}
}
