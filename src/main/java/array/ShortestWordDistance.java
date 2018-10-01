package array;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {

        int index1=0;
        int index2=0;

        for(int i=0; i<words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
            } else if(words[i].equals(word2)) {
                index2 = i;
            }

        }

        return Math.abs(index1-index2);
    }
}
