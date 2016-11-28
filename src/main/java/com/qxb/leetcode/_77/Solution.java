package com.qxb.leetcode._77;

import java.util.*;

/**
 * Created by hacker on 7/13/2016.

 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]


 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();

        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>() ;
        if (k==0) return res;

        for(int i =1; i<= n-k+1; i++){
            List<Integer> li = new ArrayList<Integer>();
            li.add(i);
            res.add(li);
        }
        if(k==1) return res;
        helper(res, n,k,1);
        return res;

    }

    public void helper(LinkedList<List<Integer>> queue, int n, int k, int level){
        int size = queue.size();

        for(int i=0; i < size; i++){
            List<Integer> li = queue.poll();
            int max = li.get(li.size()-1);
            for(int j = max+1; j<=(n -(k-level)+1); j++) {
                ArrayList<Integer> li_c = new ArrayList<Integer>(li);
                li_c.add(j);
                queue.offer(li_c);
            }
        }

        if (level == k -1)
            return;
        else
            helper(queue, n, k, level+1);
    }

    public static void main(String[] argv){
        Solution so = new Solution();
        List<List<Integer>> res = so.combine(5,2);
        System.out.println(res.size());

    }
}
