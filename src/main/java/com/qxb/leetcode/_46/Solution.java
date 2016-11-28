package com.qxb.leetcode._46;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qixubin on 2016/6/14.
 *
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:

 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (size ==0){
            return result;
        }

        ArrayList<Integer> new_nums = new ArrayList<Integer>();

        for (int value : nums) {
            new_nums.add(value);
        }

        if (size ==1){
            result.add(new_nums);
        }else{
            for (int i = 0; i < new_nums.size(); i++){
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(new_nums.get(i));

                ArrayList<Integer> clone_nums = (ArrayList<Integer>)new_nums.clone();
                clone_nums.remove(i);
                helper(result, al, clone_nums);
            }
        }
        return result;
    }

    public void  helper( List<List<Integer>> lli, ArrayList<Integer> ready, ArrayList<Integer> availabe){

        for (int i = 0; i < availabe.size(); i++){
            ArrayList<Integer> clone_available = (ArrayList<Integer>)availabe.clone();
            ArrayList<Integer> clone_ready = (ArrayList<Integer>)ready.clone();
            clone_ready.add(availabe.get(i));
            clone_available.remove(i);
            if (clone_available.size() ==0)
            {
                lli.add(clone_ready);
                return;
            }else{
                helper(lli, clone_ready, clone_available);
            }
        }
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
        int[] nums_i ={1,2,3,4};
//        Integer[] nums =new  Integer[]{1,2,3};


        List<List<Integer>> result = s1.permute(nums_i);


//        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(nums));
//
//        ArrayList<Integer> al_1 = (ArrayList<Integer>)al.clone();
//        al_1.remove(2);

        System.out.println("123");

    }
}
