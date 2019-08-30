package interviewbit;

public class AmazingSubArrays {
    public int solve(String A) {
        int n = A.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' ||
                    ch == 'u' || ch == 'U') {
                result = (result + n - i) % 10003;
            }
        }

        return result;
    }
}

