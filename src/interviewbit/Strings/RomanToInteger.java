package interviewbit.Strings;

import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String A) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = 0;
		for (int i = 0; i < A.length(); i++) {
			result += map.get(A.charAt(i));
			if (i > 0 && map.get(A.charAt(i)) > map.get(A.charAt(i - 1))) {
				result -= 2 * map.get(A.charAt(i - 1));
			}
		}
		return result;
	}
}
