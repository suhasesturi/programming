package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		generate(A, result, new ArrayList<>(), 0);
		return result;
	}

	private void generate(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> row, int index) {
		for (int i = index; i < list.size(); i++) {
			row.add(list.get(i));
			result.add(new ArrayList<>(row));
			generate(list, result, row, i + 1);
			row.remove(row.size() - 1);
		}
	}
}
