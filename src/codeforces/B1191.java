package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1191 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");

		Arrays.sort(s, Comparator.comparingInt(a -> a.charAt(0)));

		int[] numbers = new int[3];
		numbers[0] = (int) s[0].charAt(0);
		numbers[1] = (int) s[1].charAt(0);
		numbers[2] = (int) s[2].charAt(0);

		char[] chars = new char[3];
		chars[0] = s[0].charAt(1);
		chars[1] = s[1].charAt(1);
		chars[2] = s[2].charAt(1);

		if (s[0].equals(s[1]) && s[1].equals(s[2])) {
			System.out.println(0);
		} else if (chars[1] != chars[2] && chars[1] != chars[0] && chars[2] != chars[0]) {
			System.out.println(2);
		} else if (chars[0] == chars[1] && chars[1] == chars[2]) {
			if ((Math.abs(numbers[0] - numbers[1]) == 1 && Math.abs(numbers[1] - numbers[2]) == 1) ||
					(numbers[0] == numbers[1] && numbers[1] == numbers[2])) {
				System.out.println(0);
			} else if ((Math.abs(numbers[0] - numbers[1]) == 1 || Math.abs(numbers[1] - numbers[2]) == 1 || Math.abs(numbers[0] - numbers[2]) == 1) ||
					(numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[2] == numbers[0])) {
				System.out.println(1);
			} else if (numbers[0] == numbers[1] - 2 || numbers[1] == numbers[2] - 2) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		} else if (chars[0] == chars[1] || chars[1] == chars[2] || chars[0] == chars[2]) {
			if (chars[0] == chars[1]) {
				if (numbers[0] == numbers[1] || Math.abs(numbers[0] - numbers[1]) == 1 ||
						Math.abs(numbers[0] - numbers[1]) == 2) {
					System.out.println(1);
				} else {
					System.out.println(2);
				}
			} else if (chars[1] == chars[2]) {
				if (numbers[1] == numbers[2] || Math.abs(numbers[1] - numbers[2]) == 1 ||
						Math.abs(numbers[1] - numbers[2]) == 2) {
					System.out.println(1);
				} else {
					System.out.println(2);
				}
			} else {
				if (numbers[0] == numbers[2] || Math.abs(numbers[0] - numbers[2]) == 1 ||
						Math.abs(numbers[0] - numbers[2]) == 2) {
					System.out.println(1);
				} else {
					System.out.println(2);
				}
			}
		} else {
			System.out.println(2);
		}
	}
}
