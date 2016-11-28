package com.qxb.leetcode._65;

/**
 * Created by hacker on 7/2/2016.
 Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true

 Note: It is intended for the problem statement to be ambiguous.
 You should gather all requirements up front before implementing one.

 Update (2015-02-10):
 The signature of the C++ function had been updated.
 If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */


// 0-9   48-57
public class Solution {
    public boolean isNumber(String s) {
        if (s==null) return false;

        s =s.trim();
        if (s.equals("")) return false;

        if (s.charAt(0) =='-' || s.charAt(0)=='+')
            s=s.substring(1);

        if (s.contains("e")){
            int i = s.indexOf('e');
            int i_dot = s.indexOf('.');
            int i_add = s.indexOf('+');
            int i_minus = s.indexOf('-');

            if (i_dot>i || i_dot ==i-1 || i_add >i+1 || i_minus > i+1)
                return false;

            if (i==0 || i==s.length()-1)
                return false;
            else
                s = s.substring(0, i) + s.substring(i+1, s.length());
        }

        if (s.contains(".")){
            int i = s.indexOf('.');
            int i_e = s.indexOf('e');

            if (i_e > i+1)
                return false;
            s = s.substring(0, i) + s.substring(i+1, s.length());
        }

        if (s.equals("")) return false;



        for(int i =0; i< s.length(); i++){
            int c = (int)s.charAt(i);
            if   (  c <48
                 || c >57)
                return false;
        }

        return true;
    }

    public static void main(String[] argv){

//        System.out.println(" a c ".trim());
//        System.out.println("123".indexOf('-'));
//        System.out.println(".1".contains("."));
//        System.out.println("12345".substring(0,2) + "12345".substring(3,5));
        Solution so = new Solution();

        System.out.println(so.isNumber("123"));
        System.out.println(so.isNumber(".123"));
        System.out.println(so.isNumber("."));
        System.out.println(so.isNumber("-1."));
        System.out.println(so.isNumber(".e1"));
        System.out.println(so.isNumber(".1e1"));
    }
}
