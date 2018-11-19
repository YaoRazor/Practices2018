package dp;

public class PaintHouseTwo {



    // 只需要记录3个变量： Previous最小的值，以及相应的index(涂的颜色)，和Previous第二小的值即可，连Index都可以不关心了
    public int minCostII(int[][] costs) {

        if(costs==null || costs.length ==0 || costs[0].length==0) {
            return 0;
        }

        int preMin = 0;
        int preIndex = -1;
        int preSecMin = 0;

        for(int i=0; i<costs.length; i++) {

            // 每一轮都不停的更新本轮的3个变量
            int min = Integer.MAX_VALUE;
            int secMin = Integer.MAX_VALUE;
            int index = -1;

            for(int j=0; j<costs[i].length; j++) {

                int cost = costs[i][j] + (j==preIndex? preSecMin: preMin);

                if(cost<min) {
                    secMin = min;
                    min = cost;
                    index = j;

                } else if(cost<secMin) {
                    secMin = cost;
                }


            }

            preMin = min;
            preIndex = index;
            preSecMin = secMin;

        }

        return preMin;
    }


}
