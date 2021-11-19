package codeforces.Contest1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A1399 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(arr);

			int current = arr[0];
			boolean flag = true;
			for (int i = 1; i < n; i++) {
				if (arr[i] - current > 1) {
					System.out.println("NO");
					flag = false;
					break;
				}
				current = arr[i];
			}
			if (flag) System.out.println("YES");
		}
	}
}
