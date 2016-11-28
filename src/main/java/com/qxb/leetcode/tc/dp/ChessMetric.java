package com.qxb.leetcode.tc.dp;

/**
 * Created by qixubin on 2016/6/13.
 *
 Suppose you had an n by n chess board and a super piece called a kingknight.
 Using only one move the kingknight denoted 'K' below can reach any of the spaces denoted 'X' or 'L' below:
 .......
 ..L.L..
 .LXXXL.
 ..XKX..
 .LXXXL.
 ..L.L..
 .......
 In other words, the kingknight can move either one space in any direction (vertical, horizontal or diagonally) or can make an 'L' shaped move.
 An 'L' shaped move involves moving 2 spaces horizontally then 1 space vertically or 2 spaces vertically then 1 space horizontally.
 In the drawing above, the 'L' shaped moves are marked with 'L's whereas the one space moves are marked with 'X's.
 In addition, a kingknight may never jump off the board.



 Given the size of the board, the start position of the kingknight and the end position of the kingknight,
 your method will return how many possible ways there are of getting from start to end in exactly numMoves moves.
 start and finish are int[]s each containing 2 elements.
 The first element will be the (0-based) row position and the second will be the (0-based) column position.
 Rows and columns will increment down and to the right respectively. The board itself will have rows and columns ranging from 0 to size-1 inclusive.



 Note, two ways of getting from start to end are distinct if their respective move sequences differ in any way.
 In addition, you are allowed to use spaces on the board (including start and finish) repeatedly during a particular path from start to finish.
 We will ensure that the total number of paths is less than or equal to 2^63-1 (the upper bound for a long).

 Constraints
 -	size will be between 3 and 100 inclusive
 -	start will contain exactly 2 elements
 -	finish will contain exactly 2 elements
 -	Each element of start and finish will be between 1 and size-1 inclusive
 -	numMoves will be between 1 and 50 inclusive
 -	The total number of paths will be at most 2^63-1.

 */
public class ChessMetric {
    public static long howMany(int size, int[] start, int[] end, int numMoves){
        long[][] ways = new long[size][size];

        ways[start[0]][start[1]] =1;

        for( int i =1; i <= numMoves; i++){
            long[][] next_ways = new long[size][size];
            for( int m =0; m < size; m++){
                for ( int n =0; n < size; n++){
                    next_ways[m][n] = calculate(ways, m, n);
                }
            }
            ways = next_ways;
        }

        return ways[end[0]][end[1]];
    }

    public static long calculate(long[][] ways, int m , int n){
        int size = ways.length;
        long result =0;

        for (int i = -2; i <=2; i++){
            for (int j = -2; j <=2; j++){
                if  (
                        ( i%2 ==0 ) && (j%2 ==0)
                        ){
                    continue;
                }else{
                    if  (((m+i) >=0 && (m+i) < size) && ((n+j) >=0 && (n+j) < size)){
                        result += ways[m+i][n+j];
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] argc){
//        int size = 3;
//        int[] start = {0,0};
//        int[] end = {1,0};
//        int numMoves = 1;
//        return 1

//        int size = 3;
//        int[] start = {0,0};
//        int[] end = {1,2};
//        int numMoves = 1;
//      return 1

//        int size = 3;
//        int[] start = {0,0};
//        int[] end = {2,2};
//        int numMoves = 1;
//      return 0

//        int size = 3;
//        int[] start = {0,0};
//        int[] end = {0,0};
//        int numMoves = 2;
//      return 5

        int size = 100;
        int[] start = {0,0};
        int[] end = {0,99};
        int numMoves = 50;
//      return 243097320072600

        long startTime = System.currentTimeMillis();
        System.out.println(howMany(size, start, end, numMoves));
        System.out.println("Time consumption " + (System.currentTimeMillis()-startTime) + " ms.");
    }

}
