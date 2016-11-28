package com.qxb.leetcode._84;

import java.util.Stack;

/**
 * Created by hacker on 7/15/2016.
 */
public class Solution1 {
    //solution 1
    public int largestRectangleArea(int[] height) {
        if (height==null) return 0;//Should throw exception
        if (height.length==0) return 0;

        Stack<Integer> index= new Stack<Integer>();
        index.push(-1);
        int max=0;

        for  (int i=0;i<height.length;i++){
            //Start calculate the max value
            while (index.peek()>-1)
                if (height[index.peek()]>height[i]){
                    int top=index.pop();
                    max=Math.max(max,height[top]*(i-1-index.peek()));
                }else break;

            index.push(i);
        }
        while(index.peek()!=-1){
            int top=index.pop();
            max=Math.max(max,height[top]*(height.length-1-index.peek()));
        }
        return max;
    }

    //solution 2
    public int largestRectangleArea_2(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    //solution 3
    public int largestRectangleArea_3(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return getMax(heights, 0, heights.length);
    }
    int getMax(int[] heights, int s, int e) {
        if (s + 1 >= e) return heights[s];
        int min = s;
        boolean sorted = true;
        for (int i = s; i < e; i++) {
            if (i > s && heights[i] < heights[i - 1]) sorted = false;
            if (heights[min] > heights[i]) min = i;
        }
        if (sorted) {
            int max = 0;
            for (int i = s; i < e; i++) {
                max = Math.max(max, heights[i] * (e - i));
            }
            return max;
        }
        int left = (min > s) ? getMax(heights, s, min) : 0;
        int right = (min < e - 1) ? getMax(heights, min + 1, e) : 0;
        return Math.max(Math.max(left, right), (e - s) * heights[min]);
    }

    public static void main(String[] argv){
        Solution1 so = new Solution1();
        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {0,2,0};

//        int[] heights = {2,1,4,5,1,3,3};
//        int[] heights = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(so.largestRectangleArea(heights));
    }

}
