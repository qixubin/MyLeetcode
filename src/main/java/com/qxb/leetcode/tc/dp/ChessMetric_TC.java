package com.qxb.leetcode.tc.dp;

/**
 * Created by qixubin on 2016/6/13.
 */


public class ChessMetric_TC {
    public long howMany(int n, int[] start, int[] end, int num) {
        int [] dx = new int [] {1, 0, -1, 0, 1, -1, -1, 1, -2, -2, -1, -1, 1, 1, 2, 2};
        int [] dy = new int [] {0, 1, 0, -1, 1, 1, -1, -1, -1, 1, -2, 2, -2, 2, -1, 1};

        long ways[][] = new long[n][n];
        ways[start[0]][start[1]] = 1;
        for (int i = 0; i < num; i ++ ) {
            long tmp[][] = new long [n][n];
            for (int ia = 0; ia < n; ia ++ ) for (int ib = 0; ib < n; ib ++ )
                tmp[ia][ib] = ways[ia][ib];
            for (int ia = 0; ia < n; ia ++ ) for (int ib = 0; ib < n; ib ++ )
                ways[ia][ib] = 0;
            for (int ia = 0; ia < n; ia ++ ) for (int ib = 0; ib < n; ib ++ )
                for (int dir = 0; dir < dx.length; dir ++ ) {
                    int nx = ia + dx[dir], ny = ib + dy[dir];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        ways[nx][ny] += tmp[ia][ib];
                    } /* end if */
                } /* end for */
        }
        return ways[end[0]][end[1]];
    } // end of method howMany

    public static void main(String[] argc){
        ChessMetric_TC ctc = new ChessMetric_TC();
//        int size = 3;
//        int[] start = {0,0};
//        int[] end = {0,0};
//        int numMoves = 2;

        int size = 100;
        int[] start = {0,0};
        int[] end = {0,99};
        int numMoves = 50;

        long startTime = System.currentTimeMillis();
        System.out.println(ctc.howMany(size, start, end, numMoves));
        System.out.println("Time consumption " + (System.currentTimeMillis()-startTime) + " ms.");
    }
}
