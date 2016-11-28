package com.qxb.leetcode._67;

import java.util.ArrayList;

/**
 * Created by hacker on 7/2/2016.

 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 */
public class Solution {

    public String addBinary(String a, String b) {
        char[] a_c = a.toCharArray();
        char[] b_c = b.toCharArray();

        int len_a = a.length();
        int len_b = b.length();

        if(len_a ==0) return b;
        if(len_b ==0) return a;

        ArrayList<String> res = new ArrayList<String>();
        int forward =0;
        int a_index = len_a-1;
        int b_index = len_b-1;
        while( a_index >=0 || b_index >=0){
            int sum =0;
            int ia = 0;
            int ib = 0;
            if (a_index >=0 && b_index >=0){
                 ia =  Integer.valueOf(a.substring(a_index,a_index+1));
                 ib =  Integer.valueOf(b.substring(b_index,b_index+1));
            }else if (a_index >=0){
                ia =  Integer.valueOf(a.substring(a_index,a_index+1));
            }else{
                ib =  Integer.valueOf(b.substring(b_index,b_index+1));
            }
            a_index--;
            b_index--;

            sum = ia + ib + forward;
            if (sum ==3){
                res.add("1");
                forward =1;
            }else if (sum ==2){
                res.add("0");
                forward =1;
            }else if (sum ==1){
                res.add("1");
                forward =0;
            }else{
                res.add("0");
                forward =0;
            }

        }
        if (forward==1) res.add("1");

        StringBuffer sb= new StringBuffer();
        for (int i =res.size()-1; i>=0; i --){
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] argv){
        Solution so = new Solution();

        String res = so.addBinary("1", "111");

        System.out.println(res);
    }
}
