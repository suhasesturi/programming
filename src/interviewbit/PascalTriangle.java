package interviewbit;

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= A; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int n = result.size() - 1;
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) temp.add(1);
                else temp.add(result.get(n).get(j - 1) + result.get(n).get(j - 2));
            }
            result.add(temp);
        }
        return result;
    }
}
