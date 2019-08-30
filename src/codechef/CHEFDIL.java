package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFDIL {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			String s = in.readLine();
			int count = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '1') {
					count++;
				}
			}
			System.out.println(count % 2 == 0 ? "LOST" : "WIN");
		}
	}
}
