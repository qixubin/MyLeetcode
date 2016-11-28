package com.qxb.leetcode._120;

import java.util.List;

/**
 * Created by hacker on 8/1/2016.

 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]

 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int level = triangle.size();
        if (level ==0) return 0;
        if (level ==1) return triangle.get(0).get(0);

        int[]  prevSum = new int[level];
        prevSum[0] = triangle.get(0).get(0);
        for(int i =1; i < level; i++){
            List<Integer> cur = triangle.get(i);

            prevSum[i] = cur.get(i) +prevSum[i-1];


            for(int j =i-1; j>=1; j--){
                prevSum[j] = cur.get(j) + Math.min(prevSum[j], prevSum[j-1]);
            }
            prevSum[0] = cur.get(0) +prevSum[0];

        }

        int res =prevSum[0];

        for(int i =0; i < prevSum.length; i++){
            if (res > prevSum[i]){
                res = prevSum[i];
            }
        }
        return res;
    }

    public static void main(String[] args){

    }

}
