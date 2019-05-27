package miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class FindTheCelebrity {

    public int findCelebrityOptimal(int n) {

        int candidate = 0;
        for(int i=1; i<n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }

        for(int i=0; i<n; i++) {

            if(i!=candidate) {
                if(knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }

            }
        }

        return candidate;
    }

    // Your own algorithm
    public int findCelebrity(int n) {

        Set<Integer> nonCelebrity = new HashSet<>();
        Set<Integer> potentialCelebrity = new HashSet<>();
        for(int i=0; i<n; i++) {
            potentialCelebrity.add(i);
        }


        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) {
                    continue;
                }
                if(nonCelebrity.contains(i) || knows(i, j)) {
                    potentialCelebrity.remove(i);
                }

                if(!knows(j, i)) {
                    potentialCelebrity.remove(i);
                }
            }
        }

        for(Integer i: potentialCelebrity) {
            return i;
        }

        return -1;

    }

    boolean knows(int a, int b) {
      return true;
    }
}
