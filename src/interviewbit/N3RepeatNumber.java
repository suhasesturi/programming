package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N3RepeatNumber {
    public int repeatedNumber(final List<Integer> a) {
        int[] count = new int[2];
        int[] numbers = new int[2];
        Arrays.fill(numbers, Integer.MAX_VALUE);

        for (int number : a) {
            boolean flag = false;
            for (int i = 0; i < 2; i++) {
                if (numbers[i] == number) {
                    count[i]++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int i = 0; i < 2; i++) {
                    if (count[i] == 0) {
                        numbers[i] = number;
                        count[i]++;
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                count[0]--;
                count[1]--;
            }
        }

        Arrays.fill(count, 0);
        for (int number : a) {
            if (numbers[0] == number) count[0]++;
            else if (numbers[1] == number) count[1]++;
        }

        if (count[0] > a.size() / 3) return numbers[0];
        if (count[1] > a.size() / 3) return numbers[1];
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(2);
        a.add(4);
        System.out.println(new N3RepeatNumber().repeatedNumber(a));
    }
}
