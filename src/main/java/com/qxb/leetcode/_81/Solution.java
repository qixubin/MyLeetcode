package com.qxb.leetcode._81;

/**
 * Created by hacker on 7/14/2016.


 33 Search in Rotated Sorted Array
 ---------------------------------
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 ---------------------------------

 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.


 */
public class Solution {

    public boolean search(int[] nums, int target) {
        if (nums ==null) return false;

        if (nums.length ==1){
            return nums[0]==target? true:false;
        }

        int len = nums.length;
        int[] sumN = new int[len*2];
        sumN = (int[])concat(nums, nums);

        int begin =0;
        for (; begin< len; begin++){
            if (sumN[begin] > sumN[begin+1])
                break;
        }

        if (begin == len) return target ==nums[0];

        begin =begin +1;
        int end = begin + len-1;

        return binarySearch(sumN, begin, end, target);
    }

    public boolean binarySearch(int[] nums, int start, int end, int target){
        while(end > start){
            if ((end- start) ==1){
                if (nums[start] ==target){
                    return true;
                }else if( nums[end] == target){
                    return true;
                }else{
                    return false;
                }

            }

            int half  = (start + end) /2;

            if (target == nums[half]) {
                return true;
            }else if (target > nums[half]){
                start = half;
            }else{
                end = half;
            }

        }
        return false;

    }

    public int[] concat(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] c= new int[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    public static void main(String[] argv){
        Solution so = new Solution();
        int[] nums = {1,1};
        int n =0;
        System.out.println(so.search(nums, n));

    }
}
