package lintcode;

import java.util.Arrays;

public class LC52 {
    public int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            return nums;
        }
        for (int i = n - 1; i > index; i--) {
            if (nums[index] < nums[i]) {
                swap(nums, i, index);
                break;
            }
        }
        for (int i = index + 1, j = n - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
