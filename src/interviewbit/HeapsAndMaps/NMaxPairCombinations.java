package interviewbit.HeapsAndMaps;

import java.util.*;

public class NMaxPairCombinations {
	public static void main(String[] args) {
		System.out.println(new NMaxPairCombinations().solve(
				new ArrayList<>(Arrays.asList(3, 2, 4, 2)),
				new ArrayList<>(Arrays.asList(4, 3, 1, 2))));
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<>();
		A.sort((a, b) -> b - a);
		B.sort((a, b) -> b - a);

		PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>((a, b) -> b.sum - a.sum);
		HashSet<Tuple> set = new HashSet<>();
		priorityQueue.add(new Tuple(0, 0, A.get(0) + B.get(0)));
		set.add(priorityQueue.peek());

		int n = A.size();
		for (int i = 0; i < n && !priorityQueue.isEmpty(); i++) {
			Tuple top = priorityQueue.poll();
			result.add(top.sum);

			Tuple temp;
			if (top.i + 1 < n) {
				temp = new Tuple(top.i + 1, top.j, A.get(top.i + 1) + B.get(top.j));
				if (!set.contains(temp)) {
					set.add(temp);
					priorityQueue.add(temp);
				}
			}

			if (top.j + 1 < n) {
				temp = new Tuple(top.i, top.j + 1, A.get(top.i) + B.get(top.j + 1));
				if (!set.contains(temp)) {
					set.add(temp);
					priorityQueue.add(temp);
				}
			}
		}
		return result;
	}

	private static class Tuple {
		int i, j, sum;

		Tuple(int a, int b, int c) {
			i = a;
			j = b;
			sum = c;
		}

		@Override
		public int hashCode() {
			return Objects.hash(i, j);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Tuple) {
				Tuple tuple = (Tuple) obj;
				return this.i == tuple.i && this.j == tuple.j;
			}
			return false;
		}
	}
}
