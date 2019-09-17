package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HANGOVER {
	private static ArrayList<Double> dp = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		solve();

		while (true) {
			double length = Double.parseDouble(in.readLine());
			if (length == 0) break;
			for (int i = 0; i < dp.size(); i++) {
				if (dp.get(i) > length) {
					System.out.println(i + 1 + " card(s)");
					break;
				}
			}
		}
	}

	private static void solve() {
		double current = 0.5;
		int i = 2;
		while (current < 5.20) {
			dp.add(current);
			i++;
			current += 1.0 / i;
		}
	}
}
