package interviewbit.Greedy;

import java.util.ArrayList;

public class Bulbs {
	public int bulbs(ArrayList<Integer> A) {
		int ans = 0;
		for (Integer bulb : A) {
			if (ans % 2 == 0) {
				ans += bulb == 1 ? 0 : 1;
			} else {
				ans += bulb == 1 ? 1 : 0;
			}
		}
		return ans;
	}
}
