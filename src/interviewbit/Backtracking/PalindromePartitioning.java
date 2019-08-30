package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;

public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        helper(result, new LinkedList<>(), 0, a);
        return result;
    }

    private void helper(ArrayList<ArrayList<String>> result, LinkedList<String> currentPartition,
                        int index, String input) {

        if (index == input.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = index; i < input.length(); i++) {
            if (isPalindrome(input, index, i)) {
                currentPartition.addLast(input.substring(index, i + 1));
                helper(result, currentPartition, i + 1, input);
                currentPartition.removeLast();
            }
        }
    }

    private boolean isPalindrome(String input, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) return false;
        }
        return true;
    }
}
