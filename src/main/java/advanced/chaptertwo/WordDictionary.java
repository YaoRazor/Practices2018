package advanced.chaptertwo;

public class WordDictionary {
    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;
        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root, 0);
    }

    public boolean search(String word, TrieNode cur, int index) {
        if(index==word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(index);
        if(c!='.') {
            if(cur.children[c-'a']==null) {
                return false;
            } else {
                cur = cur.children[c-'a'];
                return search(word, cur, index+1);
            }
        } else {
            for(TrieNode next: cur.children) {
                if(next==null) {
                    continue;
                }
                if(search(word, next, index+1)) {
                    return true;
                }
            }

            return false;
        }
    }
}
