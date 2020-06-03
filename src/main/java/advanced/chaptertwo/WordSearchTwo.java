package advanced.chaptertwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This is a classic problem for DFS and Trie, need to practice a lot!
public class WordSearchTwo {

    public class Trie {

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode(' ');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;

            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(cur.children[c-'a']==null) {
                    cur.children[c-'a'] = new TrieNode(c);
                }
                cur = cur.children[c-'a'];
            }

            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode ans =   searchNode(word);
            return ans!=null && ans.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchNode(prefix)!=null;
        }

        private TrieNode searchNode(String word) {
            TrieNode cur = root;

            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(cur.children[c-'a']==null) {
                    return null;
                }
                cur = cur.children[c-'a'];
            }

            return cur;
        }

        class TrieNode {
            public char c;
            public TrieNode[] children = new TrieNode[26];
            public boolean isWord = false;

            public TrieNode(char c) {
                this.c = c;
            }
        }
    }

    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        Set<String> ans = new HashSet<>();

        if(board==null || board.length==0 || words==null || words.size()==0) {
            return new ArrayList<>();
        }

        int n = board.length;
        int m = board[0].length;

        Trie trie = new Trie();

        boolean[][] visited = new boolean[n][m];

        Set<String> set = new HashSet<>(words);

        for(String word: set) {
            trie.insert(word);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dfs(ans, board, visited, "", trie.root, i, j);
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfs(Set<String> ans, char[][] board, boolean[][] visited, String cur, Trie.TrieNode node, int i, int j) {
        if(node.children[board[i][j]-'a']==null) {
            return;
        }

        visited[i][j] = true;

        node = node.children[board[i][j]-'a'];

        cur = cur+board[i][j];

        if(node.isWord) {
            ans.add(cur);
        }

        for(int[] dir: dirs) {
            int x = i+dir[0];
            int y = j+dir[1];

            if(x<0 || x>=board.length || y<0 || y>=board[0].length || visited[x][y]) {
                continue;
            }

            dfs(ans, board, visited, cur, node, x, y);
        }

        visited[i][j] = false;
    }
}
