package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1374 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(in.readLine());
			int count = 0;
			while (n != 1) {
				if (n % 6 == 0) {
					n /= 6;
					count++;
				} else if (n % 3 == 0) {
					n *= 2;
					count++;
				} else {
					break;
				}
			}
			System.out.println(n == 1 ? count : -1);
		}
	}
}
