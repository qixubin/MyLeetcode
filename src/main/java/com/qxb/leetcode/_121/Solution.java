package com.qxb.leetcode._121;

/**
 * Created by hacker on 8/1/2016.

 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:

 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

 Example 2:

 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.


 */
public class Solution {

    // first solution , wrong by test case 2
    public int maxProfit(int[] prices) {
        int res =0;
        int len = prices.length;

        int left =0;
        int right = len-1;

        while(left < right){
            while(  (left<len-1)
                    && (prices[left] >=prices[left+1])
                    ){
                left ++;
            }
            if(left >= right) break;

            while( right >=0 && (prices[right]<= prices[right-1])
                    ){
                right--;
            }
            if(left >= right) break;

            int max1 = prices[left+1] - prices[left];
            int max2 = prices[right] - prices[right-1];

            int max3 = prices[right] - prices[left];

            left ++;
            right --;
            res =Math.max(res, Math.max(max3,Math.max(max1,max2)));
        }

        return res;
    }

    //second solution, wrong by testcase 3
    public int maxProfit2(int[] prices) {
        int res =0;
        int len = prices.length;

        int left =0;
        int right = len-1;

        while(left < right){
            while(  (left<len-1)
                    && (prices[left] >=prices[left+1])
                    ){
                left ++;
            }
            if(left >= right) break;

            while( right >=0 && (prices[right]<= prices[right-1])
                    ){
                right--;
            }
            if(left >= right) break;

            int max3 = prices[right] - prices[left];
            int lleft =left;
            int rright = right;

            while(  (lleft<len-1)
                    && (prices[lleft] <=prices[lleft+1])
                    ){
                lleft ++;
            }

            while(  (rright>=0)
                    && (prices[rright] <=prices[rright -1])
                    ){
                rright--;
            }

            int max1 = prices[lleft] - prices[left];
            int max2 = prices[rright] - prices[right];
            res =Math.max(res, Math.max(max3,Math.max(max1,max2)));
            left =lleft;
            right = rright;
        }

        return res;
    }


    // just ACed......beat 1%, should use DP?
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int left =0;

        int res = 0;
        while(left < len-1) {
            while ((left < len - 1)
                    && (prices[left] >= prices[left + 1])
                    ) {
                left++;
            }
            if (left == len -1) break;

            int max = prices[left+1];
            for(int i =left+1; i<len; i++){
                if (prices[i] > max)
                    max = prices[i];
            }
            res = Math.max(res, max-prices[left++]);
        }
        return res;
    }


    //not DP, can hava other optimize... beat 94.05% now. ^-^
    public int maxProfit4(int[] prices) {
        int len = prices.length;
        int left =0;

        int res = 0;
        while(left < len-1) {
            while ((left < len - 1)
                    && (prices[left] >= prices[left + 1])
                    ) {
                left++;
            }
            if (left == len -1) break;

            int cur = prices[left];

            int max = cur;
            int maxIndex =left;

            for(int i =left+1; i<len; i++){
                if (prices[i] >= max) {
                    max = prices[i];
                    maxIndex = i;
                }

            }

            int minBefore = cur;
            int minBeforeIndex = left;
            for(int i =left+1; i<maxIndex; i++){
                if (prices[i] < minBefore) {
                    minBefore = prices[i];
                    minBeforeIndex = i;
                }
            }

            int minAfter = cur;
            int minAfterIndex = left;
            for(int i =maxIndex +1; i<len; i++){
                if (prices[i] < minAfter) {
                    minAfter = prices[i];
                    minAfterIndex = i;
                }
            }

            if (minBefore < cur){
                res = Math.max(res, max -minBefore);
                if (minAfter >= cur)
                    break;
                else{
                    left = minAfterIndex;
                }
            }else{
                res = Math.max(res, max-cur );
                if (minAfter >= cur)
                    break;
                else{
                    left = minAfterIndex;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        int[] prices = {7,1,5,3,6,4};

        int[] prices1 = {2,1,2,1,0,1,2};
        int[] prices2 = {1,3,5,4,3,7,6,9,2,4};
        int[] prices3 = {2,4,1};
        int[] prices4 = {3,2,6,5,0,3};
        int[] prices5 = {4,7,2,11,1};
//        int res = so.maxProfit(prices);
//        int res1 = so.maxProfit(prices1);
//        int res2 = so.maxProfit2(prices2);
//        int res3 = so.maxProfit3(prices2);
        int res4 = so.maxProfit4(prices5);
        System.out.println(res4);

    }
}
