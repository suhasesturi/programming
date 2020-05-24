package interviewbit.Strings;

public class LongestPalindromicSubString {
	public String longestPalindrome(String A) {
		String result = "";
		for (int i = 0; i < A.length(); i++) {
			String temp = subStringPalindrome(A, i, i);
			if (temp.length() > result.length()) result = temp;

			temp = subStringPalindrome(A, i, i + 1);
			if (temp.length() > result.length()) result = temp;
		}

		return result;
	}

	private String subStringPalindrome(String a, int i, int j) {
		for (; i >= 0 && j < a.length(); i--, j++) {
			if (a.charAt(i) != a.charAt(j)) {
				break;
			}
		}
		return a.substring(i + 1, j);
	}
}

