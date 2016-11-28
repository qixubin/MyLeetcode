package com.qxb.leetcode._46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixubin on 2016/6/15.
 */

//DFS solution
public class Solution2 {

    List<List<Integer>> toRet;
    public List<List<Integer>> permute(int[] nums)
    {
        toRet = new ArrayList<List<Integer>>();
        dfs(nums, 0, nums.length - 1);
        return toRet;
    }
    void swap(int[] nums, int f, int l)
    {
        if(f != l)
        {
            int t = nums[f];
            nums[f] = nums[l];
            nums[l] = t;
        }
    }
    void dfs(int[] nums, int ind, int len)
    {
        if(ind == len)
        {
            List<Integer> trex = new ArrayList<Integer>();
            for(int i = 0; i <= len; i++)
                trex.add(nums[i]);
            toRet.add(trex);
            return;
        }
        for(int i = ind; i <= len; i++)
        {
            swap(nums, ind, i);
            dfs(nums, ind + 1, len);
            swap(nums, i, ind);
        }
    }

    public static void main(String[] argv) {
        Solution2 s2 = new Solution2();

        int[] nums_i ={1,2,3,};

        List<List<Integer>> result = s2.permute(nums_i);
    }
}
