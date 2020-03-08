package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {
	public static void main(String[] args) {
		System.out.println(new AddOneToNumber().plusOne(new ArrayList<>(Arrays.asList(0))));
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int carry = 1;
		for (int i = A.size() - 1; i >= 0; i--) {
			if (carry == 0) break;
			int current = A.get(i) + carry;
			A.set(i, current % 10);
			carry = current / 10;
		}
		if (carry == 1) {
			A.add(0, 1);
		}

		ArrayList<Integer> result = new ArrayList<>();
		boolean flag = false;
		for (Integer integer : A) {
			if (integer != 0) {
				flag = true;
			}
			if (flag) {
				result.add(integer);
			}
		}
		return result;
	}
}
