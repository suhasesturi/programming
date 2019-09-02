package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FCTRL {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int count = 0;
			int powerOf5 = 5;
			while (powerOf5 <= n) {
				count += n / powerOf5;
				powerOf5 *= 5;
			}
			System.out.println(count);
		}
	}
}
