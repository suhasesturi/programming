package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SALARY {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (String number : s) {
				int temp = Integer.parseInt(number);
				sum += temp;
				min = Math.min(min, temp);
			}
			System.out.println(sum - n * min);
		}
	}
}
