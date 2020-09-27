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
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode cur) {
        if(index==word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(index);
        if('.'==c) {
            for(TrieNode node: cur.children) {
                if(node!=null && search(word, index+1, node)) {
                    return true;
                }
            }

            return false;
        } else {
            if(cur.children[c-'a']==null) {
                return false;
            } else {
                return search(word, index+1, cur.children[c-'a']);
            }
        }
    }
}
