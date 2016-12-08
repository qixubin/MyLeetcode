package com.qxb.leetcode._132;

import java.util.ArrayList;
import java.util.List;

/**

 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 * Created by qxb on 2016/12/6.
 */
public class Solution {

    public int minCut(String s) {

        int n = s.length();
        int[] cut = new int[n+1];  // number of cuts for the first k characters
        for (int i = 0; i <= n; i++)
            cut[i] = i-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j)==s.charAt(i+j) ; j++) // odd length palindrome
            {
                int k = i + j + 1;
                int m = i - j;
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);
            }

            for (int j = 1; i-j+1 >= 0 && i+j < n && s.charAt(i-j+1)==s.charAt(i+j) ; j++) // even length palindrome
            {
                int k = i + j + 1;
                int m = i - j + 1;
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
            }
        }
        return cut[n];
    }

    public static void main(String[] args){
        Solution so = new Solution();

        String s = "aabbb";
        System.out.println(so.minCut(s));
    }
}
