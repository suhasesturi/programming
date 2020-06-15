package leetcode.june2020;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int a = 0, b = nums.length - 1;
		while (a < b) {
			int mid = (a + b) / 2;
			if (nums[mid] == target) return mid;
			if (nums[mid] < target) a = mid + 1;
			else b = mid;
		}

		return nums[a] < target ? a + 1 : a;
	}
}
