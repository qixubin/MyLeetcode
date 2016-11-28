package com.qxb.leetcode._39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qixubin on 2016/5/27.
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]

 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

//        result.add()

        Arrays.sort(candidates);
        ArrayList<Integer> combine = new ArrayList<Integer>();
        helper(candidates,target,combine,result);
        return result;
    }

    public void helper(int[] candidates, int target, List<Integer> combine,List<List<Integer>> result){
        if (candidates ==null)
            return;

        //int[] sub = sub_1(candidates);
        int first_value = candidates[0];


        int total = sum(combine);
        if ( total== target){
            add(result, combine);
//            result.add(combine);
            return;
        }else if ( total > target){
            return;
        }else{
            //not use current element
            List<Integer> one = copyArrayList(combine);
            helper(sub_1(candidates), target, one,result);
            //use current element
            List<Integer> two = copyArrayList(combine);
            two.add(first_value);
            helper(candidates, target, two,result);

            List<Integer> three = copyArrayList(combine);
            three.add(first_value);
            helper(sub_1(candidates), target, three,result);
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

    public int[] sub_1(int[] candidate){
        if (candidate.length ==1)
            return null;
        return Arrays.copyOfRange(candidate,1,candidate.length);
    }

    public List<Integer> copyArrayList(List<Integer> a){
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i : a){
            b.add(i);
        }
        return b;
    }

    public int sum(List<Integer> al){
        int total =0;
        for (int i :al){
            total+= i;
        }
        return total;
    }



    public static void main(String[] argv){
        Solution s1 = new Solution();
        int[] a = new int[]{2,3,4};
        int b = 7;
//        int[] b =s1.sub_1(a);
//        b[1] =100;
//
//        System.out.println(b);

        int[] c = new int[]{47,22,29,46,37,30,43,21,44,36,25,27,20,40,39,26,35,32,28,42,34,33,38,48,31,49,23,24,45,41};
        int d = 55;

        List<List<Integer>> zz = s1.combinationSum(c, d);
        System.out.println(zz.size());
    }
}
