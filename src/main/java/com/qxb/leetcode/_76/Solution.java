package com.qxb.leetcode._76;

import java.util.Arrays;

/**
 * Created by hacker on 7/12/2016.
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"

 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 */


// my solution can't handle duplicate chars in t,  e.g. s= "aa" t="aa"
public class Solution {
    public String minWindow(String s, String t) {
        int t_len = t.length();
        int[] index = new int[t_len];
        for (int i =0; i< t_len; i++){
            index[i] =-1;
        }
        int start =-1;
        int end =-1;
        int startIndex =-1;
        int endIndex =-1;

        int count =0;
        int minSize =s.length();

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            int ind = t.indexOf(c);
            if (ind >=0){
                if (start ==-1){
                    start =i;
                }
                end =i;

                int prev = index[ind];
                if (prev==-1){
                    count++;
                    index[ind] =i;
                    if (count ==t_len){
                        minSize = end -start +1;
                        startIndex = start;
                        endIndex = end;
                    }
                    continue;
                }

                if (count ==t_len){
                    int curChrIndex = index[ind];

                    if (curChrIndex == start){

                        start = findNext(index);
                        index[ind] =i;

                        if((i-start +1) <minSize){
                            minSize = i-start+1;
                            startIndex = start;
                            endIndex = end;
                        }
                    }else{
                        index[ind] =i;
                    }

                }
            }

        }

        if (startIndex != -1){
            return s.substring(startIndex,endIndex+1);
        }
        return "";
    }

    public int findNext(int[] index){
        int[] copy = Arrays.copyOf(index, index.length);
        Arrays.sort(copy);
        return copy[1];
    }

    public static void main(String[] argv){
        Solution so = new Solution();
        int[] nums = {0,9,5};
        System.out.println(so.findNext(nums));


        String a ="ADOBECODEBANC";
        String b ="ABC";
        String c = so.minWindow(a,b);
        System.out.println(c);


        String d = "abc";
//        System.out.println(d.replace());


    }
}
