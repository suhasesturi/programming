package spoj;

import util.CustomReader;

import java.io.IOException;
import java.util.Arrays;

public class JNEXT {
	public static void main(String[] args) throws IOException {
		CustomReader in = new CustomReader(System.in);
		int t = in.nextInt();

		StringBuilder builder = new StringBuilder();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] numbers = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = in.nextInt();
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

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
