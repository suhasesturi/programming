package interviewbit.Greedy;

import java.util.List;

public class GasStation {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        if (gas.size() < 2) return 0;

        int start = 0;
        int end = 1;
        int available = gas.get(start) - cost.get(start);

        while (start != end || available < 0) {
            while (start != end && available < 0) {
                available += cost.get(start) - gas.get(start);
                start = (start + 1) % gas.size();

                if (start == 0) return -1;
            }

            available += gas.get(end) - cost.get(end);
            end = (end + 1) % gas.size();
        }

        return start;
    }
}
