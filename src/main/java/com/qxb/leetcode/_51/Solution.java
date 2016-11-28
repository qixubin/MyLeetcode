package com.qxb.leetcode._51;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 6/28/2016.
 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();

        char[] dots = new char[n];
        for (int i =0; i<n; i++){
            dots[i]='.';
        }
        String dot  = new String(dots);
//        System.out.println(dot);

        List<String> so = new ArrayList<String>();
        for(int i =0; i< n; i++){

            putQueen(so, 0, i, dot,result);
        }
        return result;
    }

    public String puts(String dot, int index){

        return dot.substring(0,index) +"Q" + dot.substring(index+1, dot.length());
    }

    public void putQueen(List<String> li, int row, int column, String dot,List<List<String>> result){
        if (li.size()> row){
            int k  = li.size();

            for(int i =0; i< k-row;i++){
                li.remove(li.size()-1);
            }
        }

        int n = dot.length();

        li.add(puts(dot, column));

        if (row ==n-1){
            ArrayList<String> oneSolution= new ArrayList<String>();
            oneSolution.addAll(li);
            result.add(oneSolution);

        }else {

//            boolean found = false;
            for (int i = 0; i < n; i++) {

                if (isAvailable(li, row + 1, i)) {
//                    found = true;
//                    ArrayList<String> nli = new ArrayList<String>();
//                    nli.addAll(li);
                    putQueen(li, row + 1, i, dot, result);
                }
            }

//            if (!found) {
//                li.remove(li.size() - 1);
//            }
        }

    }
    public boolean isAvailable(List<String> li, int row, int column){
        int n = li.get(0).length();
        for(int i = 0; i <row; i++){
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
        List<List<String>> lls = s1.solveNQueens(5);

//        String dot = "abcd";
//        int index = 3;
//        int n = dot.length();
//        dot = dot.substring(0,index) +"Q" + dot.substring(index+1, n);
//        System.out.println(dot);

        for (int i  = 0; i <lls.size(); i++){
            List<String> ls = lls.get(i);
            for(int ii =0; ii < ls.size(); ii ++){
                System.out.println(ls.get(ii));
            }
            System.out.println("");
        }
        System.out.println(lls.size());
    }
}
