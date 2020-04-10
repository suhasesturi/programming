package codejam.Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ESAbATAd {
	public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] s = in.readLine().split(" ");
		int t = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		while (t-- > 0) {
			int samePair = -1, differentPair = -1;
			int[] bits = new int[b + 1];
			int q = 0;
			for (int i = 1; i <= b / 2; i++) {
				if (q % 10 == 0 && q > 1) {
					if (samePair != -1 && differentPair != -1) {
						int newSValue = query(samePair);
						int newDValue = query(differentPair);

						if (newSValue != bits[samePair] && newDValue != bits[differentPair]) {
							complement(bits, i);
						} else if (newSValue != bits[samePair] && newDValue == bits[differentPair]) {
							complement(bits, i);
							reversal(bits, i);
						} else if (newSValue == bits[samePair] && newDValue != bits[differentPair]) {
							reversal(bits, i);
						}
					} else {
						if (differentPair != -1) {
							int newValue = query(differentPair);
							if (newValue != bits[differentPair]) reversal(bits, i);
							query(differentPair);
						} else {
							int newValue = query(samePair);
							if (newValue != bits[samePair]) complement(bits, i);
							query(samePair);
						}
					}
					q += 2;
				}

				bits[i] = query(i);
				bits[b - i + 1] = query(b - i + 1);
				q += 2;

				if (samePair == -1 && bits[i] == bits[b - i + 1]) {
					samePair = i;
				} else if (differentPair == -1 && bits[i] != bits[b - i + 1]) {
					differentPair = i;
				}
			}

			StringBuilder builder = new StringBuilder();
			for (int i = 1; i <= b; i++) builder.append(bits[i]);
			System.out.println(builder);
			if ("N".equals(in.readLine())) {
				return;
			}
		}
	}

	private static int query(int a) throws IOException {
		System.out.println(a);
		return Integer.parseInt(in.readLine());
	}

	private static void reversal(int[] bits, int n) {
		for (int i = 1, j = bits.length - 1; i < n; i++, j--) {
			swap(bits, i, j);
		}
	}

	private static void complement(int[] bits, int n) {
		for (int i = 1, j = bits.length - 1; i < n; i++, j--) {
			bits[i] = bits[i] == 1 ? 0 : 1;
			bits[j] = bits[j] == 1 ? 0 : 1;
		}
	}

	private static void swap(int[] bits, int j, int k) {
		int temp = bits[j];
		bits[j] = bits[k];
		bits[k] = temp;
	}
}
