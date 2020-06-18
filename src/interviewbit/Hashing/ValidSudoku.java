package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {
	public static void main(String[] args) {
		System.out.println(new ValidSudoku().isValidSudoku(new ArrayList<>(Arrays.asList("....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"))));
	}

	public int isValidSudoku(final List<String> A) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < A.size(); i++) {
			set.clear();
			for (int j = 0; j < A.size(); j++) {
				char ch = A.get(i).charAt(j);
				if (ch == '.') continue;
				if (set.contains(ch)) return 0;
				set.add(ch);
			}
		}

		for (int j = 0; j < A.size(); j++) {
			set.clear();
			for (int i = 0; i < A.size(); i++) {
				char ch = A.get(i).charAt(j);
				if (ch == '.') continue;
				if (set.contains(ch)) return 0;
				set.add(ch);
			}
		}

		for (int i = 0; i < A.size(); i += 3) {
			for (int j = 0; j < A.size(); j += 3) {
				if (!validSquare(A, i, j)) return 0;
			}
		}
		return 1;
	}

	private boolean validSquare(List<String> A, int y, int x) {
		HashSet<Character> set = new HashSet<>();
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				char ch = A.get(i).charAt(j);
				if (ch == '.') continue;
				if (set.contains(ch)) return false;
				set.add(ch);
			}
		}
		return true;
	}
}
