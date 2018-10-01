package trie;

public class AddAndSearchWord {

    private TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void addWord(String word) {

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

    public boolean search(String word) {
        return search(word, root);
    }


    private boolean search(String word, TrieNode cur) {

        if(cur==null) {
            return false;
        }

        if(word==null || word.length()==0) {
            return cur.isEnd;
        }

        for(int i=0; i<word.length(); i++) {

            char key = word.charAt(i);

            if(key=='.') {
                for(TrieNode trieNode: cur.children) {
                    if(search(word.substring(i+1), trieNode)) {
                        return true;
                    }
                }

                return false;
            } else {
                if(cur.containsKey(key)) {
                    cur = cur.getNode(key);
                } else {
                    return false;
                }
            }

        }

        return cur.isEnd;

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
}



