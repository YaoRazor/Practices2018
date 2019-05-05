package airbnb;

import java.util.*;

public class RoundPrices {

    public List<Integer> getNearlyArrayWithSameSum(double[] arr, int target) {

        List<Integer> ans = new ArrayList<>();
        if(arr==null || arr.length==0) {

            return ans;

        }

        int bottemLine = 0;
        for(double tmp: arr) {
            bottemLine+=Math.floor(tmp);
        }
        int nunberOfIntegersToRoundUp = target-bottemLine;

        // Max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (o1, o2) -> {

                    if(o1.price-Math.floor(o1.price) < o2.price-Math.floor(o2.price)) {
                        return -1;
                    } else if(o1.price-Math.floor(o1.price) > o2.price-Math.floor(o2.price)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
        );

        for(int i=0; i<arr.length; i++) {
            // if the double is integer itself, then we will ignore the input
            if(arr[i]%1==0) {
                continue;
            }

            pq.add(new Pair(i, arr[i]));

            if(pq.size()>nunberOfIntegersToRoundUp) {
                pq.poll();
            }
        }

        Set<Integer> indices = new HashSet<>();

        for(Pair pair: pq) {
            indices.add(pair.index);
        }

        for(int i=0; i<arr.length; i++) {

            if(indices.contains(i)) {
                ans.add((int)Math.ceil(arr[i]));
            } else {
                ans.add((int)Math.floor(arr[i]));
            }

        }

        return ans;
    }

    class Pair {

        int index;
        double price;

         Pair(int index, double price) {
            this.index = index;
            this.price = price;
        }

    }

}
