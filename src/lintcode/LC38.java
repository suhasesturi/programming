package lintcode;

public class LC38 {
    public int searchMatrix(int[][] matrix, int target) {
        int result = 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        for (int row = 0, column = m - 1; row < n && column >= 0;) {
            if (matrix[row][column] == target) {
                result++;
                row++;
                column--;
                continue;
            }
            if (matrix[row][column] > target)
                column--;
            else
                row++;
        }
        return result;
    }
}
