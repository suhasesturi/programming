package interviewbit.HeapsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LRUCache {
	private final int capacity;
	private final HashMap<Integer, Item> keyMap;
	private final TreeMap<Integer, Item> timeMap;
	private int time;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.time = 0;
		keyMap = new HashMap<>();
		timeMap = new TreeMap<>();
	}

	public int get(int key) {
		if (!keyMap.containsKey(key)) return -1;

		this.time++;
		Item item = keyMap.get(key);
		updateTime(item.time, time);
		item.time = time;
		return item.value;
	}

	private void updateTime(int oldTime, int time) {
		Item item = timeMap.get(oldTime);
		timeMap.remove(oldTime);
		item.time = time;
		timeMap.put(time, item);
	}

	public void set(int key, int value) {
		this.time++;
		if (keyMap.containsKey(key)) {
			Item item = keyMap.get(key);
			updateTime(item.time, time);
			item.value = value;
			item.time = time;
		} else {
			if (keyMap.size() == capacity) {
				Map.Entry<Integer, Item> firstEntry = timeMap.firstEntry();
				timeMap.remove(firstEntry.getKey());
				keyMap.remove(firstEntry.getValue().key);
			}

			Item item = new Item(time, key, value);
			keyMap.put(key, item);
			timeMap.put(time, item);
		}
	}

	private static class Item {
		int time;
		int key;
		int value;

		Item(int time, int key, int value) {
			this.time = time;
			this.key = key;
			this.value = value;
		}
	}
}
