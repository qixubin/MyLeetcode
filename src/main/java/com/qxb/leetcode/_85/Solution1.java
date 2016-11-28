package com.qxb.leetcode._85;

/**
 * Created by hacker on 7/15/2016.
 */
public class Solution1 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length ==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i =0; i< n; i++){
            right[i] =n;
        }
        int[] height = new int[n];
        int maxA =0;

        for(int i =0; i<m; i++){
            int cur_left=0, cur_right=n;
            for(int j=0; j<n; j++) {
                if (matrix[i][j] =='1')
                    height[j]++;
                else
                    height[j] =0;
            }

            for(int j=0; j<n; j++) { // compute left (from left to right)
                if(matrix[i][j]=='1')
                    left[j]= Math.max(left[j],cur_left);
                else{
                    left[j]=0;
                    cur_left=j+1;
                }
            }

            for(int j=n-1; j>=0; j--) {
                if(matrix[i][j]=='1')
                    right[j]=Math.min(right[j],cur_right);
                else {
                    right[j]=n;
                    cur_right=j;
                }
            }

            // compute the area of rectangle (can do this from either side)
            for(int j=0; j<n; j++)
                maxA = Math.max(maxA,(right[j]-left[j])*height[j]);
        }

        return maxA;
    }

    public static void main(String[] argv){
        Solution1 s1 = new Solution1();
        char[][] matrix = {
                {'0', '0', '0', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '1', '0', '0'},
                {'0', '1', '1', '1', '1', '1', '0'}
        };

        int area = s1.maximalRectangle(matrix);
        System.out.println(area);
    }
}
