package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class C1325 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		ArrayList<HashMap<Integer, Integer>> tree = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			tree.add(new HashMap<>());
		}

		int[][] input = new int[n - 1][2];
		for (int i = 0; i < n - 1; i++) {
			String[] s = in.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			input[i][0] = a - 1;
			input[i][1] = b - 1;
			tree.get(a - 1).put(b - 1, -1);
			tree.get(b - 1).put(a - 1, -1);
		}

		if (n == 2) {
			System.out.println(0);
			return;
		}

		int count = 0;
		for (HashMap<Integer, Integer> integerIntegerHashMap : tree) {
			if (integerIntegerHashMap.size() == 1) {
				for (Map.Entry<Integer, Integer> entry : integerIntegerHashMap.entrySet()) {
					entry.setValue(count++);
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int[] ints : input) {
			Integer label1 = tree.get(ints[0]).get(ints[1]);
			Integer label2 = tree.get(ints[1]).get(ints[0]);
			builder.append((label1 == -1 && label2 == -1) ? count++ : Math.max(label1, label2)).append("\n");
		}
		System.out.println(builder);
	}
}
