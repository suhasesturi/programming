package interviewbit.Hashing;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
	public int lengthOfLongestSubstring(String A) {
		HashMap<Character, Integer> map = new HashMap<>();
		int result = 0, start = 0;
		for (int i = 0; i < A.length(); i++) {
			char key = A.charAt(i);
			if (map.containsKey(key)) {
				if (map.get(key) >= start) {
					start = map.get(key) + 1;
				}
			}
			result = Math.max(result, i - start + 1);
			map.put(key, i);
		}
		return result;
	}
}
