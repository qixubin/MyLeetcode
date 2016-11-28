package com.qxb.leetcode._36;

/**
 * Created by qixubin on 2016/5/25.
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        int size = len/3;

        for(int i = 0; i < len ; i ++){
            if (!checkNine(board[i])){
                return false;
            }
        }

        for(int j = 0; j < len ; j ++){
            char[] col = new char[len];
            for (int i = 0; i < len; i++){
                col[i] = board[i][j];
            }

            if (!checkNine(col)){
                return false;
            }
        }

        for (int i  =0; i < size; i++){
            for (int j =0; j < size; j++){
                char[] col = new char[len];

                for (int m = 0; m < size; m++){
                    for (int n =0; n < size ; n++){
                        col[m*size +n] = board[i*size + m][ j*size +n];
                    }
                }
                if (!checkNine(col)){
                    return false;
                }

            }
        }

        return true;
    }

    public boolean checkNine(char[] set){
        int[] flags = new int[]{0,0,0,0,0,0,0,0,0};
        for (char c : set){
            if (c =='.')
                continue;
            int i  = Integer.parseInt(new Character(c).toString()) -1;
            flags[i]++;

            if (flags[i] >1)
                return false;
        }
        return true;
    }


    public static void main(String[] argv){
        char a = '9';
//        System.out.println(a);
//        System.out.println(Integer.parseInt(new Character(a).toString()) +1);
    }
}
