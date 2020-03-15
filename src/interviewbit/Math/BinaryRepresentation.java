package interviewbit.Math;

public class BinaryRepresentation {
	public String findDigitsInBinary(int a) {
		if (a < 1) return "0";

		StringBuilder builder = new StringBuilder();
		while (a > 0) {
			builder.append(a % 2);
			a /= 2;
		}
		return builder.reverse().toString();
	}
}
