package leetcode.june2020;

public class HIndexII {
	public int hIndex(int[] citations) {
		if (citations.length == 0) return 0;
		int n = citations.length;
		int a = 0, b = citations.length - 1;
		while (a < b) {
			int mid = (a + b + 1) / 2;
			if (citations[mid] <= (n - mid)) {
				a = mid;
			} else {
				b = mid - 1;
			}
		}
		if (a == 0 && citations[0] > n) return n;
		return Math.max(citations[a], n - a - 1);
	}
}
