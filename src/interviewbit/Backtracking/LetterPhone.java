package interviewbit.Backtracking;

import java.util.ArrayList;

public class LetterPhone {
	private final String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public static void main(String[] args) {
		System.out.println(new LetterPhone().letterCombinations("22"));
	}

	public ArrayList<String> letterCombinations(String A) {
		ArrayList<String> result = new ArrayList<>();
		generate(A, result, new StringBuilder(), 0);
		return result;
	}

	private void generate(String a, ArrayList<String> result, StringBuilder pattern, int index) {
		if (index == a.length()) return;
		String chars = mapping[a.charAt(index) - '0'];
		for (char ch : chars.toCharArray()) {
			pattern.append(ch);
			generate(a, result, pattern, index + 1);
			if (pattern.length() == a.length()) {
				result.add(pattern.toString());
			}
			pattern.deleteCharAt(pattern.length() - 1);
		}
	}
}
