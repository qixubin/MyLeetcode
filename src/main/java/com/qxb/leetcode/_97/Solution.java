package com.qxb.leetcode._97;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by hacker on 7/28/2016.

 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.


 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int len_1  = s1.length();
        int len_2 = s2.length();
        if (len_1 + len_2 != s3.length()) return false;

        boolean[][] steps = new boolean[len_1+1][len_2+1];
        steps[0][0] = true;

        LinkedList<Point> llist = new LinkedList<Point>();
        llist.offer(new Point(0,0));

        while(llist.size()>0){
            Point p = llist.poll();
            int x = p.x;
            int y = p.y;

            if ((x + y) > (s3.length()-1)) return true;
            char c = s3.charAt(x+y);

            if (x <s1.length() && s1.charAt(x) == c){
                if( steps[x+1][y] ==true){

                }else{
                    steps[x+1][y] = true;
                    llist.offer(new Point(x+1, y));
                }
            }

            if (y < s2.length() && s2.charAt(y) ==c){
                if( steps[x][y+1] ==true){

                }else{
                    steps[x][y+1] = true;
                    llist.offer(new Point(x, y+1));
                }
            }



        }

        return steps[len_1][len_2];
    }

    public static void main(String[] args){
        Solution so = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";
        boolean res = so.isInterleave(s1, s2, s3);
        boolean res2 = so.isInterleave(s1, s2, s4);
        System.out.println(res);
        System.out.println(res2);
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}
