package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LECANDY {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			String[] s = in.readLine().split(" ");
			int c = Integer.parseInt(s[1]);
			s = in.readLine().split(" ");
			int count = 0;
			for (String value : s) {
				count += Integer.parseInt(value);
			}
			System.out.println(count <= c ? "Yes" : "No");
		}
	}
}
