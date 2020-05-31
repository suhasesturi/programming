package interviewbit.TwoPointers;

import java.util.ArrayList;

public class RemoveElementFromArray {
	public int removeElement(ArrayList<Integer> a, int b) {
		int position = 0;
		for (int i = 0; i < a.size(); i++) {
			if (!a.get(i).equals(b)) {
				a.set(position++, a.get(i));
			}
		}
		return position;
	}
}
