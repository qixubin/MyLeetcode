package com.qxb.leetcode._35;

/**
 * Created by qixubin on 2016/5/25.
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0

 */
public class Solution {
    public int searchInsert(int[] nums, int target) {

        int len = nums.length;

        int left =0;
        int right = len-1;
        int index =-1;
        if (len ==1){
            if (nums[0] == target){
                return 0;
            }

            return target >nums[0]?1:0;
        }

        while(left < right){

            if (right - left ==1){
                if (nums[right] == target){
                    index = right;
                    break;
                }
                if (nums[right] < target ){
                    index = right+1;
                    break;
                }

                if (nums[left] > target){
                    index = left;
                    break;
                }

                if (nums[left]< target && target < nums[right]){
                    index = right;
                    break;
                }
            }

            int mid  =(left + right) /2;

            if (nums[mid] == target){
                index = mid;
                break;
            }else if (nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }

        return index;
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
        int[] nums = new int[]{1,3,5,6};
        int target = 4;
        System.out.println(s1.searchInsert(nums, target));

    }

}
