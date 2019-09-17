package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class WILLITST {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());

		HashSet<Long> set = new HashSet<>();
		while (n > 1) {
			if (set.contains(n)) {
				System.out.println("NIE");
				return;
			} else {
				set.add(n);
			}
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 3;
			}
		}
		System.out.println("TAK");
	}
}
