package com.qxb.leetcode._48;

/**
 * Created by qixubin on 2016/6/18.
 *
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?

 */
public class Solution {

    public void rotate(int[][] matrix) {

        int k = matrix.length;

        if (k % 2 ==0){
            for (int i =0; i< k/2; i++){
                for ( int j =0; j < k/2; j++){
                    swapFour(matrix, i,j);
                }
            }
        }else{
            for (int i =0; i< k/2; i++){
                for ( int j =0; j < k/2  +1; j++){
                    swapFour(matrix, i,j);
                }
            }
        }

    }

    public void swapFour(int[][] matrix, int i, int j){
        int len = matrix.length-1;

        int tmp = matrix[i][j];

        matrix[i][j] = matrix[len-j][i];
        matrix[len-j][i] = matrix[len-i][len-j];
        matrix[len-i][len-j] = matrix[j][len-i];
        matrix[j][len-i] = tmp;

    }

    public static void printMatrix(int[][] matrix){
        for (int i  = 0; i < matrix.length; i++){

            for(int j =0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(",");
            }

            System.out.println("");
        }
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
//        int[][] matrix = {{1,2,3,4}
//            ,{5,6,7,8}
//            ,{9,10,11,12}
//            ,{13,14,15,16}};

        int[][] matrix = {{1,2,3,4,5}
                ,{6,7,8,9,10}
                ,{11,12,13,14,15}
                ,{16,17,18,19,20}
                ,{21,22,23,24,25}
        };

        printMatrix(matrix);
        s1.rotate(matrix);
        printMatrix(matrix);
    }
}
