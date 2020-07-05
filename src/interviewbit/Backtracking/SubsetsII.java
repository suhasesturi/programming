package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetsII {
	public static void main(String[] args) {
		System.out.println(new SubsetsII().subsetsWithDup(new ArrayList<>(Arrays.asList(2, 1, 2))));
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		generate(A, result, new ArrayList<>(), 0);
		return result;
	}

	private void generate(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result,
						  ArrayList<Integer> row, int index) {
		for (int i = index; i < list.size(); i++) {
			// just look at this
			if (i > index && list.get(i).equals(list.get(i - 1))) continue;

			row.add(list.get(i));
			result.add(new ArrayList<>(row));
			generate(list, result, row, i + 1);
			row.remove(row.size() - 1);
		}
	}
}
