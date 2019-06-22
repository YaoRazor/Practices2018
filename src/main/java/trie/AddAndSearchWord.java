package trie;

public class AddAndSearchWord {

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, root);
    }
    TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    public boolean search(String word, TrieNode root) {
        if(word.length()==0) {
            return root!=null && root.isWord;
        }

        if(root==null) {
            return false;
        }

        TrieNode cur = root;

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            if('.'==c) {
                for(int j=0; j<26; j++) {
                    if(search(word.substring(i+1), cur.children[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                if(cur.children[c-'a']==null) {
                    return false;
                }
                cur = cur.children[c-'a'];
            }
        }
        return cur.isWord;

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



