package leetcode.june2020;

import java.util.Arrays;

public class TwoCityScheduling {
	public int twoCitySchedCost(int[][] costs) {
		int[] refunds = new int[costs.length];
		int totalCost = 0;
		for (int i = 0; i < costs.length; i++) {
			refunds[i] = costs[i][1] - costs[i][0];
			totalCost += costs[i][0];
		}
		Arrays.sort(refunds);
		for (int i = 0; i < costs.length / 2; i++) {
			totalCost += refunds[i];
		}
		return totalCost;
	}
}
