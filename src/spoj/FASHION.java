package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class FASHION {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int[] men = new int[n];
			int[] women = new int[n];

			String[] s = in.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				men[i] = Integer.parseInt(s[i]);
			}

			s = in.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				women[i] = Integer.parseInt(s[i]);
			}

			Arrays.sort(men);
			Arrays.sort(women);

			int result = 0;
			for (int i = 0; i < n; i++) {
				result += men[i] * women[i];
			}

			System.out.println(result);
		}
	}
}
