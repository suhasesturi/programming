package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumWithoutAdjacentElements {
	public static void main(String[] args) {
		ArrayList<Integer> one = new ArrayList<>(Arrays.asList(74, 37, 82, 1));
		ArrayList<Integer> two = new ArrayList<>(Arrays.asList(66, 38, 16, 1));

		System.out.println(new MaxSumWithoutAdjacentElements().adjacent(new ArrayList<>(Arrays.asList(one, two))));
	}

	public int adjacent(ArrayList<ArrayList<Integer>> list) {
		int[] inclusive = {list.get(0).get(0), list.get(1).get(0)};
		int[] exclusive = {0, 0};
		int[] exclusiveNew = new int[2];

		for (int i = 1; i < list.get(0).size(); i++) {
			exclusiveNew[0] = Math.max(inclusive[0], exclusive[0]);
			exclusiveNew[1] = Math.max(inclusive[1], exclusive[1]);

			inclusive[0] = Math.max(exclusive[0], exclusive[1]) + list.get(0).get(i);
			inclusive[1] = Math.max(exclusive[0], exclusive[1]) + list.get(1).get(i);

			exclusive[0] = exclusiveNew[0];
			exclusive[1] = exclusiveNew[1];
		}

		return Math.max(Math.max(inclusive[0], inclusive[1]), Math.max(exclusive[0], exclusive[1]));
	}
}
