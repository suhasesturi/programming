package interviewbit.Backtracking;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(result, A, 0);
        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> input, int index) {
        if (index == input.size() - 1) {
            result.add(new ArrayList<>(input));
            return;
        }

        for (int i = index; i < input.size(); i++) {
            swap(input, i, index);
            helper(result, input, index + 1);
            swap(input, i, index);
        }
    }
}

