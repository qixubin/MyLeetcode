package com.qxb.leetcode._37;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qixubin on 2016/5/25.
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the character '.'.
 * <p>
 * You may assume that there will be only one unique solution.
 */
public class Solution {

    public void solveSudoku(char[][] board) {
        char[][] init = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                init[i][j] =  board[i][j];
            }
        }

        int n =-1;
        boolean backward = false;
        while (true){
            if (backward) {
                int i = n / 9;
                int j = n % 9;

                char c = board[i][j];
                int num = char2int(c);

                if (init[i][j] != '.'){
                    n--;
                }else{
                    ArrayList<Integer> pv = findPossible(board,i,j);
                    if (pv.size() == 1) {
                        board[i][j] ='.';
                        n--;
                        backward = true;
                    }else{
                        if (num == pv.get(pv.size() - 1)) {
                            board[i][j] = '.';
                            n--;
                            backward = true;
                        }else{
                            board[i][j] = int2char(pv.get(pv.indexOf(num) + 1));
                            backward =false;
                        }
                    }
                }
            } else {
                if (n ==80)
                    return;
                int x = (n + 1) / 9;
                int y = (n + 1) % 9;
                char next_c = board[x][y];

                if (next_c == '.') {
                    ArrayList<Integer> next_pv = findPossible(board,x,y);
                    if (next_pv.size() ==0){
                        backward = true;
                    }else{
                        board[x][y] = int2char(next_pv.get(0));
                        n++;
                        backward = false;
                    }

                } else {
                    n++;
                    backward = false;
                }

            }
        }
    }

    public Integer char2int(char c) {
        return Integer.parseInt(new Character(c).toString());
    }

    public char int2char(int i) {
        return new Integer(i).toString().charAt(0);
    }

    public ArrayList<Integer> findPossible(char[][] board, int i, int j) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        for (int k = 0; k < 9; k++) {
            if (k==i)
                continue;
            char c = board[k][j];
            if (c != '.') {
                arr.remove(char2int(c));
            }
        }

        for (int m = 0; m < 9; m++) {
            if (m==j)
                continue;
            char c = board[i][m];
            if (c != '.') {
                arr.remove(char2int(c));
            }
        }

        int x = i / 3;
        int y = j / 3;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if((x * 3 + m ==i) && (y * 3 + n ==j)){
                    continue;
                }
                char c = board[x * 3 + m][y * 3 + n];
                if (c != '.') {
                    arr.remove(char2int(c));
                }
            }
        }


        return arr;
    }

    public static void main(String[] argv) {
        Solution s1 = new Solution();
//        System.out.println(Math.pow(2,4));
//        System.out.println(s1.isPower(0));
//
//        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
//        arr.remove(new Integer(2));
//        arr.remove(new Integer(2));
//        System.out.println("11");
        char[][] nums = new char[9][9];
        nums[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        nums[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        nums[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        nums[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        nums[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        nums[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        nums[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        nums[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        nums[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};

//        ArrayList al = s1.findPossible(nums, 1,0);
//        System.out.println(al);
        s1.solveSudoku(nums);

        for (int i =0; i <9 ; i++){
            for (int j =0; j < 9; j ++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
//        System.out.println(80/9);
//        System.out.println(80%9);
//
//        String[]  a = new String[2];
//        //int[] b = new  int[2];
//        ArrayList[][] c = new ArrayList[9][8];
//        System.out.println(a.getClass());
//        System.out.println(c.getClass());
    }
}
