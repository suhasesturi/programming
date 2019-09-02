package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SAMER08F {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		while (n != 0) {
			System.out.println(n * (n + 1) * (2 * n + 1) / 6);
			n = Integer.parseInt(in.readLine());
		}
	}
}
