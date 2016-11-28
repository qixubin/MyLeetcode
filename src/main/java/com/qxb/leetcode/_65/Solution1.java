package com.qxb.leetcode._65;

/**
 * Created by hacker on 7/2/2016.
 */
public class Solution1 {

    public boolean isNumber(String s){
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }


    public static void main(String[] argv){

        Solution1 so = new Solution1();

        System.out.println(so.isNumber("123"));
        System.out.println(so.isNumber(".123"));
        System.out.println(so.isNumber("."));
        System.out.println(so.isNumber("-1."));
        System.out.println(so.isNumber(".e1"));
        System.out.println(so.isNumber(".1e1"));
    }
}
