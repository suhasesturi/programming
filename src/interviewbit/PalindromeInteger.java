package interviewbit;

public class PalindromeInteger {
    public int isPalindrome(int A) {
        int temp = A;
        if (A < 0) return 0;
        long reverse = 0;
        while (A != 0) {
            reverse = reverse * 10 + (A % 10);
            A /= 10;
        }
        return temp == ((int) reverse) ? 1 : 0;
    }
}
