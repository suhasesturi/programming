import java.util.*;

public class Sample {
	public static void main(String[] args) {
		Queue<int[]> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Random random = new Random();
		int[] sum = new int[10];
		for (int i = 0; i < 100; i++) {
			sum[(int) (Math.random() * 10)]++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(sum[i] + " ");
		}
		System.out.println();

	}
}

class Pair implements Comparable<Pair> {
	int x;

	@Override
	public int compareTo(Pair o) {
		return 0;
	}
}
