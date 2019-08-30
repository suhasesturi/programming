package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JNEXT {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		StringBuilder builder = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			byte[] numbers = new byte[n];
			for (int i = 0; i < s.length; i++) {
				numbers[i] = Byte.parseByte(s[i]);
			}

			int index = -1;
			for (int i = n - 1; i > 0; i--) {
				if (numbers[i] > numbers[i - 1]) {
					index = i - 1;
					break;
				}
			}

			if (index == -1) {
				builder.append("-1\n");
				continue;
			}

			for (int i = n - 1; i > index; i--) {
				if (numbers[i] > numbers[index]) {
					swap(numbers, i, index);
					break;
				}
			}

			Arrays.sort(numbers, index + 1, n);

			for (int i = 0; i < n; i++) {
				builder.append(numbers[i]);
			}
			builder.append("\n");
		}

		System.out.println(builder);
	}

	private static void swap(byte[] numbers, int i, int j) {
		byte temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
