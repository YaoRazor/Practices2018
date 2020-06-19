package advanced.chaptersix;

import java.util.ArrayList;
import java.util.List;

public class KEditDistance {

    class TrieNode {
        String str;
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public TrieNode getRoot() {
            return this.root;
        }

        /*
         * @param word: a word
         * @return: nothing
         */
        public void insert(String word) {
            if(word==null) {
                return;
            }

            TrieNode cur = root;

            for(int i=0; i<word.length(); i++) {
                if(cur.children[word.charAt(i)-'a']==null) {
                    cur.children[word.charAt(i)-'a'] = new TrieNode();
                }

                cur = cur.children[word.charAt(i)-'a'];
            }

            cur.isWord = true;
            cur.str = word;
        }

    }

    /**
     * @param words: a set of stirngs
     * @param target: a target string
     * @param k: An integer
     * @return: output all the strings that meet the requirements
     */
    private int K;

    private void dfs(List<String> ans, TrieNode p, int[] f, String target, int n) {
        if(p.isWord && f[n]<=K) {
            ans.add(p.str);
        }

        for(int i=0; i<26; i++) {

            if(p.children[i]==null) {
                continue;
            }

            int[] nf = new int[n+1];

            for(int j=0; j<=n; j++) {
                nf[j] = f[j]+1;   // delete
            }

            // replace
            for(int j=1; j<=n; j++) {
                char c = (char)('a'+i);
                if(c==target.charAt(j-1)) {
                    nf[j] = Math.min(f[j-1], nf[j]);
                } else {
                    nf[j] = Math.min(nf[j], f[j-1]+1);
                }

            }

            for(int j=1; j<=n; j++) {
                // insert
                nf[j] = Math.min(nf[j-1]+1, nf[j]);
            }

            dfs(ans, p.children[i], nf, target, n);
        }

    }

    public List<String> kDistance(String[] words, String target, int k) {
        List<String> ans = new ArrayList<>();
        if(words==null || words.length==0) {
            return ans;
        }

        Trie trie = new Trie();

        for(String word: words) {
            trie.insert(word);
        }

        int n = target.length();
        K = k;

        int[] f = new int[n+1];
        for(int i=0; i<=n; i++) {
            f[i] = i;
        }

        dfs(ans, trie.getRoot(), f, target, n);

        return ans;
    }
}
