package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumII {
	public static void main(String[] args) {
		System.out.println(new CombinationSumII().combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8)), 28));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		generate(a, b, result, new ArrayList<>(), 0, 0);
		return result;
	}

	private void generate(ArrayList<Integer> list, int B, ArrayList<ArrayList<Integer>> result,
						  ArrayList<Integer> row, int index, int sum) {
		for (int i = index; i < list.size(); i++) {
			Integer number = list.get(i);
			// just look at this
			if (i > index && number.equals(list.get(i - 1))) continue;

			if (sum + number > B) return;
			row.add(number);
			sum += number;

			generate(list, B, result, row, i + 1, sum);
			if (sum == B) {
				result.add(new ArrayList<>(row));
			}
			row.remove(row.size() - 1);
			sum -= number;
		}
	}
}
