package com.qxb.leetcode._130;

/**
 * Created by qxb on 2016/12/2.
 */
public class Solution {

    //no way out...., the direction is correct, but you need to walk a little more steps to find the way
    public void solve(char[][] board) {
        int row = board.length;
        if (row==0) return;
        int col = board[0].length;

        if (row<=2 || col<=2)
            return;

        int i , j;
        for(i=0;i<row;i++){
            check(board,i,0,row,col);
            if(col>1)
                check(board,i,col-1,row,col);
        }
        for(j=1;j+1<col;j++){
            check(board,0,j,row,col);
            if(row>1)
                check(board,row-1,j,row,col);
        }

        for(i=0;i<row;i++)
            for(j=0;j<col;j++)
                if(board[i][j]=='O')
                    board[i][j]='X';
        for(i=0;i<row;i++)
            for(j=0;j<col;j++)
                if(board[i][j]=='L')
                    board[i][j]='O';
    }

    public void check(char[][] board, int x, int y, int height, int weight){
        if (board[x][y] == 'O'){
            board[x][y] = 'L';
            if (x > 1){
                check(board, x-1, y,height, weight);
            }
            if (y > 1){
                check(board, x, y-1, height, weight);
            }

            if(x+1<height)
                check(board,x+1,y,height,weight);
            if(y+1<weight)
                check(board,x,y+1,height,weight);

        }
    }

    public static void main(String[] args){

        char[][] board = new char[][]{
                                    {'X','X','X','X'},
                                    {'X','O','O','X'},
                                    {'X','X','O','X'},
                                    {'X','O','X','X'}
                                    };

        Solution so = new Solution();
        so.solve(board);

        for (int i = 0; i < board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
