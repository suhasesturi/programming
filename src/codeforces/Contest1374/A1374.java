package codeforces.Contest1374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1374 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			String[] s = in.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int n = Integer.parseInt(s[2]);
			int multiplier = n / x;
			for (int i = multiplier; i >= 0; i--) {
				if (x * i + y <= n) {
					System.out.println(x * i + y);
					break;
				}
			}
		}
	}
}
