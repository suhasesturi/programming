package interviewbit.HeapsAndMaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LRUCache {
	private final int capacity;
	private final HashMap<Integer, Pair> map;
	private final PriorityQueue<Pair> timings;
	private int time;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.time = 0;
		map = new HashMap<>();
		timings = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			this.time++;
			map.get(key).time = this.time;
			timings.add(new Pair(this.time, key));
			return map.get(key).value;
		}
		return -1;
	}

	public void set(int key, int value) {
		this.time++;
		map.put(key, new Pair(this.time, value));
		timings.add(new Pair(this.time, key));

		if (map.size() > capacity) {
			remove();
		}
	}

	private void remove() {
		Pair top = timings.poll();
		if (map.get(top.value).time > top.time) {
			remove();
		} else {
			map.remove(top.value);
		}
	}

	private static class Pair {
		int time;
		int value;

		Pair(int time, int value) {
			this.time = time;
			this.value = value;
		}
	}
}
