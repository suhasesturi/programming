package interviewbit.Math;

public class ExcelColumnNumber {
	public int titleToNumber(String title) {
		int result = 0;
		for (int i = title.length() - 1, j = 0; i >= 0; i--, j++) {
			result += ((title.charAt(i) - 'A' + 1) * Math.pow(26, j));
		}
		return result;
	}
}
