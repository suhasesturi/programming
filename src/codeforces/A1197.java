package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class A1197 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			ArrayList<Integer> list = new ArrayList<>();
			for (String x : s) {
				int temp = Integer.parseInt(x);
				if (temp >= 1)
					list.add(Integer.parseInt(x));
			}

			Collections.sort(list);

			n = list.size();
			int low = 0, high = n - 2;

			while (low < high) {
				int k = (low + high + 1) / 2;
				int count = 0;
				boolean flag = false;
				for (int i = k; i < n; i++) {
					if (list.get(i) > k) {
						count++;
					}
					if (count >= 2) {
						flag = true;
						break;
					}
				}
				if (flag) {
					low = k;
				} else {
					high = k - 1;
				}
			}

			System.out.println(low);
		}
	}
}
