package com.qxb.leetcode._64;

/**
 * Created by hacker on 7/2/2016.

 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.


 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prevRow = new int[n];
        for(int i=0; i< n; i++) prevRow[i] =-1;
        int prevCol=-1;

        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){

                if (prevCol ==-1 && prevRow[j] ==-1){
                    prevRow[j] =grid[i][j];

                }else if(prevCol ==-1){
                    prevRow[j] =grid[i][j] + prevRow[j];
                }else if(prevRow[j] ==-1) {
                    prevRow[j] =grid[i][j] +prevCol;
                }else{
                    prevRow[j] =grid[i][j] +Math.min(prevCol, prevRow[j]);
                }

                prevCol = prevRow[j];

            }
            prevCol =-1;
        }

        return prevRow[n-1];
    }

    public static void main(String[] argv){
        int[][] matrix = {
                 {0,1,0}
                ,{0,1,1}
                ,{1,1,0}
        };

        Solution so = new Solution();
        int res =so.minPathSum(matrix);
        System.out.println(res);
    }
}
