package heap;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2)-> (e1.val-e2.val));
        int right = 0;

        for(int i=0; i<nums.size(); i++) {

            right = Math.max(nums.get(i).get(0), right);

            pq.add(new Element(nums.get(i).get(0), i, 0));

        }

        int left = pq.peek().val;
        int max = right;

        while(!pq.isEmpty()) {
            Element cur = pq.poll();

            if(cur.index==nums.get(cur.row).size()-1) {
                break;
            }

            Element next = new Element(nums.get(cur.row).get(cur.index+1), cur.row, cur.index+1);

            max = Math.max(max, next.val);
            pq.add(next);

            if(max-pq.peek().val<right-left) {
                left = pq.peek().val;
                right = max;
            }

        }

        return new int[]{left, right};

    }

    class Element {

        public int val;
        public int row;
        public int index;

        public Element(int val, int row, int index) {
            this.val = val;
            this.row = row;
            this.index = index;
        }

    }

}
