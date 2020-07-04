package interviewbit.Hashing;

import java.util.HashMap;
import java.util.Map;

public class Fraction {
	public static void main(String[] args) {
		System.out.println(new Fraction().fractionToDecimal(1, 154));
	}

	public String fractionToDecimal(int numerator, int denominator) {
		long a = numerator, b = denominator;
		if (a % b == 0) return String.valueOf(a / b);

		StringBuilder res = new StringBuilder();
		if (a < 0 ^ b < 0) res.append("-");
		a = Math.abs(a);
		b = Math.abs(b);
		res.append(a / b).append(".");
		a = (a % b) * 10;

		Map<Long, Integer> map = new HashMap<>();
		while (!map.containsKey(a)) {
			map.put(a, res.length());
			res.append(a / b);
			a = (a % b) * 10;
			if (a == 0) return res.toString();
		}

		return res.insert(map.get(a), "(").append(')').toString();
	}
}
