package lintcode;

public class LC75 {
    public int findPeak(int[] A) {
        int a = 0, b = A.length - 1;
        while (a <= b) {
            int mid = (a + b + 1) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid - 1]) {
                b = mid - 1;
            } else
                a = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC75 obj = new LC75();
        int[] a = {1, 2, 1, 2, 3, 1};
        System.out.println(obj.findPeak(a));
    }
}
