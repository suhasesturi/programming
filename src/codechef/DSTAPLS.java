package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DSTAPLS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			String[] s = in.readLine().split(" ");
			long n = Long.parseLong(s[0]);
			long k = Long.parseLong(s[1]);

			System.out.println((n / k) % k == 0 ? "NO" : "YES");
		}
	}
}
