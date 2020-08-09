package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallestSequenceWithGivenPrimes {
	public static void main(String[] args) {
		System.out.println(new SmallestSequenceWithGivenPrimes().solve(3, 11, 7, 50));
	}

	public ArrayList<Integer> solve(int A, int B, int C, int D) {
		int[] primes = {A, B, C};
		int[] pointer = {-1, -1, -1};
		ArrayList<Integer> result = new ArrayList<>();
		Arrays.sort(primes);

		int[] values = new int[3];
		for (int i = 0; i < D; ) {
			for (int j = 0; j < 3; j++) {
				values[j] = primes[j] * (pointer[j] == -1 ? 1 : result.get(pointer[j]));
			}
			int current;
			if (values[0] <= values[1] && values[0] <= values[2]) {
				pointer[0]++;
				current = values[0];
			} else if (values[1] <= values[0] && values[1] <= values[2]) {
				pointer[1]++;
				current = values[1];
			} else {
				pointer[2]++;
				current = values[2];
			}

			if (result.isEmpty() || result.get(result.size() - 1) != current) {
				result.add(current);
				i++;
			}
		}

		return result;
	}
}
