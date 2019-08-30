package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D1191 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		String[] s = in.readLine().split(" ");
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(s[i]);
		}

		Arrays.sort(p);

		boolean first = true;

		while (true) {
//			if ()
		}
	}
}
