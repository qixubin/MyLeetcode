package com.qxb.leetcode._118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 8/1/2016.
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows ==0) return res;

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        res.add(al);
        if (numRows ==1) return res;

        for(int i = 2; i<= numRows ; i ++){
            List<Integer> prevList = res.get(i-2);

            ArrayList<Integer> next = new ArrayList<Integer>();
            int prevInt =0;
            for (int j: prevList){
                next.add(prevInt + j);
                prevInt = j;
            }
            next.add(1);
            res.add(next);
        }


        return res;

    }
}
