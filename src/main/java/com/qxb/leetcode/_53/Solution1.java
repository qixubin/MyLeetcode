package com.qxb.leetcode._53;

/**
 * Created by hacker on 6/29/2016.
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return dfshelper(nums , 0 , nums.length-1);
    }

    protected int dfshelper(int[] nums , int left , int right) {
        if(left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftmax = dfshelper(nums , left , mid);//   divide part
        int rightmax = dfshelper(nums , mid+1 , right); //  divide part
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int leftsum = 0;
        int rightsum = 0;
        for(int i = mid ; i >= left ; i--) { //  conquer part
            leftsum += nums[i];
            lmax = Math.max(lmax , leftsum);
        }
        for(int i = mid+1 ; i <= right ; i++) { //  conquer part
            rightsum += nums[i];
            rmax = Math.max(rmax , rightsum);
        }
        int crossmax = lmax + rmax; //  conquer part
        return Math.max(crossmax , Math.max(leftmax , rightmax));   //  combine part
    }

    public static void main(String[] argc){
        Solution1 s1 = new Solution1();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s1.maxSubArray(nums));

    }
}
