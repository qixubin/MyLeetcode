package com.qxb.leetcode._47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qixubin on 2016/6/15.
 *

 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:

 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (size ==0){
            return result;
        }

        Arrays.sort(nums);

        List<List<Integer>> new_nums = new ArrayList<List<Integer>>();

        int prev =0;
        for (int i =0; i < size; i++) {
            if (i ==0){
                ArrayList<Integer> slot  = new ArrayList<Integer>();
                slot.add(nums[i]);
                new_nums.add(slot);
            }else{
                if (nums[i] == prev){
                    new_nums.get(new_nums.size()-1).add(nums[i]);
                }else{
                    ArrayList<Integer> slot  = new ArrayList<Integer>();
                    slot.add(nums[i]);
                    new_nums.add(slot);
                }
            }

            prev = nums[i];
        }

        if (size ==1){
            result.add(new_nums.get(0));
        }else{
            for (int i = 0; i < new_nums.size(); i++){
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(new_nums.get(i).get(0));

                List<List<Integer>> clone_nums = clone_list(new_nums);
                clone_nums.get(i).remove(0);
                if(clone_nums.get(i).size() ==0){
                    clone_nums.remove(i);
                }
                helper(result, al, clone_nums);
            }
        }

        return result;

    }

    public void  helper( List<List<Integer>> lli, ArrayList<Integer> ready, List<List<Integer>> availabe){
        if (availabe.size() ==1){
            ready.addAll(availabe.get(0));
            lli.add(ready);
            return;
        }

        for (int i = 0; i < availabe.size(); i++){
            List<List<Integer>> clone_available = clone_list(availabe);
            ArrayList<Integer> clone_ready = (ArrayList<Integer>)ready.clone();
            clone_ready.add(availabe.get(i).get(0));
            clone_available.get(i).remove(0);
            if(clone_available.get(i).size() ==0){
                clone_available.remove(i);
            }
            helper(lli, clone_ready, clone_available);

        }
    }

    public List<List<Integer>> clone_list(List<List<Integer>> availale){

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> a : availale){
            ArrayList<Integer> b =(ArrayList<Integer>) a;

            result.add((ArrayList<Integer>) b.clone());
        }
        return result;
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
        int[] nums_i ={1,2,1,1,2,3,4,5,6,7,8};

        long aa = System.currentTimeMillis() ;
        List<List<Integer>> result = s1.permuteUnique(nums_i);

        System.out.println("after  time:" +(System.currentTimeMillis() -aa) );



        //test deep clone

        System.out.println("aa");
    }

}
