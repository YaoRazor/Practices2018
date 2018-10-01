package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList== null || wordList.size()==0 || !wordList.contains(endWord)) {
            return 0;
        }

        // This sentence actually is very important, which significantly improves the performance
        Set<String> wordDict = new HashSet<>(wordList);

        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int cnt = 0;


        while (!deque.isEmpty()) {
            cnt++;

            int queueSize = deque.size();

            for(int k = 0; k < queueSize; k++) {

                String cur = deque.pollFirst();


                for(int i=0; i<beginWord.length(); i++) {

                    for(int j=0; j<26; j++) {

                        String newWord = changeOneLetter(cur, i, j);

                        if(visited.contains(newWord) || !wordDict.contains(newWord)) {
                            continue;
                        } else {

                            if(newWord.equals(endWord)) {
                                return cnt+1;
                            }

                            visited.add(newWord);
                            deque.addLast(newWord);
                        }

                    }

                }

            }

        }

        return 0;

    }


    private String changeOneLetter(String beginWord, int pos, int offSet) {

        StringBuilder sb = new StringBuilder(beginWord);

        sb.setCharAt(pos, (char)('a'+offSet));

        return sb.toString();


    }

}
