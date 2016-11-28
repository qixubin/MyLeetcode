package com.qxb.leetcode._58;

import java.util.StringTokenizer;

/**
 * Created by hacker on 7/1/2016.
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s ==null || s.equals(""))
            return 0;

        int len = s.length();

        int end_index=-1;
        int start_index =0;
        for(int i =len-1; i>=0; i--){
            if (s.substring(i,i+1).equals(" ")){
                continue;
            }else{
                end_index =i;
                break;
            }
        }

        if (end_index==0)
            return 1;

        if (end_index ==-1)
            return 0;

        for(int i =end_index; i>=0; i--){
            if (!s.substring(i,i+1).equals(" ")){
                continue;
            }else{
                start_index =i+1;
                break;
            }

        }

        String result = s.substring(start_index, end_index+1);

        return result.length();
    }

    public static void main(String[] argv){

        Solution so = new Solution();
        String a = "hello wor";
        a= "hello wor  ";
        a = "abcdefg ";
        a = "a";
        a= "";
        a = " ";
//        System.out.println("aa".substring(1,1));
        int i = so.lengthOfLastWord(a);
        System.out.println(i);
    }
}
