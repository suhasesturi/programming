package interviewbit.Strings;

public class AddBinaryStrings {
	public static void main(String[] args) {
		System.out.println(new AddBinaryStrings().addBinary("1010110111001101101000", "1000011011000000111100110"));
	}

	public String addBinary(String A, String B) {
		StringBuilder result = new StringBuilder();
		int i = A.length() - 1;
		int j = B.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = 0;
			if (i >= 0) sum += A.charAt(i) - '0';
			if (j >= 0) sum += B.charAt(j) - '0';
			sum += carry;
			result.append(sum % 2);
			carry = sum / 2;
			i--;
			j--;
		}
		if (carry != 0) result.append(carry);
		return result.reverse().toString();
	}
}
