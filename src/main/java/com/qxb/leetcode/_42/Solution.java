package com.qxb.leetcode._42;

import java.util.Arrays;

/**
 * Created by qixubin on 2016/5/30.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 */
public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] realHeight =  new int[len];

        int startIndex =0;
        int endIndex =len;

        for (int i =0; i < len; i ++){
            if (height[i] != 0){
                startIndex = i;
                break;
            }
        }

        for(int j = len -1; j>=0; j--){
            if(height[j] !=0){
                endIndex = j;
                break;
            }
        }
        if (startIndex >= endIndex-1)
            return 0;

        int[] h2 = Arrays.copyOfRange(height,startIndex,endIndex+1);

        int new_length = h2.length;

        int[] leftMax = new int[new_length];
        int max_left = h2[0];
        int[] rightMax = new int[new_length];
        int max_right =h2[new_length-1];
        for(int i =0; i < new_length ; i++){
            if (h2[i] > max_left){
                max_left = h2[i];
            }
            leftMax[i] = max_left;
        }

        for (int j = new_length -1; j >=0; j--){
            if(h2[j]>max_right){
                max_right = h2[j];
            }
            rightMax[j] = max_right;
        }

        int result =0;
        for(int i =0; i < new_length; i++){
            result += Math.min(rightMax[i],leftMax[i]) -h2[i];
        }

        return result;

    }

    public static void main(String[] argv){
        int[] ele = {0,1,0,2,1,0,1,3,2,1,2,1};

        Solution s1 = new Solution();
        System.out.println(s1.trap(ele));

    }

}
