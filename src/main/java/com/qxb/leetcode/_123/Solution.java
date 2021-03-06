package com.qxb.leetcode._123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hacker on 8/2/2016.


 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int index =0;

        ArrayList<Integer> ali = new ArrayList<Integer>();
        while(index < len-1) {
            while ((index < len - 1)
                    && (prices[index] >= prices[index + 1])
                    ) {
                index++;
            }
            if (index == len - 1) break;

            int right = index+1;

            while ((right < len-1 )
                    && (prices[right +1] >= prices[right])
                    ) {
                right++;
            }

            ali.add(prices[right] - prices[index]);
            index = right+1;
        }

        if (ali.size() ==0) return 0;
        if (ali.size() ==1) return ali.get(0);

        int li_len = ali.size();
        Collections.sort(ali);
        return ali.get(li_len-1) + ali.get(li_len-2);
    }


    //discuss rank1
    public int maxProfit1(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    //discuss rank2
    public int maxProfit2(int[] prices){
        // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
        // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
        //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
        // f[0, ii] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
        if (prices.length <= 1) return 0;
        else {
            int K = 2; // number of max transation allowed
            int maxProf = 0;
            int[][] f = new int[K+1][prices.length];
            for (int kk = 1; kk <= K; kk++) {
                int tmpMax = f[kk-1][0] - prices[0];
                for (int ii = 1; ii < prices.length; ii++) {
                    f[kk][ii] = Math.max(f[kk][ii-1], prices[ii] + tmpMax);
                    tmpMax = Math.max(tmpMax, f[kk-1][ii] - prices[ii]);
                    maxProf = Math.max(f[kk][ii], maxProf);
                }
            }
            return maxProf;
        }
    }

    public static void main(String[] args){
        int[] pri = {1,2,4,2,5,7,2,4,9,0};
        Solution so = new Solution();
        int res = 0;
        res =so.maxProfit(pri);
        res = so.maxProfit1(pri);
        res = so.maxProfit2(pri);
        System.out.println(res);
    }

}
