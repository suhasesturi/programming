package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class E1374 {
	private static final ArrayList<Integer> a = new ArrayList<>();
	private static final ArrayList<Integer> b = new ArrayList<>();
	private static final ArrayList<Integer> both = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		var s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);

		for (int i = 0; i < n; i++) {
			s = in.readLine().split(" ");
			int value = Integer.parseInt(s[0]);
			int first = Integer.parseInt(s[1]);
			int second = Integer.parseInt(s[2]);
			if (first == 1 && second == 1) both.add(value);
			else if (first == 1) a.add(value);
			else if (second == 1) b.add(value);
		}

		Collections.sort(a);
		Collections.sort(b);
		Collections.sort(both);

		System.out.println(solve(k));
	}

	private static long solve(int k) {
		long time = 0, count = 0;
		int aIndex = 0, bothIndex = 0;
		while (true) {
			if (aIndex < a.size() && aIndex < b.size() && bothIndex < both.size()) {
				if (a.get(aIndex) + b.get(aIndex) <= both.get(bothIndex)) {
					time += a.get(aIndex) + b.get(aIndex);
					aIndex++;
				} else {
					time += both.get(bothIndex);
					bothIndex++;
				}
			} else if (aIndex < a.size() && aIndex < b.size()) {
				time += a.get(aIndex) + b.get(aIndex);
				aIndex++;
			} else if (bothIndex < both.size()) {
				time += both.get(bothIndex);
				bothIndex++;
			} else if (count < k) {
				return -1;
			}
			count++;
			if (count == k) {
				return time;
			}
		}
	}
}
