package codeforces.SegmentTree.Step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SegmentTreeProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		ArrayList<Integer> arr = new ArrayList<>();
		s = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(s[i]));
		}
		PrintWriter out = new PrintWriter(System.out);
//		SegmentTree segTree = new SegmentTree(arr);
//
//		while (m-- > 0) {
//			s = in.readLine().split(" ");
//			int i = Integer.parseInt(s[0]);
//			int v = Integer.parseInt(s[1]);
//
//			if (i == 1) {
//				segTree.flipValue(v);
//			} else {
//				out.println(segTree.calc(v));
//			}

//			out.println(segTree.calc(0, segTree.size).max);
	}
//		out.flush();
}

class SegmentTree<K, V> {
	public int size;
	private final ArrayList<V> values;
	private final V NEUTRAL_ELEMENT;
	private final BiFunction<V, V, V> operation;
	private final Function<K, V> baseElement;

	public SegmentTree(ArrayList<K> init,
					   V neutralElement,
					   BiFunction<V, V, V> operation,
					   Function<K, V> baseElement) {
		size = 1;
		while (size < init.size()) {
			size <<= 1;
		}

		this.NEUTRAL_ELEMENT = neutralElement;
		this.operation = operation;
		this.values = new ArrayList<>(2 * size);
		this.baseElement = baseElement;

		for (int i = 0; i < 2 * size; i++) {
			values.add(NEUTRAL_ELEMENT);
		}
		buildTree(init, 0, 0, size);
	}

	private void buildTree(ArrayList<K> init, int x, int lx, int rx) {
		if (rx - lx == 1) {
			if (lx < init.size()) {
				values.set(x, baseElement.apply(init.get(lx)));
			}
		} else {
			int mid = (lx + rx) / 2;
			buildTree(init, 2 * x + 1, lx, mid);
			buildTree(init, 2 * x + 2, mid, rx);
			values.set(x, operation.apply(values.get(2 * x + 1), values.get(2 * x + 2)));
		}
	}

	public void set(int i, K key) {
		set(i, baseElement.apply(key), 0, 0, size);
	}

	private void set(int i, V value, int x, int lx, int rx) {
		if (rx - lx == 1) {
			values.set(x, value);
		} else {
			int mid = (lx + rx) / 2;
			if (i < mid) set(i, value, 2 * x + 1, lx, mid);
			else set(i, value, 2 * x + 2, mid, rx);
			values.set(x, operation.apply(values.get(2 * x + 1), values.get(2 * x + 2)));
		}
	}

	public V calc(int l, int r) {
		return calc(l, r, 0, 0, size);
	}

	private V calc(int l, int r, int x, int lx, int rx) {
		if (lx >= r || l >= rx) return NEUTRAL_ELEMENT;
		if (lx >= l && rx <= r) return values.get(x);
		int mid = (lx + rx) / 2;
		V left = calc(l, r, 2 * x + 1, lx, mid);
		V right = calc(l, r, 2 * x + 2, mid, rx);
		return operation.apply(left, right);
	}
}
