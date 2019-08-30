package interviewbit;

public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int result = 0;
        int powerOf26 = 1;
        for (int i = A.length() - 1; i >= 0; i--) {
            int ch =A.charAt(i) - 'A' + 1;
            result += powerOf26 * ch;
            powerOf26 *= 26;
        }
        return result;
    }
}
