package array;

public class PourOfWater {
    public int[] pourWater(int[] heights, int V, int K) {

        if(heights==null || heights.length==0 || V==0) {
            return heights;
        }


        while (V>0) {

            int index = K;


            for(int i=K-1; i>=0; i--) {

                if(heights[i]<heights[index]) {
                    index = i;
                } else if(heights[i]>heights[index]){
                    break;
                }

            }

            if(index!=K) {
                heights[index]++;
                V--;
                continue;
            }


            for(int i=K+1; i<heights.length; i++) {

                if(heights[i]<heights[index]) {
                    index = i;
                } else if(heights[i]>heights[index]){
                    break;
                }

            }

            heights[index]++;
            V--;

        }

        return heights;

    }
}
