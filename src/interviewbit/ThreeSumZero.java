package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 0;
        int j = i + 1;
        int k = A.size() - 1;
        while (i < A.size() - 3) {
            int ai = A.get(i);
            if (ai > 0) break;

            if (i == 0 || ai != A.get(i - 1)) {
                while (j < k) {
                    int aj = A.get(j);
                    if (j > i + 1 && aj == A.get(j - 1)) {
                        j++;
                        continue;
                    }
                    if (k < A.size() - 1 && A.get(k).equals(A.get(k + 1))) {
                        k--;
                        continue;
                    }
                    int sum = ai + aj + A.get(k);
                    if (sum == 0) {
                        result.add(new ArrayList<>(Arrays.asList(ai, aj, A.get(k))));
                        j++;
                        k--;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }

            i++;
            j = i + 1;
            k = A.size() - 1;
        }
        return result;
    }
}


