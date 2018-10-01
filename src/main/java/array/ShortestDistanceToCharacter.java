package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestDistanceToCharacter {

    public int[] shortestToChar(String S, char C) {

        int n = S.length();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0-S.length()-1);

        int[] ans = new int[n];

        for(int i=0; i<S.length();i++) {
            if(C==S.charAt(i)) {
                deque.addLast(i);
            }
        }

        deque.addLast(2*S.length()+1);
        int pre = deque.pollFirst();

        while(!deque.isEmpty()) {
            int cur = deque.pollFirst();

            for(int i=pre<0? 0: pre+1; i<cur && i<n; i++)  {

                ans[i] = Math.min(i-pre, cur-i);
            }

            pre = cur;

        }

        return ans;

    }

}
