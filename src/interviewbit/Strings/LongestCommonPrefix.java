package interviewbit.Strings;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> list) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.get(0).length(); i++) {
            char ch = list.get(0).charAt(i);
            boolean flag = true;
            for (String s : list) {
                if (s.length() <= i || s.charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.append(ch);
        }
        return result.toString();
    }
}
