package lintcode;

public class LC65 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) return findMedianSortedArrays(B, A);
        int first = 0, last = m;
        while (first <= last) {
            int i = (first + last) / 2;
            int j = (m + n + 1) / 2 - i;
            if ((i == 0 || j == n || A[i - 1] <= B[j]) &&
                    (j == 0 || i == m || B[j - 1] <= A[i])) {
                int maxLeft;
                if (i == 0) maxLeft = B[j - 1];
                else if (j == 0) maxLeft = A[i - 1];
                else maxLeft = Math.max(A[i - 1], B[j - 1]);

                if ((m + n) % 2 != 0) return maxLeft;

                int minRight;
                if (i == m) minRight = B[j];
                else if (j == n) minRight = A[i];
                else minRight = Math.min(A[i], B[j]);

                return (maxLeft + minRight) / 2.0;

            } else if (i > 0 && j < n && A[i - 1] > B[j]) {
                last = i - 1;
            } else if (j > 0 && i < m && B[j - 1] > A[i]) {
                first = i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LC65 obj = new LC65();
        int[] a = {};
        int[] b = {1};
        System.out.println(obj.findMedianSortedArrays(a, b));
    }
}
