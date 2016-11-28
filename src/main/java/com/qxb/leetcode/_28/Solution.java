package com.qxb.leetcode._28;

/**
 * Created by qixubin on 2016/5/16.
 *
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


 */
public class Solution {

    public int strStr(String haystack, String needle) {
        int l_needle = needle.length();
        int l_haystack = haystack.length();

        if (l_needle > l_haystack){
            return -1;
        }

        for( int i = 0; i<=l_haystack- l_needle; i++ ){
            if (haystack.substring(i,i+l_needle).equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] argc){
        System.out.println("--"+"abc".substring(0,1));

        Solution s1 = new Solution();
        String a = "aaa";
        String b = "aa";
        System.out.println(s1.strStr(a,b));
    }
}
