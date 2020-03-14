package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
	public ArrayList<Integer> wave(ArrayList<Integer> list) {
		Collections.sort(list);
		for (int i = 1; i < list.size(); i += 2) {
			int temp = list.get(i);
			list.set(i, list.get(i - 1));
			list.set(i - 1, temp);
		}
		return list;
	}
}
