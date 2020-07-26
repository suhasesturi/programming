package interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {
	public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
		Collections.sort(mice);
		Collections.sort(holes);
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < mice.size(); i++) {
			result = Math.max(result, Math.abs(holes.get(i) - mice.get(i)));
		}
		return result;
	}
}
