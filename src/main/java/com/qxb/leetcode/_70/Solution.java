package com.qxb.leetcode._70;

/**
 * Created by hacker on 7/5/2016.

 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */
public class Solution {

    public int climbStairs(int n) {
        if (n ==1) return 1;
        if (n==2) return 2;
        int[] ways = new int[n+1];
        ways[1] = 1;
        ways[2] = 2;


        int res = helper(ways, n);
        return res;
    }

    public int helper(int[] ways, int n){
        if (ways[n] >0){

        }else{
            ways[n] = helper(ways, n-1) + helper(ways,n-2);
        }
        return ways[n];
    }

    public static void main(String[] argc){
        Solution so = new Solution();

        System.out.println(so.climbStairs(10));
        System.out.println(so.climbStairs(5));
        System.out.println(so.climbStairs(3));
        System.out.println(so.climbStairs(1));
    }

}
