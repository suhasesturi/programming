package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MSNSADM1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			String[] y = in.readLine().split(" ");
			int[] points = new int[n];
			int max = 0;
			for (int i = 0; i < s.length; i++) {
				points[i] = Math.max(0, Integer.parseInt(s[i]) * 20 - 10 * Integer.parseInt(y[i]));
				max = Math.max(max, points[i]);
			}
			System.out.println(max);
		}
	}
}
