package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobelInteger {
	public static void main(String[] args) {
		System.out.println(new NobelInteger().solve(new ArrayList<>(Arrays.asList(-4, -2, 0, -1, -6))));
	}

	public int solve(ArrayList<Integer> list) {
		Collections.sort(list);
		int n = list.size();
		for (int i = 0; i < n;) {
			while ((i + 1) < n && list.get(i).equals(list.get(i + 1))) i++;
			if (list.get(i) == (n - i - 1)) return 1;
			i++;
		}
		return -1;
	}
}
