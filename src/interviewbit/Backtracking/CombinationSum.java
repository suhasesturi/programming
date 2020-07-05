package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {
	public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(new ArrayList<>(Arrays.asList(6, 3, 2, 7, 2)), 8));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		A = new ArrayList<>(new HashSet<>(A));
		Collections.sort(A);

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		generate(A, B, result, new ArrayList<>(), 0, 0);
		return result;
	}

	private void generate(ArrayList<Integer> list, int B, ArrayList<ArrayList<Integer>> result,
						  ArrayList<Integer> row, int index, int sum) {
		for (int i = index; i < list.size(); i++) {
			while (sum + list.get(i) <= B) {
				sum += list.get(i);
				row.add(list.get(i));
			}

			if (row.isEmpty() || !row.get(row.size() - 1).equals(list.get(i))) return;

			while (!row.isEmpty() && row.get(row.size() - 1).equals(list.get(i))) {
				generate(list, B, result, row, i + 1, sum);
				if (sum == B) result.add(new ArrayList<>(row));
				row.remove(row.size() - 1);
				sum -= list.get(i);
			}
		}
	}
}
