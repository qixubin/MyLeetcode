package com.qxb.leetcode._50;

/**
 * Created by hacker on 6/28/2016.
 */
public class Solution {
    public double myPow(double x, int n) {
        double ans= 1;
        for(long i = Math.abs((long)n); i > 0; i = i >> 1, x *=x)
            if((i & 1) == 1) ans *= x;
        return n > 0 ? ans : 1/ans;


    }


    public static void main(String[] argc){
        Solution s1 = new Solution();
        System.out.println(s1.myPow(2.0, 3));
        System.out.println(s1.myPow(34.00515,-3));
        System.out.println(s1.myPow(0.00001, 2147483647));
        System.out.println(s1.myPow(-13.62608, 3));
    }


}
