package interviewbit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartitionProblem {
	public static void main(String[] args) {
		System.out.println(new PaintersPartitionProblem().paint(3, 10,
				new ArrayList<>(Arrays.asList(640, 435, 647, 352, 8, 90, 960, 329, 859))));
	}

	public int paint(int A, int B, ArrayList<Integer> list) {
		int mod = 10000003;
		long low = Integer.MIN_VALUE;
		long high = 0;
		for (Integer integer : list) {
			low = Math.max(low, integer);
			high += integer;
		}

		while (low < high) {
			long mid = (low + high) / 2;
			int count = 1;
			long sum = 0;
			for (int i = 0; i < list.size() && count <= A; i++) {
				sum += list.get(i);
				if (sum > mid) {
					sum = list.get(i);
					count++;
				}
			}

			if (count <= A) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return (int) (((low % mod) * (B % mod)) % mod);
	}
}
