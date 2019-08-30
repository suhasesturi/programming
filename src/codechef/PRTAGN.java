package codechef;

import util.CustomReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PRTAGN {
	public static void main(String[] args) throws IOException {
		CustomReader in = new CustomReader(System.in);

		int t = in.nextInt();
		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		while (t-- > 0) {
			int q = in.nextInt();

			int even = 0, odd = 0;
			set.clear();
			while (q-- > 0) {
				int x = in.nextInt();
				if (set.contains(x)) {
					System.out.println(even + " " + odd);
					continue;
				}

				list.clear();
				for (int s : set) {
					list.add(x ^ s);
				}
				even = odd = 0;

				set.addAll(list);
				set.add(x);

				for (int s : set) {
					if (Integer.bitCount(s) % 2 == 0) {
						even++;
					} else {
						odd++;
					}
				}

				System.out.println(even + " " + odd);
			}
		}
	}
}
