package advanced.chaptertwo;

public class WordDictionary {
    class TrieNode {
        char c;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode(char c) {
            this.c = c;
        }
    }

    private boolean searchNode(String word, int index, TrieNode cur) {
        if(index==word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(index);

        if(c=='.') {
            for(int i=0; i<26; i++) {
                if(cur.children[i]!=null && searchNode(word, index+1, cur.children[i])) {
                    return true;
                }
            }

            return false;
        } else {
            if(cur.children[c-'a']==null) {
                return false;
            } else {
                return searchNode(word, index+1, cur.children[c-'a']);
            }
        }
    }

    private TrieNode root = new TrieNode(' ');

    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
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

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        return searchNode(word, 0, root);
    }
}
