package com.qxb.leetcode._34;

/**
 * Created by qixubin on 2016/5/24.
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left =0;
        int right = len-1;
        int index =-1;
        if (len ==1){
            if (nums[0] == target){
                return new int[] {0,0};
            }

            return new int[]{-1,-1};
        }

        while(left < right){

            if (right - left ==1){
                if (nums[right] == target){
                    index = right;
                    break;
                }
                if (nums[right] != target && nums[left] != target){
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

        if (index == -1)
            return new int[]{-1,-1};


        return searchSides(nums, index, target);
    }

    public int[] searchSides(int[] nums, int index, int target){
        int right=index;
        int left = index;
        while( (right-1 >=0) && nums[right-1] == target){
            right--;
        }
        while( (left+1 < nums.length) && nums[left+1] == target){
            left++;
        }
        return new int[]{right, left};
    }

    public static void main(String[] argv){
//        int[] nums = new int[] {5,7,7,8,8,10};
//        int target = 7;

        int[] nums = new int[] {1};
        int target = 1;
        Solution s1 = new Solution();
        int[] res = s1.searchRange(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
