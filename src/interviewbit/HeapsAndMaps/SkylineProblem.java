package interviewbit.HeapsAndMaps;

import java.util.*;

public class SkylineProblem {
	public static void main(String[] args) {
		int[][] buildings = new int[2][3];
		buildings[0][0] = 2;
		buildings[0][1] = 9;
		buildings[0][2] = 10;

		buildings[1][0] = 9;
		buildings[1][1] = 12;
		buildings[1][2] = 15;
		System.out.println(new SkylineProblem().getSkyline(buildings));
	}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		Point[] points = new Point[buildings.length * 2];
		int i = 0;
		for (int[] building : buildings) {
			points[i++] = new Point(building[0], building[2], true);
			points[i++] = new Point(building[1], building[2], false);
		}

	Arrays.sort(points, (a, b) -> {
			if (a.x != b.x) return a.x - b.x;
			if (a.isStart && b.isStart) return b.y - a.y;
			if (!a.isStart && !b.isStart) return a.y - b.y;
			return b.isStart ?  1 : -1;
		});

		List<List<Integer>> result = new ArrayList<>();

		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 1);
		for (Point point : points) {
			if (point.isStart) {
				if (point.y > map.lastKey()) {
					result.add(Arrays.asList(point.x, point.y));
				}
				map.put(point.y, map.getOrDefault(point.y, 0) + 1);
			} else {
				int maxHeight = map.lastKey();
				int height = map.get(point.y);
				if (height == 1) map.remove(point.y);
				else map.put(point.y, height - 1);

				int currentMaxHeight = map.lastKey();
				if (currentMaxHeight < maxHeight) {
					result.add(Arrays.asList(point.x, currentMaxHeight));
				}
			}
		}

		return result;
	}

	static class Point {
		int x, y;
		boolean isStart;

		Point(int x, int y, boolean isStart) {
			this.x = x;
			this.y = y;
			this.isStart = isStart;
		}
	}
}
