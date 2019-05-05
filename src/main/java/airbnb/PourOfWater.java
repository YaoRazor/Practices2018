package airbnb;

public class PourOfWater {
    public int[] pourWater(int[] heights, int V, int K) {

        if(heights==null || heights.length==0 || V==0) {
            return heights;
        }


        int[] waters = new int[heights.length];

        for(int i=0; i<heights.length; i++) {
            waters[i] = heights[i];
        }


        while (V>0) {

            int index = K;


            for(int i=K-1; i>=0; i--) {

                if(waters[i]<waters[index]) {
                    index = i;
                } else if(waters[i]>waters[index]){
                    break;
                }

            }

            if(index!=K) {
                waters[index]++;
                V--;
                continue;
            }


            for(int i=K+1; i<waters.length; i++) {

                if(waters[i]<waters[index]) {
                    index = i;
                } else if(waters[i]>waters[index]){
                    break;
                }

            }

            waters[index]++;
            V--;

        }

        print(heights, waters);

        return waters;

    }

    private void print(int[] heights, int[] waters) {
        int n = heights.length;

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, waters[i]);
        }

        for (int height = maxHeight; height >= 0; height--) {
            for (int i = 0; i < n; i++) {
                if (height <= heights[i]) {
                    System.out.print("+");
                } else if (height > heights[i] && height <= waters[i]) {
                    System.out.print("W");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
