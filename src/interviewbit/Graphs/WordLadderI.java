package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderI {
    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        HashSet<String> visited = new HashSet<>(dictV);

        if (start.equals(end)) return 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 1));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (String word : dictV) {
                if (!visited.contains(word)) {
                    if (isValid(current.word, word)) {
                        Node temp = new Node(word, current.distance + 1);
                        queue.add(temp);
                        visited.add(word);

                        if (word.equals(end)) return temp.distance;
                    }
                }
            }
        }

        return 0;
    }

    private boolean isValid(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }

    static class Node {
        int distance;
        String word;

        Node(String s, int d) {
            distance = d;
            word = s;
        }
    }
}
