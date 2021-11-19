package codeforces.Contest1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class D1399 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		PrintWriter out = new PrintWriter(System.out);
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			char[] s = in.readLine().toCharArray();
			int count = 0;
			Queue<Integer> zero = new LinkedList<>();
			Queue<Integer> one = new LinkedList<>();
			ArrayList<Integer> positions = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (s[i] == '0') {
					if (!one.isEmpty()) {
						positions.add(one.peek());
						zero.add(one.poll());
					} else {
						positions.add(++count);
						zero.add(count);
					}
				} else {
					if (!zero.isEmpty()) {
						positions.add(zero.peek());
						one.add(zero.poll());
					} else {
						positions.add(++count);
						one.add(count);
					}
				}
			}
			out.println(zero.size() + one.size());
			for (int i = 0; i < positions.size(); i++) {
				out.print(positions.get(i) + " ");
			}
			out.println();
		}
		out.close();
	}
}
