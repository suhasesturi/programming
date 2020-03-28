package interviewbit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMedian {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
		matrix.add(new ArrayList<>(Arrays.asList(2, 6, 9)));
		matrix.add(new ArrayList<>(Arrays.asList(3, 6, 9)));
		System.out.println(new MatrixMedian().findMedian(matrix));
	}

	public int findMedian(ArrayList<ArrayList<Integer>> matrix) {
		int n = matrix.size();
		int m = matrix.get(0).size();
		int min = matrix.get(0).get(0), max = matrix.get(0).get(0);

		for (ArrayList<Integer> integers : matrix) {
			min = Math.min(min, integers.get(0));
			max = Math.max(max, integers.get(m - 1));
		}

		while (min < max) {
			int mid = (min + max) / 2;
			int count = 0;
			for (ArrayList<Integer> list : matrix) {
				count += binarySearch(list, mid);
			}
			if (count >= ((n * m + 1) / 2)) max = mid;
			else min = mid + 1;
		}

		return max;
	}

	private int binarySearch(ArrayList<Integer> list, int x) {
		int a = 0, b = list.size() - 1;
		while (a < b) {
			int mid = (a + b + 1) / 2;
			if (list.get(mid) > x) {
				b = mid - 1;
			} else if (list.get(mid) <= x) {
				a = mid;
			}
		}
		return list.get(a) <= x ? a + 1 : 0;
	}
}
