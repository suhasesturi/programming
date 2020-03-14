package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1312 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder builder = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(s[i]));
			}

			list.sort((a, b) -> b - a);
			for (Integer a : list) {
				builder.append(a).append(" ");
			}
			builder.append("\n");
		}
		System.out.println(builder);
	}
}
