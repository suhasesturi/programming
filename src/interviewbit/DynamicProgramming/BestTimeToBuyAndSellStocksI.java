package interviewbit.DynamicProgramming;

import java.util.List;

public class BestTimeToBuyAndSellStocksI {
	public int maxProfit(final List<Integer> A) {
		if (A.isEmpty()) return 0;
		int profit = 0;
		int minimum = Integer.MAX_VALUE;
		for (Integer price : A) {
			minimum = Math.min(minimum, price);
			profit = Math.max(profit, price - minimum);
		}
		return profit;
	}
}
