package com.qxb.leetcode._55;

/**
 * Created by hacker on 6/30/2016.
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.
 A = [3,2,1,0,4], return false.
 */
public class Solution {

    public boolean canJump(int[] nums) {

        int len = nums.length;
        boolean[] result = new boolean[len];

        int max_reach =0;
        for(int i=0; i<len; i++){
            if (i<=max_reach) {
                result[i] = true;

                max_reach = Math.max(max_reach, nums[i]+i);
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
        int[] nums1 = {2,3,1,1,4} ;
        int[] nums2 = {3,2,1,0,4} ;
        System.out.println(s1.canJump(nums1));
        System.out.println(s1.canJump(nums2));
    }
}
