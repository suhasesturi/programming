package interviewbit.Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestUniquePrefix {
    public ArrayList<String> prefix(ArrayList<String> words) {
        TrieNode root = new TrieNode('$');
        ArrayList<String> result = new ArrayList<>();

        buildTrie(words, root);

        for (String word : words) {
            TrieNode current = root;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                current = current.children.get(key);
                builder.append(key);
                if (current.count == 1) break;
            }
            result.add(builder.toString());
        }
        return result;
    }

    private void buildTrie(ArrayList<String> words, TrieNode root) {
        for (String word : words) {
            addToTrie(root, word);
        }
    }

    private void addToTrie(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            HashMap<Character, TrieNode> children = root.children;
            if (children.containsKey(key)) {
                children.get(key).count++;
            } else {
                children.put(key, new TrieNode(key));
            }
            root = children.get(key);
        }
    }
}

class TrieNode {
    char ch;
    int count;
    HashMap<Character, TrieNode> children;

    TrieNode(char ch) {
        this.ch = ch;
        count = 1;
        children = new HashMap<>();
    }
}