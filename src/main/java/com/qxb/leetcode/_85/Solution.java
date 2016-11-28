package com.qxb.leetcode._85;

/**
 * Created by hacker on 7/15/2016.

 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

 */

//not understand the problem
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;

        int minX =n;
        int maxX =-1;
        int minY =m;
        int maxY =-1;

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(matrix[i][j] == '1'){
                    if (j<minX) minX =j;
                    if (j>maxX) maxX =j;
                    if (i<minY) minY =i;
                    if (i>maxY) maxY =i;
                }
            }
        }

        if (maxX< minX || maxY<minY) return 0;

        return (maxX -minX+1)*(maxY -minY+1);
    }

    public static void main(String[] argv){
        Solution so = new Solution();
//        char[][] matrix = {};
//        char[][] matrix = {{'0'}};
        char[][] matrix = {{'1'}};
        int area = so.maximalRectangle(matrix);
        System.out.println(area);
    }
}
