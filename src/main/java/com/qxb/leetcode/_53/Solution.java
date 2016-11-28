package com.qxb.leetcode._53;

/**
 * Created by hacker on 6/29/2016.


 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 click to show more practice.
 More practice:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if ( nums.length == 0 ) { return 0; }
        int sum = nums[0];
        int maxSum = sum;
        for ( int i = 1; i < nums.length; i++ ) {
            if ( sum > 0 ) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] argc){
        Solution s1 = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s1.maxSubArray(nums));

    }
}
