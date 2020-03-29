package interviewbit.Strings;

public class PalindromeString {
	public static void main(String[] args) {
		System.out.println(new PalindromeString().isPalindrome("Asdf"));
	}

	public int isPalindrome(String A) {
		for (int i = 0, j = A.length() - 1; i <= j; ) {
			char first = A.charAt(i);
			char last = A.charAt(j);
			boolean firstValid = Character.isAlphabetic(first) || Character.isDigit(first);
			if (firstValid && (Character.isAlphabetic(last) || Character.isDigit(last))) {
				if (Character.toLowerCase(first) != Character.toLowerCase(last)) return 0;
				i++;
				j--;
			} else if (firstValid) {
				j--;
			} else {
				i++;
			}
		}
		return 1;
	}
}
