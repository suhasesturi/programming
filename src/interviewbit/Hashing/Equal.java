package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Equal {
	public static void main(String[] args) {
		System.out.println(new Equal().equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8))));
	}

	public ArrayList<Integer> equal(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Pair> map = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				if (map.containsKey(A.get(i) + A.get(j))) {
					Pair pair = map.get(A.get(i) + A.get(j));
					if (pair.a < i && pair.b != i && pair.b != j) {
						result = smaller(result, new ArrayList<>(Arrays.asList(pair.a, pair.b, i, j)));
					}
				} else {
					map.put(A.get(i) + A.get(j), new Pair(i, j));
				}
			}
		}
		return result;
	}

	private ArrayList<Integer> smaller(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a.isEmpty()) return b;
		else if (b.isEmpty()) return a;

		for (int i = 0; i < 4; i++) {
			if (a.get(i).equals(b.get(i))) continue;
			return a.get(i) < b.get(i) ? a : b;
		}
		return a;
	}

	static class Pair {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
