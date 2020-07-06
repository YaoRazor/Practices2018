package advanced.chaptertwo.optional;

import java.util.*;

public class TrieService {


    public class TrieNode {
      public NavigableMap<Character, TrieNode> children;
      public List<Integer> top10;
      public TrieNode() {
          children = new TreeMap<Character, TrieNode>();
          top10 = new ArrayList<Integer>();
      }
    }

    private TrieNode root = null;

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and
        // lintcode will print the tree struct.
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++) {
            Character c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                TrieNode node = new TrieNode();
                cur.children.put(c, node);
            }

            cur = cur.children.get(c);
            updateFrequencyList(cur, frequency);
        }

    }

    private void updateFrequencyList(TrieNode node, int frequency) {
        List<Integer> top10 = node.top10;
        top10.add(frequency);
        int n = top10.size();
        int index = n - 1;
        while (index > 0) {
            if (top10.get(index) > top10.get(index - 1)) {
                int temp1 = top10.get(index);
                int temp2 = top10.get(index - 1);
                top10.set(index, temp2);
                top10.set(index - 1, temp1);
                index -= 1;
            } else
                break;
        }
        if (n > 10)
            top10.remove(n - 1);
    }
}
