package interviewbit.Hashing;

import java.util.HashSet;

public class ColorfulNumber {
	public static void main(String[] args) {
		System.out.println(new ColorfulNumber().colorful(23));
	}

	public int colorful(int A) {
		HashSet<Integer> set = new HashSet<>();
		String s = String.valueOf(A);
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j + i <= s.length(); j++) {
				int product = 1;
				for (int k = 0; k < i; k++) {
					product *= s.charAt(j + k) - '0';
				}
				if (set.contains(product)) return 0;
				set.add(product);
			}
		}
		return 1;
	}
}
