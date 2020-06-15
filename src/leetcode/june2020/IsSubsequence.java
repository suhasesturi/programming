package leetcode.june2020;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int i, j;
		for (i = 0, j = 0; j < s.length() && i < t.length(); i++) {
			if (s.charAt(j) == t.charAt(i)) j++;
		}
		return j == s.length();
	}
}
