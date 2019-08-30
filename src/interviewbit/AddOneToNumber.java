package interviewbit;

import java.util.ArrayList;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int counter = 1;
        int index = 0;

        while(index < A.size() && A.get(index) == 0) index++;

        for (int i = A.size() - 1; i >= index; i--) {
            if (A.get(i) == 9) {
                result.add(0);
            } else {
                result.add(A.get(i) + counter);
                counter = 0;
            }
        }

        if (counter == 1) result.add(1);

        for (int i = 0, j = result.size() - 1; i < j; i++, j--) {
            int temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
        }

        return result;
    }
}

