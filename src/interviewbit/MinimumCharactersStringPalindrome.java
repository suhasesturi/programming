package interviewbit;

public class MinimumCharactersStringPalindrome {
    public int solve(String A) {
        String concatenatedString = A + "$" + reverse(A);
        int[] prefix = prefixFunction(concatenatedString);
        return A.length() - prefix[prefix.length - 1];
    }

    private String reverse(String str) {
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }

    private int[] prefixFunction(String str) {
        int n = str.length();
        int k = 0;
        int[] prefix = new int[n];

        for (int q = 1; q < n; q++) {
            while (k > 0 && str.charAt(q) != str.charAt(k)) {
                k = prefix[k - 1];
            }
            if (str.charAt(q) == str.charAt(k)) {
                k++;
            }
            prefix[q] = k;
        }

        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCharactersStringPalindrome().solve("aaaaa"));
        new MinimumCharactersStringPalindrome().prefixFunction("abaabcaba");
    }
}
