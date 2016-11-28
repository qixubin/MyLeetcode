package com.qxb.leetcode._78;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixubin on 2016/6/15.
 *
 *
 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (size ==0){
            result.add(new ArrayList<Integer>());
        }else{
            for (int i =0; i < Math.pow(2, size); i++){
                ArrayList<Integer> al = new ArrayList<>();
                for (int j =0; j <size; j++){
                    if ((i &(int) Math.pow(2,j)) >0){
                        al.add(nums[j]);
                    }
                }
                result.add(al);
            }
        }
        return result;
    }

    public static void main(String[] argv){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};

        Solution s1 = new Solution();

        long aa = System.currentTimeMillis();
        List<List<Integer>> lli = s1.subsets(nums);
        System.out.println("it takes:" + (System.currentTimeMillis() -aa));


        System.out.println();
    }
}
