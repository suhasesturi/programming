package interviewbit.Strings;

public class MinimumCharactersStringPalindrome {
    public int solve(String A) {
        String concatenatedString = A + "$" + new StringBuilder(A).reverse().toString();
        int[] prefix = prefixFunction(concatenatedString);
        return A.length() - prefix[prefix.length - 1];
    }

    private int[] prefixFunction(String pattern) {
        int[] prefix = new int[pattern.length()];
        int k = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = prefix[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(i)) {
                k++;
            }
            prefix[i] = k;
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCharactersStringPalindrome().solve("aaaaa"));
        new MinimumCharactersStringPalindrome().prefixFunction("abaabcaba");
    }
}
