package trie;

public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        if(word==null || word.length()==0) {
            return;
        }

        TrieNode cur = root;

        for(int i=0; i<word.length(); i++) {

            if(!cur.containsKey(word.charAt(i))) {
                cur.putNode(word.charAt(i));
            }

            cur = cur.getNode(word.charAt(i));

        }

        cur.setEnd();

    }

    private TrieNode searchNode(String word) {

        TrieNode cur= root;

        for(int i=0; i<word.length(); i++) {

            char key = word.charAt(i);

            if(cur.containsKey(key)) {
                cur = cur.getNode(key);
            } else {
                return null;
            }

        }

        return cur;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null || word.length()==0) {
            return false;
        }

        TrieNode node = searchNode(word);
        return node!=null && node.getEnd();

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null || prefix.length()==0) {
            return false;
        }

        TrieNode node = searchNode(prefix);
        return node!=null;
    }
}


class TrieNode {

    private TrieNode[] children;

    private static final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        children = new TrieNode[R];
    }


    public boolean containsKey(char key) {
        return children[key-'a']!=null;
    }

    public void putNode(char key) {

        if(!containsKey(key)) {
            children[key-'a'] = new TrieNode();
        }

    }


    public TrieNode getNode(char key) {

        if(containsKey(key)) {
            return children[key-'a'];
        } else {
            return null;
        }
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }

}
