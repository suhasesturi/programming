package interviewbit;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        if (A.isEmpty()) return "";

        int index = 0;
        boolean flag = true;
        for (int i = 0; i < A.get(0).length(); i++) {
            char ch = A.get(0).charAt(i);
            for (String a : A) {
                if (a.charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            index++;
        }


        return A.get(0).substring(0, index);
    }
}
