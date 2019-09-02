package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADDREV {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		while (n-- > 0) {
			String[] s = in.readLine().split(" ");
			int first = Integer.parseInt(s[0]);
			int second = Integer.parseInt(s[1]);

			System.out.println(reverse(reverse(first) + reverse(second)));
		}
	}

	private static int reverse(int n) {
		int reverse = 0;
		while (n != 0) {
			int modulo = n % 10;
			reverse = reverse * 10 + modulo;
			n /= 10;
		}
		return reverse;
	}
}
