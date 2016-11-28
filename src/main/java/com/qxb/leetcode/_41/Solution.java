package com.qxb.leetcode._41;

/**
 * Created by qixubin on 2016/5/30.
 */
public class Solution {
// solution 1 trick
//    public int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        int m = n + 1;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] <= 0 || nums[i] > n) nums[i] = 0;
//        }
//        for (int i = 0; i < n; i++) {
//            int prev = nums[i] % m;
//            if (prev > 0)
//                nums[prev - 1] = (prev * m) + nums[prev - 1] % m;
//        }
//        for (int i = 0; i < n; i++) {
//            if (nums[i] / m != i + 1) return i + 1;
//        }
//        return m;
//    }


    //solution2 tricky
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int ind  = 0;
        for(int i =0; i < nums.length; i++) {

            if(nums[i] <= 0) {
                int tmp = nums[ind];
                nums[ind] = nums[i];
                nums[i] = tmp;
                ind++;
            }

        }

        for(int i = ind; i < nums.length; i++){

            if(Math.abs(nums[i]) + ind - 1 < nums.length && nums[Math.abs(nums[i]) + ind - 1] > 0){
                int j = Math.abs(nums[i]) + ind - 1;
                int k = nums[Math.abs(nums[i]) + ind - 1];

                nums[Math.abs(nums[i]) + ind - 1] = -nums[Math.abs(nums[i]) + ind - 1];
            }


        }

        for(int i =ind; i < nums.length; i++){
            if(nums[i] > 0) return i - ind + 1;
        }

        if(ind == nums.length ) return 1;
        return nums.length-ind+1;
    }


    public static void main(String[] argc){
        Solution s1= new Solution();
        int[] nums = {3,4,-1,1,-2};
        System.out.println(s1.firstMissingPositive(nums));
    }
}
