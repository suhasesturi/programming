package interviewbit;

public class LongestPalindromicSubString {

    public String longestPalindrome(String A) {
        String result = "";
        for (int i = 0; i < A.length(); i++) {
            String temp = subString(A, i, i);
            if (temp.length() > result.length()) {
                result = temp;
            }

            temp = subString(A, i, i + 1);
            if (temp.length() > result.length()) {
                result = temp;
            }
        }

        return result;
    }

    private String subString(String A, int a, int b) {
        int i, j;
        for (i = a, j = b; i >= 0 && j < A.length(); i--, j++) {
            if (A.charAt(i) != A.charAt(j))
                break;
        }

        return A.substring(i + 1, j);
    }
}

