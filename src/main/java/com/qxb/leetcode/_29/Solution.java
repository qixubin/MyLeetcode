package com.qxb.leetcode._29;

/**
 * Created by qixubin on 2016/5/16.
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.

 */
public class Solution {

//    public int divide(int dividend, int divisor) {
//
//        if (dividend ==0){
//            return 0;
//        }
//
//        if (dividend == Integer.MIN_VALUE && divisor ==-1){
//            return Integer.MAX_VALUE;
//        }
//
//        if( dividend >0 && divisor >0){
//            return divideHelper(dividend,divisor);
//        }
//
//        if (dividend<0 && divisor <0){
//            return divideHelper(-dividend, -divisor);
//        }
//
//        if (dividend >0 && divisor <0 ){
//            return - divideHelper(dividend, -divisor);
//        }
//
//        if (dividend <0 && divisor >0 ){
//            return - divideHelper(-dividend, divisor);
//        }
//
//        return 0;
//    }
//
//    public int divideHelper(int a, int b){
//        if (b ==1){
//            return a;
//        }
//        if (b >a){
//            return 0;
//        }
//        return 1 + divideHelper(a-b,b);
//    }

    public int divide(int a, int b) {
        if(a==Integer.MIN_VALUE){
            if(b==-1) return Integer.MAX_VALUE;
        }

        long x = a < 0 ? -(long)a : (long)a;
        long y = b < 0 ? -(long)b : (long)b;

        int res = recurse(x, y, 1);
        if(a < 0 && b < 0) return res;
        if(a < 0 || b < 0) return -res;
        return res;
    }

    public int recurse(long x, long y, int count) {
        if(x <= 0 || count==0) return 0;
        if(y > x) return recurse(x, y >>> 1, count >>> 1); //overshot, so divide and try again.
        else return recurse(x-y, y+y, count+count)+count;
    }

    public static void main(String[] argc){
        Solution s1 = new Solution();

        //System.out.println(s1.divide(8,2));
        //System.out.println(s1.divide(7,2));
        //System.out.println(2147483647/2);
        System.out.println(s1.divide(20,2));

    }
}
