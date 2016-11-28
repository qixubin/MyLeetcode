package com.qxb.leetcode._74;

/**
 * Created by hacker on 7/11/2016.

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.

 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]

 Given target = 3, return true.

 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start =0;
        int end = m*n-1;

        if (target <matrix[0][0] || target > matrix[m-1][n-1]) return false;

        return binarySearch(matrix, start, end, target);
    }

    public boolean binarySearch(int[][] matrix, int start, int end, int target){
        int n = matrix[0].length;
        if (start == end -1){
            if (      matrix[start/n][start%n] == target
                    || matrix[end/n][end%n] == target)
                return true;

            return false;
        }

        int mid = (start + end)/2;
        int midValue = matrix[mid/n][mid%n];

        if ( midValue== target){
            return true;
        }else if (midValue > target){
            return binarySearch(matrix, start, mid, target);
        }else{
            return binarySearch(matrix, mid, end, target);
        }
    }

    public static void main(String[] argv){
//        int[][] matrix= {
//        {1,   3,  5,  7},
//        {10, 11, 16, 20},
//        {23, 30, 34, 50}
//    };
        int[][] matrix = {{1,3}};
        Solution so = new Solution();
        boolean res = so.searchMatrix(matrix, 2);
        System.out.println(res);
    }
}
