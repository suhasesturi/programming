package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class KS1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			int[] list = new int[n];
			for (int i = 0; i < n; i++) {
				list[i] = Integer.parseInt(s[i]);
			}

			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		}
	}
}
