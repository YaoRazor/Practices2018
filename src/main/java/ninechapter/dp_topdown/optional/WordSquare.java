package ninechapter.dp_topdown.optional;

import java.util.*;

public class WordSquare {
//    public List<List<String>> wordSquares(String[] words) {
//        List<List<String>> ans = new ArrayList<>();
//        if(words==null || words.length==0) {
//            return ans;
//        }
//
//        LinkedList<String> cur = new LinkedList<>();
//
//        dfs(ans, 0, words, cur);
//        return ans;
//    }
//
//
//    private void dfs(List<List<String>> ans, int level, String[] words, LinkedList<String> cur) {
//        if(level==words[0].length()) {
//            ans.add(new LinkedList<>(cur));
//            return;
//        }
//
//        for(int i=0; i<words.length; i++) {
//            if(isValid(cur, words[i])) {
//                cur.add(words[i]);
//                dfs(ans, level+1, words, cur);
//                cur.removeLast();
//            }
//        }
//    }
//
//    private boolean isValid(LinkedList<String> cur, String tmp) {
//        int n = cur.size();
//        if(n==0) {
//            return true;
//        }
//
//        for(int i=0; i<n; i++) {
//            char c = tmp.charAt(i);
//            if(c!=cur.get(i).charAt(n)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//
    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;

        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode(' ');
        }

        /*
         * @param word: a word
         * @return: nothing
         */
        public void insert(String word) {
            if(word==null || word.length()==0) {
                return;
            }

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

        private TrieNode searchNode(String word) {
            if(word==null || word.length()==0) {
                return null;
            }

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

        /*
         * @param word: A string
         * @return: if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchNode(word);
            return node!=null && node.isWord;
        }

        /*
         * @param prefix: A string
         * @return: if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchNode(prefix)!=null;
        }
    }


    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if(words==null || words.length==0) {
            return ans;
        }

        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }

        int n = words[0].length();

        Set<String> visited = new HashSet<>();
        LinkedList<String> cur = new LinkedList<>();
        dfs(ans, cur, trie, n, words, visited);
        return ans;
    }


    private void dfs(List<List<String>> ans, LinkedList<String> cur, Trie trie, int n, String[] words, Set<String> visited) {
        if(cur.size()==n) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=0; i<words.length; i++) {
            String tmp = words[i];
            if(!isQualified(cur, trie, tmp, visited, n)) {
                continue;
            }

            visited.add(tmp);
            cur.add(tmp);
            dfs(ans, cur, trie, n, words, visited);
            visited.remove(tmp);
            cur.removeLast();
        }

    }

    //[["baba","abat","baba","atal"],["baba","abat","baba","atan"]]

    public static void main(String[] args) {
        String[] input = {"abat","baba","atan","atal"};

        WordSquare square = new WordSquare();

        List<List<String>> ans = square.wordSquares(input);
        System.out.println(Arrays.toString(ans.toArray()));
    }


    private boolean isQualified(LinkedList<String> cur, Trie trie, String tmp, Set<String> visited, int n) {

        System.out.println("----------------");
        System.out.println(Arrays.toString(cur.toArray()));
        System.out.println("tmp is "+tmp);


        if(visited.contains(tmp)) {
            System.out.println(" returning false for visited");
            System.out.println("----------------");
            return false;
        }

        if(cur.size()==0) {
            return true;
        }


        String preFixs = "";
        int k = cur.size();

        for(String temp: cur) {
            preFixs += temp.charAt(k);
        }

        if(!tmp.startsWith(preFixs)) {
            System.out.println(" returning false for new tmp not qualified");
            System.out.println("----------------");
            return false;
        }

        k++;
        if(k==n) {
            return true;
        }

        preFixs = "";

        for(String temp: cur) {
            preFixs += temp.charAt(k);
        }

        preFixs+=tmp.charAt(k);


        if(!trie.startsWith(preFixs)) {
            System.out.println("returning false for not possible. Prefix is "+preFixs);
            System.out.println("----------------");
            return false;
        } else {
            System.out.println("----------------");
            return true;
        }

    }
}
