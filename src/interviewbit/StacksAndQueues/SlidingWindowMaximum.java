package interviewbit.StacksAndQueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        LinkedList<Integer> window = new LinkedList<>();

        int i;
        for (i = 0; i < B; i++) {
            while (!window.isEmpty() && A.get(i) >= A.get(window.peekLast()))
                window.pollLast();
            window.addLast(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (; i < A.size(); i++) {
            result.add(A.get(window.peekFirst()));

            while (!window.isEmpty() && window.peekFirst() <= i - B)
                window.pollFirst();

            while (!window.isEmpty() && A.get(i) >= A.get(window.peekLast()))
                window.pollLast();

            window.addLast(i);
        }

        result.add(window.peekFirst());
        return result;
    }
}



