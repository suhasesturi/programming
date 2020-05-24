package interviewbit.Strings;

public class ImplementStrStr {
	public int strStr(final String text, final String pattern) {
		if (text.isEmpty() || pattern.isEmpty()) return -1;

		int[] prefix = computePrefixFunction(pattern);
		int q = 0;
		for (int i = 0; i < text.length(); i++) {
			while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
				q = prefix[q - 1];
			}
			if (pattern.charAt(q) == text.charAt(i)) {
				q++;
			}
			if (q == pattern.length()) return i - pattern.length() + 1;
		}
		return -1;
	}

	private int[] computePrefixFunction(String pattern) {
		int[] prefix = new int[pattern.length()];
		int q = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (q > 0 && pattern.charAt(i) != pattern.charAt(q)) {
				q = prefix[q - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(q)) {
				q++;
			}
			prefix[i] = q;
		}
		return prefix;
	}
}
