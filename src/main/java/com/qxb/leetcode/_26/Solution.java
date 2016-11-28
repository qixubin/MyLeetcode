package com.qxb.leetcode._26;



/**
 * Created by qixubin on 2016/5/10.
 *
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

 Subscribe to see which companies asked this question
 *
 *
 */
public class Solution {

    public int removeDuplicates(int[] nums) {

//        int len = nums.length;
//        if (len == 1)
//            return 1;
//
//        int II  =-100;
//        int previous = II;
//        int distinct = 0;
//
//        for (int i =0; i< len; i ++) {
//            if (nums[i] == previous) {
//                previous = nums[i];
//                nums[i] = II;
//            } else {
//                previous = nums[i];
//                distinct++;
//            }
//        }
//
//        int m =1;
//        for (int i =1; i< len && m < distinct; i ++) {
//
//            if( nums[i] != II){
//                nums[m++]= nums[i];
//            }
//
//        }
//
//        return distinct;

        if (nums.length <= 1)
            return nums.length;
        int tail = 0;
        for (int num: nums) {
            if (num != nums[tail])
                nums[++tail] = num;
        }
        return tail+1;
    }

    

    public static void main(String[] argc) {

        Solution s1 = new Solution();
        int[] nums = {1,1,1,1,1,2,2,3,3,4};
        int i =s1.removeDuplicates(nums);
        System.out.println(i);
    }
}
