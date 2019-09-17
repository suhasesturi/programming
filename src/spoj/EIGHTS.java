package spoj;

		import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;

public class EIGHTS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			long k = Long.parseLong(in.readLine());
			System.out.println((192 + (250) * (k - 1)));
		}
	}
}
