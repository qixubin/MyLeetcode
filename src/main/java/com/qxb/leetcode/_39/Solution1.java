package com.qxb.leetcode._39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qixubin on 2016/5/30.
 */
public class Solution1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, target, null, res, 0);
        return res;
    }
    public void helper(int[] candidates, int target, LinkedList<Integer> l, List<List<Integer>> res, int start){
        if(l==null){
            l = new LinkedList<Integer>();
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]==target){
                l.add(candidates[i]);
                res.add(l);
                return;
            }
            if(candidates[i]>target){
                return;
            }
            LinkedList<Integer> l2 = (LinkedList)l.clone();
            l2.add(candidates[i]);
            helper(candidates, target-candidates[i], l2, res, i);
        }

    }

    public static void main(String[] argv){

    }
}
