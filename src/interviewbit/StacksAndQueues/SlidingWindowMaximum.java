package interviewbit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> queue = new LinkedList<>();
        int i;
        for (i = 0; i < B; i++) {
            while (!queue.isEmpty() && A.get(i) >= A.get(queue.peekLast())) {
                queue.pollLast();
            }
            queue.addLast(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (!queue.isEmpty()) {
            result.add(A.get(queue.peekFirst()));
        }

        for (; i < A.size(); i++) {
            while (!queue.isEmpty() && queue.peekFirst() <= (i - B)) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && A.get(i) >= A.get(queue.peekLast())) {
                queue.pollLast();
            }
            queue.addLast(i);
            result.add(A.get(queue.peekFirst()));
        }

        return result;
    }
}
