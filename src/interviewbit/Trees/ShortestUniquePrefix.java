package interviewbit.Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestUniquePrefix {
    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode root = new TrieNode('0');
        for (String word : A) root.addWord(word);

        ArrayList<String> result = new ArrayList<>();
        for (String word : A) {
            TrieNode current = root;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                current = current.children.get(ch);
                builder.append(ch);
                if (current.count == 1) {
                    break;
                }
            }
            result.add(builder.toString());
        }
        return result;
    }
}

class TrieNode {
    char val;
    HashMap<Character, TrieNode> children;
    int count;
    boolean endsHere;

    TrieNode(char val) {
        this.val = val;
        this.count = 0;
        this.children = new HashMap<>();
        this.endsHere = false;
    }

    public void addWord(String word) {
        TrieNode root = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!root.children.containsKey(ch)) {
                root.children.put(ch, new TrieNode(ch));
            }
            root = root.children.get(ch);
            root.count++;
        }
        root.endsHere = true;
    }

    public boolean isPresent(String word) {
        TrieNode root = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (root.children.containsKey(ch)) {
                root = root.children.get(ch);
            } else {
                return false;
            }
        }
        return root.endsHere;
    }
}
