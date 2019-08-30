package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class AllUniquePermutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(0, A, result);
        return result;
    }

    private void helper(int index, ArrayList<Integer> input, ArrayList<ArrayList<Integer>> result) {
        if (index == input.size() - 1) {
            result.add(new ArrayList<>(input));
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < input.size(); i++) {
            if (set.contains(input.get(i))) {
                continue;
            }
            set.add(input.get(i));

            swap(input, i, index);
            helper(index + 1, input, result);
            swap(input, i, index);
        }
    }

    private void swap(ArrayList<Integer> input, int a, int b) {
        int temp = input.get(a);
        input.set(a, input.get(b));
        input.set(b, temp);
    }
}
