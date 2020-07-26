package interviewbit.Greedy;

import java.util.List;

public class GasStation {
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
		if (gas.isEmpty()) return 0;
		int start = 0, end = 1;
		int available = gas.get(start) - cost.get(start);
		if (gas.size() == 1)
			return available >= 0 ? 0 : -1;

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
