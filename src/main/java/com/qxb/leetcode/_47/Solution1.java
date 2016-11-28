package com.qxb.leetcode._47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qixubin on 2016/6/15.
 */

//back tracking
public class Solution1 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }




    public static void main(String[] argv){
        Solution1 s1 = new Solution1();
        int[] nums_i ={1,2,1,1,2,3,4,5,6,7,8};

        long aa = System.currentTimeMillis();
        List<List<Integer>> result = s1.permuteUnique(nums_i);

        System.out.println("after  time:" +(System.currentTimeMillis()-aa));

        //test deep clone

        System.out.println("aa");
    }
}
