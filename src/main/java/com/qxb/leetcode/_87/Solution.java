package com.qxb.leetcode._87;

import java.util.Arrays;

/**
 * Created by hacker on 7/22/2016.

 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t

 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t

 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a

 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1

 */
public class Solution {

    public boolean isScramble(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 != l2) return false;
        if (l1 == 1) return s1.equals(s2);
        char[] st1 = s1.toCharArray();
        char[] st2 = s2.toCharArray();
        Arrays.sort(st1);
        Arrays.sort(st2);

        for (int i = 0; i < l1; ++i) {
            if (st1[i] != st2[i]) {
                return false;
            }
        }

        String s11, s12, s21, s22;
        boolean res = false;
        for (int i = 1; i < l1 && !res; ++i) {
            s11 = s1.substring(0, i);
            s12 = s1.substring(i, l1);
            s21 = s2.substring(0, i);
            s22 = s2.substring(i, l1);
            res = isScramble(s11, s21) && isScramble(s12, s22);
            if (!res) {
                s21 = s2.substring(0, l1 - i);
                s22 = s2.substring(l1 - i, l1);
                res = isScramble(s11, s22) && isScramble(s12, s21);
            }
        }
        return res;
    }
}
