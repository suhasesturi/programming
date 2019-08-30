package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class MMAX {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int k = new BigInteger(in.readLine()).mod(BigInteger.valueOf(n)).intValue();

			int result = Math.min(k, n - k) * 2;
			System.out.println(k == n - k ? result - 1 : result);
		}
	}
}
