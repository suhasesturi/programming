package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C1197 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]) - 1;

		s = in.readLine().split(" ");
		Integer[] diff = new Integer[n - 1];

		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(s[i]);
			if (i != 0) {
				diff[i - 1] = list[i] - list[i - 1];
			}
		}

		Arrays.sort(diff, (o1, o2) -> o2 - o1);

		int result = list[n - 1] - list[0];
		for (int i = 0; i < k; i++) {
			result -= diff[i];
		}

		System.out.println(result);
	}
}
