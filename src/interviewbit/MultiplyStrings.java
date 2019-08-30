package interviewbit;


public class MultiplyStrings {
    public String multiply(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) return "0";

        int n = a.length(), m = b.length();
        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int num1 = a.charAt(i) - '0';
            int carry = 0;
            int index = 0;
            for (int j = m - 1; j >= 0; j--) {
                int num2 = b.charAt(j) - '0';
                index = m - j - 1 + n - i - 1;
                int sum = num1 * num2 + carry + result[index];
                result[index] = sum % 10;
                carry = sum / 10;
            }

            if (carry > 0) {
                result[++index] += carry;
            }
        }

        int index = result.length - 1;
        while (index >= 0 && result[index] == 0) index--;

        StringBuilder builder = new StringBuilder();
        if (index < 0) return "0";
        for (int i = index; i >= 0; i--) builder.append(result[i]);
        return builder.toString();
    }
}
