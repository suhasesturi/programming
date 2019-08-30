package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1191 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(in.readLine());

		if (x % 4 == 0) {
			System.out.println("1 A");
		} else if (x % 4 == 1) {
			System.out.println("0 A");
		} else if (x % 4 == 2) {
			System.out.println("1 B");
		} else if (x % 4 == 3) {
			System.out.println("2 A");
		}
	}
}
