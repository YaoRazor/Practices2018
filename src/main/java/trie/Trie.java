package trie;

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


