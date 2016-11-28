package com.qxb.leetcode._73;

/**
 * Created by hacker on 7/11/2016.

 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.
 Follow up:

 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?


 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }

    }

    public static void main(String[] argv){
        Solution so = new Solution();

        int[][] matrix = { {1,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        so.setZeroes(matrix);

    }

}
