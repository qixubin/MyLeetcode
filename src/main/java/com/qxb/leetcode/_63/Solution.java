package com.qxb.leetcode._63;

/**
 * Created by hacker on 7/2/2016.
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,

 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]

 The total number of unique paths is 2.

 Note: m and n will be at most 100.

 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prevRow = new int[n];
//        for(int i=0; i<n; i++) { prevRow[i] =1;}
        int prevCol=1;

        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if (obstacleGrid[i][j] ==1){
                    prevRow[j] =0;
                    prevCol =0;
                }

                if(prevRow[j] + prevCol ==0  ){
                    prevRow[j] =0;
                    prevCol =0;
                }else {
                    prevRow[j] = prevRow[j] + prevCol;
                    prevCol = prevRow[j];
                }
            }
            prevCol =0;
        }


        return prevRow[n-1];
    }

    public static void main(String[] argv){
        int[][] matrix = {{0,0,0}
                ,{0,1,0}
                ,{0,0,0}
                };

        Solution so = new Solution();
        int res =so.uniquePathsWithObstacles(matrix);
        System.out.println(res);
    }
}
