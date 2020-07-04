package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class PointsOnAStraightLine {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		HashMap<Pair, Integer> slopes = new HashMap<>();
		int result = 0;
		for (int i = 0; i < a.size(); i++) {
			int same = 0, currentMax = 0, vertical = 0;
			for (int j = i + 1; j < a.size(); j++) {
				long yDiff = b.get(j) - b.get(i);
				long xDiff = a.get(j) - a.get(i);

				if (xDiff == 0 && yDiff == 0) {
					same++;
				} else if (xDiff == 0) {
					vertical++;
				} else {
					long commonDivisor = gcd(xDiff, yDiff);
					xDiff /= commonDivisor;
					yDiff /= commonDivisor;

					if ((xDiff < 0 && yDiff < 0) || (xDiff >= 0 && yDiff < 0)) {
						xDiff = -xDiff;
						yDiff = -yDiff;
					}

					Pair pair = new Pair(xDiff, yDiff);
					slopes.put(pair, slopes.getOrDefault(pair, 0) + 1);
					currentMax = Math.max(currentMax, slopes.get(pair));
				}
				currentMax = Math.max(currentMax, vertical);
			}
			result = Math.max(result, 1 + same + currentMax);
			slopes.clear();
		}
		return result;
	}

	private long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	static class Pair {
		long x, y;

		Pair(long a, long b) {
			x = a;
			y = b;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pair) {
				Pair pair = (Pair) obj;
				return this.x == pair.x && this.y == pair.y;
			}
			return false;
		}
	}
}
