package com.qxb.leetcode._84;

/**
 * Created by hacker on 7/15/2016.

 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.

 */
public class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int maxArea =0;
        for(int i = 0; i < heights.length; i++ ){
            int h = heights[i];
            if (h ==0) continue;
            int width = 1;

            for(int j =i-1 ; j>=0; j--){
                if (heights[j] >= h){
                    width++;
                }else{
                    break;
                }
            }

            boolean close = true;
            for(int k = i+1; k<n; k++){
                if (heights[k] ==h){
                    if (close) i++;
                    width++;

                }else if (heights[k] > h){
                    width++;
                    close = false;
                }else{
                    break;
                }
            }

            int area = h * width;
            if (area >maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] argv){
        Solution so = new Solution();
//        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {0,2,0};

//        int[] heights = {2,1,4,5,1,3,3};
        int[] heights = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(so.largestRectangleArea(heights));

    }
}
