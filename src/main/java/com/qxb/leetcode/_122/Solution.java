package com.qxb.leetcode._122;

/**
 * Created by hacker on 8/2/2016.

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */
public class Solution {
    public int maxProfit(int[] prices) {

        int len = prices.length;
        int index =0;

        int res = 0;
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

            res += prices[right] - prices[index];
            index = right+1;
        }

        return res;
    }

}
