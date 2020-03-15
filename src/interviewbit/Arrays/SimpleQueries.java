package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SimpleQueries {
	public static void main(String[] args) {
		System.out.println(new SimpleQueries().solve(new ArrayList<>(Arrays.asList(39, 99, 70, 24, 49, 13, 86, 43, 88, 74, 45, 92, 72, 71, 90, 32, 19, 76, 84, 46, 63, 15, 87, 1, 39, 58, 17, 65, 99, 43, 83, 29, 64, 67, 100, 14, 17, 100, 81, 26, 45, 40, 95, 94, 86, 2, 89, 57, 52, 91, 45)),
				new ArrayList<>(Arrays.asList(1221, 360, 459, 651, 958, 584, 345, 181, 536, 116, 1310, 403, 669, 1044, 1281, 711, 222, 280, 1255, 257, 811, 409, 698, 74, 838))));
	}

	static final Integer MOD = (int) (1e9 + 7);

	public ArrayList<Integer> solve(ArrayList<Integer> list, ArrayList<Integer> queries) {
		ArrayList<Integer> products = preComputeDivisorsProduct(list);
		int[] l = new int[list.size()];
		int[] r = new int[list.size()];
		long[] lr = new long[list.size()];
		Arrays.fill(l, 1);
		Arrays.fill(r, 1);

		for (int i = 1; i < list.size(); i++) {
			int last = i - 1;
			while (last >= 0 && list.get(i) > list.get(last)) {
				l[i] += l[last];
				last -= l[last];
			}
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			int last = i + 1;
			while (last < list.size() && list.get(i) >= list.get(last)) {
				r[i] += r[last];
				last += r[last];
			}
		}

		for (int i = 0; i < list.size(); i++) {
			lr[i] = (long) l[i] * r[i];
		}

		long[][] agg = new long[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			agg[i][0] = products.get(i);
			agg[i][1] = lr[i];
		}
		Arrays.sort(agg, (a, b) -> (int) (b[0] - a[0]));

		long[] pre = new long[list.size()];
		pre[0] = agg[0][1];
		for (int i = 1; i < list.size(); i++) {
			pre[i] = pre[i - 1] + agg[i][1];
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (Integer query : queries) {
			int index = binarySearch(pre, query);
			result.add((int) agg[index][0]);
		}
		return result;
	}

	private int binarySearch(long[] list, int x) {
		int a = 0, b = list.length - 1;
		while (a < b) {
			int mid = (a + b) / 2;
			if (list[mid] >= x) {
				b = mid;
			} else {
				a = mid + 1;
			}
		}
		return a;
	}

	private ArrayList<Integer> preComputeDivisorsProduct(ArrayList<Integer> list) {
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> products = new ArrayList<>();

		for (Integer integer : list) {
			for (int j = 1; j <= (int) Math.sqrt(1e5); j++) {
				if (integer % j == 0) {
					set.add(j);
					set.add(integer / j);
				}
			}

			long product = 1;
			for (Integer divisor : set) {
				product = (product * (divisor % MOD)) % MOD;
			}
			products.add((int) (product % MOD));
			set.clear();
		}

		return products;
	}
}
