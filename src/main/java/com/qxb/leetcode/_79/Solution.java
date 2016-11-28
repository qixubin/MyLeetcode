package com.qxb.leetcode._79;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 7/13/2016.

 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];



        return helper(board, visited, word, 0, 0);
    }

    public boolean helper(char[][] board, boolean[][] visited, String word, int index, int prevCord){
        int m = board.length;
        int n = board[0].length;

        List<Integer> li_next = findNex(board, visited, word, index, prevCord);
        if (li_next.size() ==0){
            return false;
        }else if(index == word.length()-1){
            return true;
        }
        for(int i= 0; i< li_next.size(); i++){
            int k = li_next.get(i);
            int k_m = k/n;
            int k_n = k%n;

            visited[k_m][k_n] = true;
            boolean find =helper(board, visited, word, index+1,k);
            if (find)
                return true;
            visited[k_m][k_n] = false;
        }

        return false;
    }

    public List<Integer> findNex(char[][] board, boolean[][] visited, String word, int index, int prevCord){
        char c = word.charAt(index);
        int m = board.length;
        int n = board[0].length;

        ArrayList<Integer> res = new ArrayList<>();
        if (index ==0){
            for(int i = 0 ;i<m; i++){
                for(int j=0; j<n; j++){
                    if (board[i][j] ==c){
                        res.add(i*n+j);
                    }
                }
            }
        }else{
            int mm= prevCord / n;
            int nn = prevCord % n;
            if (mm+1< m && board[mm+1][nn]==c && !visited[mm+1][nn]){
                res.add(n*(mm+1) +nn);
            }
            if (mm-1>=0 && board[mm-1][nn]==c && !visited[mm-1][nn]){
                res.add(n*(mm-1) +nn);
            }
            if (nn+1< n && board[mm][nn+1]==c && !visited[mm][nn+1]){
                res.add(n*mm + nn+1);
            }
            if (nn-1>=0 && board[mm][nn-1]==c && !visited[mm][nn-1]){
                res.add(n*mm + nn-1);
            }
        }
        return res;
    }

    public static void main(String[] argv){

        char[][] board =  {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
//        String word = "ABCCED";
//        String word = "SEE";
        String word = "ABCB";

        Solution so = new Solution();
        System.out.println(so.exist(board, word));
    }

}
