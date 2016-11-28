package com.qxb.leetcode._54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 6/30/2016.
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]

 You should return [1,2,3,6,9,8,7,4,5].

 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m==0)
            return result;
        int n = matrix[0].length;
        if (n==0)
            return result;

        helper(result, matrix, 0, m-1, 0, n-1);
        return result;
    }

    public void helper(List<Integer> result, int[][] matrix,int start_row, int end_row, int start_col, int end_col){
        if( (start_row == end_row) && (start_col == end_col)){
            result.add(matrix[start_row][start_col]);

        }else if (start_row ==end_row){
            for( int i = start_col; i <=end_col; i++){
                result.add(matrix[start_row][i]);
            }

        }else if (start_col == end_col){
            for( int i = start_row; i <=end_row; i++){
                result.add(matrix[i][start_col]);
            }
        }else if ((start_row +1 == end_row) && (start_col +1 == end_col)){
            result.add(matrix[start_row][start_col]);
            result.add(matrix[start_row][start_col+1]);
            result.add(matrix[start_row+1][start_col+1]);
            result.add(matrix[start_row+1][start_col]);
            return;
        }else if((start_row +1 == end_row) && (start_col +1 < end_col)){
            for(int i = start_col; i<=end_col;i++){
                result.add(matrix[start_row][i]);
            }
            for(int i = end_col; i>=start_col; i--){
                result.add(matrix[end_row][i]);
            }
            return;
        }else if((start_row +1 < end_row) && (start_col +1 == end_col)){
            result.add(matrix[start_row][start_col]);
            for (int i = start_row; i <= end_row; i++){
                result.add(matrix[i][end_col]);
            }
            for (int i = end_row; i >=start_row +1; i--){
                result.add(matrix[i][start_col]);
            }
            return;
        }else{
            for(int i = start_col; i < end_col; i++){
                result.add(matrix[start_row][i]);
            }
            for(int i = start_row; i <end_row; i++){
                result.add(matrix[i][end_col]);
            }
            for(int i = end_col; i> start_col; i--){
                result.add(matrix[end_row][i]);
            }
            for(int i = end_row; i> start_row; i--){
                result.add(matrix[i][start_col]);
            }

            helper(result, matrix, start_row +1, end_row-1,start_col+1,end_col-1);

        }

    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
//        int[][] matrix = {
//                {1, 2, 3 },
//                {4, 5, 6 },
//                {7, 8, 9 },
//        };

        int[][] matrix = {
                { 2, 3 }
        };

        List<Integer> li = s1.spiralOrder(matrix);
        for (int i:li){
            System.out.print(i +" ");
        }
    }

}
