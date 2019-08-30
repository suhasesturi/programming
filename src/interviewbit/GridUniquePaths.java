package interviewbit;

public class GridUniquePaths {
    public int uniquePaths(int A, int B) {
        int paths = 1;
        for (int i = A; i <= A + B - 2; i++) {
            paths = paths * i;
            paths /= i - A + 1;
        }

        return paths;
    }
}
