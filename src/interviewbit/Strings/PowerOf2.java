package interviewbit.Strings;

public class PowerOf2 {
	public static void main(String[] args) {
		System.out.println(new PowerOf2().power("323434"));
	}

	public int power(String A) {
		if (A.isEmpty() || A.equals("1")) return 0;

		StringBuilder builder = new StringBuilder();
		while (!A.equals("1")) {
			if ((A.charAt(A.length() - 1) - '0') % 2 != 0) return 0;
			int carry = A.charAt(0) - '0';
			for (int i = 1; i < A.length(); i++) {
				int current = A.charAt(i) - '0' + carry * 10;
				builder.append(current / 2);
				carry = current % 2;
			}
			if (carry != 0) builder.append(carry / 2);
			A = builder.toString();
			builder = new StringBuilder();
		}
		return 1;
	}
}
