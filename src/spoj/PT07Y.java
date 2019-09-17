package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PT07Y {
	private static int[] parent = new int[10010];
	private static int[] rank = new int[10010];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		for (int i = 0; i < n; i++) parent[i] = i;

		for (int i = 0; i < m; i++) {
			s = in.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			if (find(a) != find(b)) {
				union(a, b);
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static int find(int a) {
		if (a != parent[a]) {
			parent[a] = find(parent[a]);
		}
		return parent[a];
	}

	private static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if (rank[a] >= rank[b]) {
			parent[b] = a;
			if (rank[a] == rank[b]) {
				rank[a] += 1;
			}
		} else {
			parent[a] = b;
		}
	}
}
