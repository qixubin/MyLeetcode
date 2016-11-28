package com.qxb.leetcode._40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qixubin on 2016/5/30.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                add(res, l);
                return;
            }
            if(candidates[i]>target){
                return;
            }
            LinkedList<Integer> l2 = (LinkedList)l.clone();
            l2.add(candidates[i]);
            helper(candidates, target-candidates[i], l2, res, i+1);
        }

    }

    public void add(List<List<Integer>> result, List<Integer> combine ){
        boolean exists = false;
        for (int i =0; i< result.size(); i ++){
            List<Integer> item =  result.get(i);

            int count =0;
            if (item.size() == combine.size()){
                for (int j = 0; j < item.size(); j++){
                    if (item.get(j) == combine.get(j)){
                        count ++;
                    }
                }
            }
            if (count == item.size()){
                exists = true;
            }

        }

        if (!exists){
            result.add(combine);
        }

    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
        int[] candi = {2,2,2};
        int target = 4;
        List<List<Integer>>  l =s1.combinationSum2(candi, target);
        System.out.println("aa");

    }

}
