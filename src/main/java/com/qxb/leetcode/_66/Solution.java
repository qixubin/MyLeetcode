package com.qxb.leetcode._66;

import java.util.ArrayList;

/**
 * Created by hacker on 7/2/2016.

 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 */
public class Solution {

    public int[] plusOne(int[] digits) {

        int[] res;
        ArrayList<Integer> li = new ArrayList<>();
        int len = digits.length;
        int forward =1;

        for(int i = len-1; i>=0; i--){
            int n = digits[i] + forward;
            if (n==10){
                li.add(0);
                forward =1;
            }else{
                li.add(n);
                forward =0;
            }
        }

        int start =0;
        if (forward >0){
            res = new int[len+1];
            res[0] =1;
            start =1;
        }else{
            res = new int[len];
        }

        for (int i = start; i < res.length; i++){
            res[i] = li.get(res.length -1-i);
        }

        return res;
    }


    public static void main(String[] argv){
        Solution so = new Solution();

        int[] input = {9,9,9};

        int[] res = so.plusOne(input);
        System.out.println("");
    }
}
