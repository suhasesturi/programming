package interviewbit.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersOfLengthNAndValueLessThanK {
	public static void main(String[] args) {
		System.out.println(new NumbersOfLengthNAndValueLessThanK().solve(
				new ArrayList<>(Arrays.asList(0, 1, 2, 5)), 1, 123));
	}

	public int solve(ArrayList<Integer> A, int B, int C) {
		ArrayList<Integer> digits = new ArrayList<>();
		String s = String.valueOf(C);
		for (int i = 0; i < s.length(); i++) {
			digits.add(s.charAt(i) - '0');
		}

		if (B > digits.size()) return 0;
		if (B < digits.size()) {
			if (A.contains(0) && B > 1) {
				return (A.size() - 1) * (int) Math.pow(A.size(), B - 1);
			}
			return (int) Math.pow(A.size(), B);
		}
		return calculateWhenEquals(A, digits, 0, B);
	}

	private int calculateWhenEquals(ArrayList<Integer> A, ArrayList<Integer> digits, int index, int B) {
		if (index == B) return 0;
		int i;
		int count = 0;
		for (i = 0; i < A.size(); i++) {
			if (A.get(i) < digits.get(index)) {
				count++;
				if (A.get(i) == 0 && B > 1 && index == 0) {
					count--;
				}
			} else {
				break;
			}
		}

		int result = count * (int) Math.pow(A.size(), B - index - 1);
		if (i < A.size() && A.get(i).equals(digits.get(index))) {
			result += calculateWhenEquals(A, digits, index + 1, B);
		}

		return result;
	}
}
