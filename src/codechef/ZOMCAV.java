package codechef;

import util.CustomReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ZOMCAV {
	private static int[] c = new int[100010];
	private static int[] h = new int[100010];
	private static ArrayList<Integer> start = new ArrayList<>();
	private static ArrayList<Integer> end = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		CustomReader in = new CustomReader(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			start.clear();
			end.clear();

			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				c[i] = in.nextInt();
				start.add(Math.max(i - c[i], 0));
				end.add(Math.min(i + c[i], n - 1));
			}
			Collections.sort(start);
			Collections.sort(end);
			int count = 0;
			int index = 0;
			int decreaseBy = 0;
			for (int i = 0, j = 0; index < n; ) {
				while ((i < start.size() && start.get(i) <= index) || (j < end.size() && end.get(j) <= index)) {
					if (i < start.size() && j < end.size()) {
						if (start.get(i) <= end.get(j) && start.get(i) <= index) {
							count++;
							i++;
						} else if (start.get(i) > end.get(j) && end.get(j) <= index) {
							decreaseBy++;
							j++;
						}
					} else if (j < end.size() && end.get(j) <= index) {
						decreaseBy++;
						j++;
					} else if (i < end.size() && start.get(i) < +index) {
						count++;
						i++;
					}
				}
				c[index++] = count;
				count -= decreaseBy;
				decreaseBy = 0;
			}

			for (int i = 0; i < n; i++) {
				h[i] = in.nextInt();
			}

			Arrays.sort(c, 0, n);
			Arrays.sort(h, 0, n);

			boolean flag = true;
			for (int i = 0; i < n; i++) {
				if (c[i] != h[i]) {
					flag = false;
					break;
				}
			}

			System.out.println(flag ? "YES" : "NO");
		}
	}
}
