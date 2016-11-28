package com.qxb.leetcode._27;

/**
 * Created by qixubin on 2016/5/12.
 *
 *
 *Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int result =0;
        int len = nums.length;
        int left =0, right = len -1;
        for (; left < right;){
            if (nums[right] == val){
                right--;
                continue;
            }
            if (nums[left] != val){
                left ++;
                result++;
                continue;
            }


            nums[left++] = nums[right];
            nums[right--] = val;
            result++;
        }

        if ((left == right) && (nums[left] !=val))
            result ++;

        return result;

    }

    public static void main(String[] argc){
        Solution s1 = new Solution();


        int[] nums = {3,1,2,3,4,5,3};
        System.out.println(s1.removeElement(nums, 3));
    }
}
