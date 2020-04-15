package greedy;

import java.util.Arrays;

public class Candy {

    public int candyTwoPassOptimal(int[] ratings) {
        if(ratings==null || ratings.length==0) {
            return 0;
        }

        if(ratings.length==1) {
            return 1;
        }

        int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        int cnt = 0;

        // do {
        cnt = 0;
        for(int i=1; i<n; i++) {

            if(ratings[i]>ratings[i-1]) {
                candies[i] =  candies[i-1]+1;
                // cnt++;
            }

        }

        for(int i=n-1; i>=1; i--) {
            if(ratings[i-1]>ratings[i] && candies[i]+1>candies[i-1]) {
                candies[i-1] = candies[i]+1;
            }
        }
        // } while (cnt>0);

        int ans = 0;
        // String tmp = "";
        for(int num: candies) {
            // tmp+= num+" ";
            ans+=num;
        }

        // System.out.println(tmp);

        return ans;
    }


    public int candyIntuitiveSolution(int[] ratings) {
        if(ratings==null || ratings.length==0) {
            return 0;
        }

        if(ratings.length==1) {
            return 1;
        }

        int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        int cnt = 0;

         do {
        cnt = 0;
        for(int i=1; i<n; i++) {

            if(ratings[i]>ratings[i-1]) {
                candies[i] =  candies[i-1]+1;
                // cnt++;
            }

        }

        for(int i=n-1; i>=1; i--) {
            if(ratings[i-1]>ratings[i] && candies[i]+1>candies[i-1]) {
                candies[i-1] = candies[i]+1;
            }
        }
         } while (cnt>0);

        int ans = 0;
        for(int num: candies) {
            ans+=num;
        }

        return ans;
    }



}
