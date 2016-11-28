package com.qxb.leetcode._52;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 6/29/2016.
 */
public class Solution {

    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();

        char[] dots = new char[n];
        for (int i =0; i<n; i++){
            dots[i]='.';
        }
        String dot  = new String(dots);
//        System.out.println(dot);

        for(int i =0; i< n; i++){
            List<String> so = new ArrayList<String>();
            putQueen(so, 0, i, dot,result);
        }
        return result.size();
    }


    public String puts(String dot, int index){

        return dot.substring(0,index) +"Q" + dot.substring(index+1, dot.length());
    }

    public void putQueen(List<String> li, int row, int column, String dot,List<List<String>> result){
        int n = dot.length();

        li.add(puts(dot, column));

        if (row ==n-1){
            result.add(li);

        }else {

            for (int i = 0; i < n; i++) {

                if (isAvailable(li, row + 1, i)) {

                    putQueen(li, row + 1, i, dot, result);
                    li.remove(li.size() - 1);
                }
            }
        }

    }
    public boolean isAvailable(List<String> li, int row, int column){
        int n = li.get(0).length();
        for(int i = 0; i < li.size(); i++){
            String str = li.get(i);
            int j= str.indexOf('Q');
            if (j ==column){
                return false;
            }
            if( Math.abs(row-i) == Math.abs(column-j)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] argv){
        Solution s1 =  new Solution();
        int result = s1.totalNQueens(5);

//        String dot = "abcd";
//        int index = 3;
//        int n = dot.length();
//        dot = dot.substring(0,index) +"Q" + dot.substring(index+1, n);
//        System.out.println(dot);

        System.out.println(result);
    }
}
