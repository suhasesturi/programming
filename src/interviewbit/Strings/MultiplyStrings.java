package interviewbit.Strings;

public class MultiplyStrings {
	public String multiply(String a, String b) {
		if (a.isEmpty() || b.isEmpty()) return "0";
		int n = a.length();
		int m = b.length();
		int[] values = new int[n + m];

		for (int i = n - 1; i >= 0; i--) {
			int first = a.charAt(i) - '0';
			int carry = 0;
			int index = 0;
			for (int j = m - 1; j >= 0; j--) {
				int second = b.charAt(j) - '0';
				index = m - j - 1 + n - i - 1;
				int product = first * second + carry + values[index];
				values[index] = product % 10;
				carry = product / 10;
			}
			if (carry != 0) {
				values[++index] += carry;
			}
		}

		int index = n + m - 1;
		while (index >= 0 && values[index] == 0) index--;

		if (index < 0) return "0";
		StringBuilder builder = new StringBuilder();
		for (int i = index; i >= 0; i--) {
			builder.append(values[i]);
		}
		return builder.toString();
	}
}
