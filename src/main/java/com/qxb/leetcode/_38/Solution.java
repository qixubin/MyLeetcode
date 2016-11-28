package com.qxb.leetcode._38;

import java.util.ArrayList;

/**
 * Created by qixubin on 2016/5/27.
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 */
public class Solution {
    public String countAndSay(int n) {
        if (n ==1)
            return "1";

        return say(countAndSay(n-1));
    }

    public String say(String s){
        if (s.length() ==1){
            return "1"+s;
        }

        ArrayList<String> al = split(s);
        StringBuffer sb = new StringBuffer();

        for (String item:al){
            sb.append(item.length() +item.substring(0,1));
        }
        return sb.toString();
    }

    public ArrayList<String> split(String s){
        ArrayList<String> result = new ArrayList<String>();
        int len = s.length();

        char prev = s.charAt(0);
        int s_len =0;
        for ( int i =0; i< len; i++){
            if (s.charAt(i) == prev){
                s_len ++;
            }else{
                result.add(multiS(prev, s_len));
                prev = s.charAt(i);
                s_len =1;
            }
        }

        result.add(multiS(prev, s_len));
        return result;
    }

    public String multiS(char c, int n){
        char[] result = new char[n];
        for (int i=0;i<n; i++){
            result[i] = c;
        }
        return new String(result);

    }

    public static void main(String[] argc){
        Solution s1 = new Solution();
//        ArrayList<String> test = s1.split("312211");
//        System.out.println("aa");
        System.out.println(s1.countAndSay(8));
    }
}
