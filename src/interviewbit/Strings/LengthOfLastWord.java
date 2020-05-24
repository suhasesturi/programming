package interviewbit.Strings;

public class LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(new LengthOfLastWord().lengthOfLastWord("  234234asdf   "));
	}

	public int lengthOfLastWord(final String word) {
		int result = 0;
		for (int i = word.length() - 1; i >= 0; i--) {
			if (word.charAt(i) != ' ') {
				result++;
			} else if (result == 0) continue;
			else break;
		}
		return result;
	}
}
