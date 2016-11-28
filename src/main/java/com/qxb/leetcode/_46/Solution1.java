package com.qxb.leetcode._46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixubin on 2016/6/15.
 */

//back tracking
public class Solution1 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] argv) {
        Solution1 s11 = new Solution1();

        int[] nums_i ={1,2,3,};

        List<List<Integer>> result = s11.permute(nums_i);
    }
}
