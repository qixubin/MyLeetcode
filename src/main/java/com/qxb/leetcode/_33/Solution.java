package com.qxb.leetcode._33;

/**
 * Created by qixubin on 2016/5/24.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums ==null) return -1;

        if (nums.length ==1){
            return nums[0]==target? 0:-1;
        }

        int len = nums.length;
        int[] sumN = new int[len*2];
        sumN = (int[])concat(nums, nums);

        int begin =0;
        for (; begin< 2*len; begin++){
            if (sumN[begin] > sumN[begin+1])
                break;
        }

        begin =begin +1;
        int end = begin + len-1;
        int result = binarySearch(sumN, begin, end, target);


        return (result >len-1)?result-len:result ;
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        while(end > start){
            if ((end- start) ==1){
                if (nums[start] ==target){
                    return start;
                }else if( nums[end] == target){
                    return end;
                }else{
                    return -1;
                }

            }

            int half  = (start + end) /2;

            if (target == nums[half]) {
                return half;
            }else if (target > nums[half]){
                start = half;
            }else{
                end = half;
            }

        }
        return -1;

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
        Solution s1 = new  Solution();
        int[] nums = new int[]{3,4,5,6,0,1,2};
        int l = s1.search(nums, 100);
        System.out.println(l);
    }
}
