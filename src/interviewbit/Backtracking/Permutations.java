package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.swap;

public class Permutations {
	public static void main(String[] args) {
		System.out.println(new Permutations().permute(new ArrayList<>(Arrays.asList(1, 2, 3))));
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		generate(A, result, 0);
		return result;
	}

	private void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> result, int index) {
		if (index == a.size()) {
			result.add(new ArrayList<>(a));
			return;
		}

		for (int i = index; i < a.size(); i++) {
			swap(a, index, i);
			generate(a, result, index + 1);
			swap(a, index, i);
		}
	}
}
