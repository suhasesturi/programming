package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        ArrayList<String> result = new ArrayList<>();
        util(A, result, "", new HashSet<>(B));
        return result;
    }

    private void util(String str, ArrayList<String> result, String current, Set<String> dict) {
        for (int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == str.length()) {
                    result.add(current + prefix);
                    break;
                }
                util(str.substring(i), result, current + prefix + " ", dict);
            }
        }
    }
}
