package com.qxb.leetcode._115;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hacker on 7/30/2016.

 Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.

 */
public class Solution {
    public int numDistinct(String s, String t) {
//        return helper(s, t);
        if (s.length() < t.length()) return 0;
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<Character, ArrayList<Integer>>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (hm.containsKey(c)){
                hm.get(c).add(i);
            }else{
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(i);
                hm.put(c,al);
            }
        }

        return helperHM(s,-1,t, hm);
    }

    //my solution 2
    public int helperHM(String s, int startIndex, String t, HashMap<Character, ArrayList<Integer>> hm){
        if(t.length() ==0){
            return 1;
        }else{
            char c = t.charAt(0);
            ArrayList<Integer> ali = hm.get(c);
            if (ali ==null) return 0;
            int res =0;
            for(int k : ali){
                if (k>startIndex){
                    res += helperHM(s, k,t.substring(1), hm);
                }
            }
            return res;
        }
    }

    //my first solution
    public int helper(String s, String t){

        if(t.length() ==0){
            return 1;
        }else{
            char c = t.charAt(0);

            int index = s.indexOf(c);
            if(index ==-1){
                return 0;
            }else{
                return helper(s.substring(index+1), t.substring(1)) + helper(s.substring(index+1), t);
            }

        }
    }


    public static void main(String[] args){
        Solution so= new Solution();
//        int[] res = new int[1];
//        so.helper("", "" , res);
//        System.out.println(res[0]);
        String s = "rabbbit";
        String t = "rabbit";


        s = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
        t = "bddabdcae";

        s = "b";
        t = "a";
        int res = so.numDistinct(s,t);

        System.out.println(res);
    }

}
