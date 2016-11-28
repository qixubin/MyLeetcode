package com.qxb.leetcode._59;

/**
 * Created by hacker on 7/1/2016.

 Given an integer n, generate a square matrix filled with elements from 1 to n*n in spiral order.

 For example,
 Given n = 3,
 You should return the following matrix:

 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]


 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n==1){
            result[0][0] =1;
        }else{
            helper(result, n, 0,0, 1);
        }

        return result;
    }

    public void  helper(int[][] matrix, int n, int startRow, int startCol, int count){
        if (n==0){
            return;
        }else if (n ==1){
            matrix[startRow][startCol] =count;
        }else{
            for(int i = 0; i<n-1;i++ ){
                matrix[startRow][startCol+i] = count++;
            }
            for(int i = 0; i<n-1;i++ ){
                matrix[startRow+i][startCol+n-1] = count++;
            }
            for(int i = 0; i<n-1;i++ ){
                matrix[startRow+n-1][startCol+n-1-i] = count++;
            }
            for(int i = 0; i<n-1;i++ ){
                matrix[startRow+n-1-i][startCol] = count++;
            }

            helper(matrix, n-2, startRow+1, startCol+1, count);
        }
    }


    public static void main(String[] argv){
        Solution so = new Solution();
        int[][] result =so.generateMatrix(4);

        System.out.println("aaa");
    }

}
