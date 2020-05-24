package interviewbit.Strings;


public class IntegerToRoman {
	public String intToRoman(int number) {
		String[] m = {"", "M", "MM", "MMM"};
		String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

		String thousands = m[number / 1000];
		number %= 1000;
		String hundreds = c[number / 100];
		number %= 100;
		String tens = x[number / 10];
		number %= 10;
		String ones = i[number];

		return thousands + hundreds + tens + ones;
	}
}
