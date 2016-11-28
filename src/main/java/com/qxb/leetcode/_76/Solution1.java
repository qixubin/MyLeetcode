package com.qxb.leetcode._76;

/**
 * Created by hacker on 7/12/2016.
 */
public class Solution1 {

    public String minWindow(String s, String t) {

        int[] map = new int[128];
        for(int i =0; i<t.length(); i++){
            char c = t.charAt(i);
            map[c] ++;
        }
        int counter =t.length();
        int begin =0, end =0;
        int d = Integer.MAX_VALUE;
        int head =0;
        while(end <s.length()){
            char c = s.charAt(end++);
            if (map[c] -- >0)
                counter --;
            while(counter==0){ //valid
                if(end-begin<d)
                    d=end-(head=begin);

                char ccc = s.charAt(begin++);

                if(map[ccc]++==0)
                    counter++;  //make it invalid
            }

        }
        return d==Integer.MAX_VALUE? "":s.substring(head, head+d);
    }

    public static void main(String[] argv){
        Solution1 s1= new Solution1();
        String a ="ADOBECODEBANC";
        String b ="ABC";
        String c = s1.minWindow(a,b);
        System.out.println(c);
    }


}
