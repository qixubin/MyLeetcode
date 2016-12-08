package com.qxb.leetcode._132;

import java.util.Arrays;

/**
 * Created by qxb on 2016/12/6.
 */
public class Solution1 {

    public int minCut(String s) {

        if (s == null || s.length() == 0) return 0;
        //Initiation
        int length = s.length();

        boolean[][] palindrome = new boolean[length][length];

//        for (int i = 0; i < length; i++)
//            Arrays.fill(palindrome[i], false);

        int[] results = new int[length];
        //Start looping
        for (int start = length - 1; start >= 0; start--) {
            results[start] = length - start - 1;//Worst case:need length-start-i cuts
            for (int end = start; end < length; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start < 2)//Refer to these two cases: xx OR xyx
                        palindrome[start][end] = true;
                    else //Depends on the inner substring,if the inner substring is palindrome,the outer is
                        palindrome[start][end] = palindrome[start + 1][end - 1];
                }
                if (palindrome[start][end])
                    if (end == length - 1)
                        results[start] = 0;
                    else
                        results[start] = Math.min(results[start], results[end + 1] + 1);
            }
        }
        return results[0];
    }

    public static void main(String[] args){
        Solution1 s1 = new Solution1();

        String s = "aaabbcdc";
        System.out.println(s1.minCut(s));
    }
}
