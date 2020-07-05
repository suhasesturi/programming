package interviewbit.Backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		generate(a, result, new ArrayList<>(), 0);
		return result;
	}

	private void generate(String a, ArrayList<ArrayList<String>> result, ArrayList<String> row, int index) {
		if (index == a.length()) {
			result.add(new ArrayList<>(row));
			return;
		}

		for (int i = index; i < a.length(); i++) {
			if (isPalindrome(a, index, i)) {
				row.add(a.substring(index, i + 1));
				generate(a, result, row, i + 1);
				row.remove(row.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String a, int i, int j) {
		for (; i < j; i++, j--) {
			if (a.charAt(i) != a.charAt(j)) return false;
		}
		return true;
	}
}
