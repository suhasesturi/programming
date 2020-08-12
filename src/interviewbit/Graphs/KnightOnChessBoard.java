package interviewbit.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class KnightOnChessBoard {
	public int knight(int rows, int columns, int x1, int y1, int x2, int y2) {
		HashSet<Position> visited = new HashSet<>();
		int[] rowOffsets = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] colOffsets = {1, 2, 2, 1, -1, -2, -2, -1};

		Queue<Position> queue = new LinkedList<>();
		Position start = new Position(x1, y1);
		start.d = 0;
		queue.add(start);
		visited.add(start);

		while (!queue.isEmpty()) {
			Position u = queue.poll();
			if (u.x == x2 && u.y == y2) {
				return u.d;
			}
			for (int i = 0; i < rowOffsets.length; i++) {
				Position v = new Position(u.x + rowOffsets[i], u.y + colOffsets[i]);
				if (isSafe(rows, columns, v.x, v.y) && !visited.contains(v)) {
					v.d = u.d + 1;
					visited.add(v);
					queue.add(v);
				}
			}
		}
		return -1;
	}

	private boolean isSafe(int rows, int columns, int x, int y) {
		return x >= 1 && y >= 1 && x <= rows && y <= columns;
	}

	static class Position {
		int x, y, d;

		Position(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Position) {
				Position that = (Position) obj;
				return that.x == this.x && that.y == this.y;
			} else {
				return false;
			}
		}
	}
}
