package interviewbit;

import java.util.ArrayList;

public class NumbersOfLengthNAndValueLessThanK {
    public int solve(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> digits = new ArrayList<>();
        String c = String.valueOf(C);
        for (int i = 0; i < c.length(); i++) digits.add(c.charAt(i) - '0');

        if (B > digits.size()) return 0;
        if (B < digits.size()) {
            if (A.contains(0) && B > 1) {
                return (A.size() - 1) * ((int) Math.pow(A.size(), B - 1));
            }
            return (int) Math.pow(A.size(), B);
        }

        return calculate(A, digits, 0, B);
    }

    public int calculate(ArrayList<Integer> A, ArrayList<Integer> digits, int index, int B) {
        if (index == B) return 0;
        int lessthan = 0;
        for (Integer a : A) {
            if (a < digits.get(index)) {
                lessthan++;
                if (a == 0 && B > 1 && index == 0) {
                    lessthan--;
                }
            }
        }

        int result = 0;
        result = lessthan * ((int) Math.pow(A.size(), B - index - 1));
        if (A.contains(digits.get(index))) {
            result += calculate(A, digits, index + 1, B);
        }

        return result;
    }
}
