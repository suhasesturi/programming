package interviewbit.TwoPointers;

import java.util.*;

public class ThreeSumZero {
	public static void main(String[] args) {
		System.out.println(new ThreeSumZero().threeSum(new ArrayList<>(Arrays.asList(2147483647, -2147483648, -2147483648, 0, 1))));
	}

	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		int first, second, third;
		for (int i = 0; i < A.size(); i++) {
			first = A.get(i);
			for (int j = i + 1, k = A.size() - 1; j < k; ) {
				second = A.get(j);
				third = A.get(k);

				long sum = (long) first + second + third;
				if (sum == 0) {
					if (map.containsKey(first)) {
						if (!map.get(first).contains(second)) {
							map.get(first).add(second);
							result.add(new ArrayList<>(Arrays.asList(first, second, third)));
						}
					} else {
						HashSet<Integer> temp = new HashSet<>();
						temp.add(second);
						map.put(first, temp);
						result.add(new ArrayList<>(Arrays.asList(first, second, third)));
					}
				}
				if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}
}


