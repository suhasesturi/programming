package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class HotelReviews {
    public static void main(String[] args) {
        System.out.println(new HotelReviews().solve("cool_ice_wifi",
                new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))));
    }

    public ArrayList<Integer> solve(String goodWords, ArrayList<String> reviews) {
        TrieNode root = new TrieNode('$');
        for (String word : goodWords.split("_")) {
            root.addWord(word);
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>((a, b) -> b - a);
        for (int i = 0; i < reviews.size(); i++) {
            int count = 0;
            for (String word : reviews.get(i).split("_")) {
                if (root.isPresent(word)) {
                    count++;
                }
            }
            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer goodness : map.keySet()) {
            result.addAll(map.get(goodness));
        }
        return result;
    }
}
