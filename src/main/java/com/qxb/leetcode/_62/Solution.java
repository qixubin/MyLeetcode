package com.qxb.leetcode._62;

/**
 * Created by hacker on 7/1/2016.
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 */
public class Solution {

    public int uniquePaths(int m, int n) {

        int[] prevRow = new int[n];
        int prevCol=1;

        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                prevRow[j] = prevRow[j] + prevCol;
                prevCol = prevRow[j];
            }
            prevCol =0;
        }

        return prevRow[n-1];
    }

    public static void main(String[] argv){
        Solution so = new Solution();
        int res = so.uniquePaths(3,7);
        System.out.println(res);
    }

}
