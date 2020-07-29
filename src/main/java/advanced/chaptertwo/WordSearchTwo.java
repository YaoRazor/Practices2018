package advanced.chaptertwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This is a classic problem for DFS and Trie, need to practice a lot!
public class WordSearchTwo {

    class TrieNode {
        char c;
        TrieNode[] children;
        String word;
        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }
    }

    private TrieNode root = new TrieNode(' ');

    private void insert(String s) {
        if(s==null || s.length()==0) {
            return;
        }

        TrieNode cur = root;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(cur.children[c-'a']==null) {
                cur.children[c-'a'] = new TrieNode(c);
            }

            cur = cur.children[c-'a'];
        }

        cur.word = s;
    }


    public List<String> findWords(char[][] board, String[] words) {
        if(board==null || board.length==0 || board[0]==null || board[0].length==0 || words==null || words.length==0) {
            return new ArrayList<>();
        }

        for(String word: words) {
            insert(word);
        }

        Set<String> set = new HashSet<>();
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, root, set, visited);
            }
        }

        return new ArrayList<>(set);
    }

    private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // 本题递归的定义是找出从二维矩阵上某点开始符合特定的TrieNode为根节点的所有String的组合
    private void dfs(char[][] board, int i, int j, TrieNode cur, Set<String> set, boolean[][] visited) {
        if(cur.children[board[i][j]-'a']==null) {
            return;
        }

        visited[i][j] = true;
        cur = cur.children[board[i][j]-'a'];
        if(cur.word!=null) {
            set.add(cur.word);
        }

        for(int[] dir: dirs) {
            int x = i+dir[0];
            int y = j+dir[1];

            if(x<0 || x==board.length || y<0 || y==board[0].length || visited[x][y]) {
                continue;
            }

            dfs(board, x, y, cur, set, visited);
        }

        visited[i][j] = false;
    }
}
