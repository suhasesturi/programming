package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D281 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		String[] s = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		int result = maxXor(arr);
		for (int i = 0, j = n - 1; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		System.out.println(Math.max(result, maxXor(arr)));
	}

	private static int maxXor(int[] arr) {
		Stack<Integer> list = new Stack<>();
		int result = arr[0] ^ arr[1];
		for (int value : arr) {
			while (!list.isEmpty() && list.peek() < value) list.pop();
			if (!list.empty()) {
				result = Math.max(result, list.peek() ^ value);
			}
			list.push(value);
		}
		return result;
	}
}
