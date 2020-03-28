package interviewbit.BinarySearch;

import java.util.ArrayList;

public class MatrixSearch {
	public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
		int low = 0, high = A.size() - 1;
		while (low < high) {
			int mid = (low + high + 1) / 2;
			if (A.get(mid).get(0) <= B) low = mid;
			else high = mid - 1;
		}

		int index = low;
		low = 0;
		high = A.get(index).size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (A.get(index).get(mid) == B) return 1;
			if (A.get(index).get(mid) < B) low = mid + 1;
			else high = mid - 1;
		}
		return 0;
	}
}
