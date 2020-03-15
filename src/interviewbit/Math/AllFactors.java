package interviewbit.Math;

import java.util.ArrayList;
import java.util.Collections;

public class AllFactors {
	public ArrayList<Integer> allFactors(int A) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i <= (int) Math.sqrt(A); i++) {
			if (A % i == 0) {
				result.add(i);
				if (i * i != A) {
					result.add(A / i);
				}
			}
		}
		Collections.sort(result);
		return result;
	}
}
