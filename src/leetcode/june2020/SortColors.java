package leetcode.june2020;


public class SortColors {
	public void sortColors(int[] nums) {
		int first = 0, last = nums.length - 1;
		for (int i = 0; i <= last; ) {
			if (nums[i] == 0) {
				nums[i] = nums[first];
				nums[first] = 0;
				first++;
			} else if (nums[i] == 2) {
				nums[i] = nums[last];
				nums[last] = 2;
				last--;
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 0};
		new SortColors().sortColors(a);
		for (int value : a) {
			System.out.println(value);
		}
	}
}
