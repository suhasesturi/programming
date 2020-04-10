package interviewbit.Strings;

public class AmazingSubArrays {
	public int solve(String A) {
		long result = 0;
		int n = A.length();
		for (int i = 0; i < n; i++) {
			char ch = A.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
					ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                result = (result + (n - i)) % 10003;
			}
		}
		return (int) result;
	}
}

