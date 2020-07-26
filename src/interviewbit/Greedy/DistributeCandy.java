package interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandy {
	public int candy(ArrayList<Integer> A) {
		int[] candies = new int[A.size()];
		Arrays.fill(candies, 1);
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) > A.get(i - 1)) candies[i] = candies[i - 1] + 1;
		}
		for (int i = A.size() - 2; i >= 0; i--) {
			if (A.get(i) > A.get(i + 1)) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
		}
		int sum = 0;
		for (int candy: candies) sum += candy;
		return sum;
	}
}
