package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This is a classic problem for DFS and Trie, need to practice a lot!
public class WordSearchTwo {
    int[][] dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        Set<String> set = new HashSet<>();

        boolean[][] isVisited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                search(String.valueOf(board[i][j]), board, isVisited, trie.root, set, i, j);
            }
        }

        return new ArrayList<>(set);
    }


    private void search(String word, char[][] board, boolean[][] isVisited, TrieNode root, Set<String> set, int i, int j) {
        char c = board[i][j];
        if(root.children[c-'a']==null) {
            return;
        }

        root = root.children[c-'a'];
        if(root.isWord) {
            set.add(word);
        }

        int m = board.length;
        int n = board[0].length;
        isVisited[i][j] = true;

        for(int[] dir: dirs) {
            int newX = i+dir[0];
            int newY = j+dir[1];
            if(newX<0 || newX>=m || newY<0 || newY>=n || isVisited[newX][newY]) {
                continue;
            }
            search(word+board[newX][newY], board, isVisited, root, set, newX, newY);
        }
        isVisited[i][j] = false;
    }

    class TrieNode {
        public char c;
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;

        public TrieNode(char c) {
            this.c = c;
        }
    }

    class Trie {
        public TrieNode root;

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
    }
}
