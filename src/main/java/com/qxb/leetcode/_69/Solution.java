package com.qxb.leetcode._69;

/**
 * Created by hacker on 7/5/2016.
 Implement int sqrt(int x).

 Compute and return the square root of x.

 */
public class Solution {
    public int mySqrt(int x) {
        if(x==1) return 1;
        int start = x/2;
        while(!isClose(x, start)){

            start = improve(x, start);
        }

        return start;
    }

    public int improve(int x , int start){

        int roat = x/start;
        if (roat == start+1)
            return roat;

        return (start + roat)/2;
    }

    public boolean isClose(int x, int start){
        if (start * start == x)
            return true;

        if (start >46340)
            return false;

//        if (start == 46340)
//            return true;
//
        if (start * start > x)
            return false;
//
//        if( (start +1) * (start +1) <x)
//            return false;

        return true;
    }

    public static void main(String[] argv){
        Solution so = new Solution();

//        System.out.println(so.mySqrt(1));

//        System.out.println(so.mySqrt(2147395600));

//        System.out.println(Math.sqrt(2147483647));
        System.out.println(so.mySqrt(2147483647));
        System.out.println(so.mySqrt(100));
        System.out.println(so.mySqrt(200));


    }
}
