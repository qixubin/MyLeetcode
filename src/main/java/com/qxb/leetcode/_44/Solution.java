package com.qxb.leetcode._44;

/**
 * Created by qixubin on 2016/5/31.
 *
 Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false

 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] ws = s.toCharArray();
        char[] wp = p.toCharArray();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j-1] && wp[j-1] == '*';
        for (int i = 1; i <= m; i++)
            dp[i][0] = false;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (wp[j-1] == '?' || ws[i-1] == wp[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else if (wp[j-1] == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
        String a = "abb";
        String b = "*b";
        boolean is= s1.isMatch(a,b);
        System.out.println(is);

    }
}
