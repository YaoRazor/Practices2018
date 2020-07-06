package advanced.chapterone.optional;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInNArrays {

    class Element {
        int arrayIndex;
        int index;
        Element(final int arrayIndex, final int index) {
            this.arrayIndex = arrayIndex;
            this.index = index;
        }
    }

    //TC: O(Σnilogni+klogm), ni is the length of ith array, m is the length of arrays
    public int KthInArrays(int[][] arrays, int k) {
        for(int[] array: arrays) {
            Arrays.sort(array);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2)-> (arrays[e2.arrayIndex][e2.index]-arrays[e1.arrayIndex][e1.index]));

        for(int i=0; i<arrays.length; i++) {
            if(arrays[i]==null || arrays[i].length==0) {
                continue;
            }

            pq.offer(new Element(i, arrays[i].length-1));
        }

        while(pq.size()>0) {
            k--;
            Element e = pq.poll();
            if(k==0) {
                return arrays[e.arrayIndex][e.index];
            }

            if(e.index>=1) {
                pq.offer(new Element(e.arrayIndex, e.index-1));
            }
        }

        // throwException
        return Integer.MIN_VALUE;
    }
}
