package interviewbit.BitManipulation;

import java.util.List;

public class SingleNumber {
	public int singleNumber(final List<Integer> list) {
		int xor = 0;
		for (Integer integer : list) {
			xor ^= integer;
		}
		return xor;
	}
}
