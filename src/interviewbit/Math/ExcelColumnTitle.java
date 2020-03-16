package interviewbit.Math;

public class ExcelColumnTitle {
	public String convertToTitle(int number) {
		StringBuilder builder = new StringBuilder();

		while (number > 0) {
			int ch = number % 26;
			if (ch == 0) {
				builder.append('Z');
				number = number / 26 - 1;
			} else {
				builder.append((char) ('A' + ch - 1));
				number /= 26;
			}
		}

		return builder.reverse().toString();
	}
}
