package interviewbit.Backtracking;

import java.util.ArrayList;

public class Combinations {
	public static void main(String[] args) {
		System.out.println(new Combinations().combine(4, 2));
	}

	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		generate(A, B, result, new ArrayList<>(), 1);
		return result;
	}

	private void generate(int a, int b, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> row, int index) {
		if (row.size() >= b) return;
		for (int i = index; i <= a; i++) {
			row.add(i);
			if (row.size() == b) result.add(new ArrayList<>(row));
			generate(a, b, result, row, i + 1);
			row.remove(row.size() - 1);
		}
	}
}
