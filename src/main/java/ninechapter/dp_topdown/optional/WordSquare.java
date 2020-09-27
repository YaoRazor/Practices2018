package ninechapter.dp_topdown.optional;

import java.util.*;

// 最坏情况时间复杂度是O(N^L*L)，但是用了Trie之后，因为剪枝，时间复杂度会远小于这个理论最大值
// N是总共word的数量，L是每一个word的长度. 后面乘以L是因为每次recursion需要花这么久
public class WordSquare {

    class TrieNode {
        char c;
        List<String> words;
        TrieNode[] children;
        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
            words = new ArrayList<>();
        }
    }

    TrieNode root = new TrieNode(' ');

    private void insert(String s) {
        TrieNode cur = root;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(cur.children[c-'a']==null) {
                cur.children[c-'a'] = new TrieNode(c);
            }
            cur = cur.children[c-'a'];
            cur.words.add(s);
        }
    }

    private List<String> search(String s) {
        TrieNode cur = root;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(cur.children[c-'a']==null) {
                return new ArrayList<>();
            }
            cur = cur.children[c-'a'];
        }

        return cur.words;
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if(words==null || words.length==0) {
            return ans;
        }

        for(String word: words) {
            insert(word);
        }

        LinkedList<String> cur = new LinkedList<>();
        int n = words[0].length();

        for(String word: words) {
            cur.add(word);
            dfs(ans, cur, n);
            cur.removeLast();
        }

        return ans;
    }

    // 这一题和wordsearch还是有一点区别，那就是prefix是每次dfs的时候临时assemble的，
    // 和之前的path没有关系，word search中，prefix是和DFS一起增长的
    private void dfs(List<List<String>> ans, LinkedList<String> cur, int n) {
        if(cur.size()==n) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        StringBuilder prefix = new StringBuilder();
        int k = cur.size();
        for(int i=0; i<k; i++) {
            prefix.append(cur.get(i).charAt(k));
        }

        List<String> words = search(prefix.toString());

        for(String word: words) {
            // backtrack
            cur.add(word);
            dfs(ans, cur, n);
            cur.removeLast();
        }
    }

}
