package com.qxb.leetcode._283;

/**
 * Created by qixubin on 2016/5/16.
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int k =0;
        for( int i =0; i <nums.length; i++){
            if (nums[i] ==0){

            }else{
                nums[k++] = nums[i];
            }
        }

        for( int i = k; i < nums.length; i++){
            nums[i]=0;
        }
       // System.out.println(nums);
    }

    public static void main(String[] argc){
        int[] nums = {0,1,0,3,12};
        Solution s1 = new Solution();
        s1.moveZeroes(nums);
    }
}
