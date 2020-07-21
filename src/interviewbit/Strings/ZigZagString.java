package interviewbit.Strings;

public class ZigZagString {
	public static void main(String[] args) {
		System.out.println(new ZigZagString().convert("abcdef", 3));
	}

	public String convert(String word, int B) {
		if (B == 1) return word;
		StringBuilder[] lines = new StringBuilder[B];
		for (int i = 0; i < B; i++) {
			lines[i] = new StringBuilder();
		}

		int row = 0;
		boolean down = true;
		for (int i = 0; i < word.length(); i++) {
			lines[row].append(word.charAt(i));
			if (row == B - 1) {
				down = false;
			} else if (row == 0) {
				down = true;
			}

			if (down) row++;
			else row--;
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < B; i++) {
			result.append(lines[i].toString());
		}
		return result.toString();
	}
}
