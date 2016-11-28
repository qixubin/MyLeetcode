package com.qxb.leetcode.tc.dp;

import java.util.StringTokenizer;

/**
 * Created by qixubin on 2016/6/13.

 Problem Statement
 Problem contains images. Plugin users can view them in the applet.

 In the city, roads are arranged in a grid pattern. Each point on the grid represents a corner where two blocks meet.
 The points are connected by line segments which represent the various street blocks.
 Using the cartesian coordinate system, we can assign a pair of integers to each corner as shown below.




 You are standing at the corner with coordinates 0,0. Your destination is at corner width,height.
 You will return the number of distinct paths that lead to your destination.
 Each path must use exactly width+height blocks. In addition, the city has declared certain street blocks untraversable.
 These blocks may not be a part of any path. You will be given a String[] bad describing which blocks are bad.
 If (quotes for clarity) "a b c d" is an element of bad, it means the block from corner a,b to corner c,d is untraversable.
 For example, let's say
 width  = 6
 length = 6
 bad = {"0 0 0 1","6 6 5 6"}
 The picture below shows the grid, with untraversable blocks darkened in black. A sample path has been highlighted in red.

 Definition

 Class:	AvoidRoads
 Method:	numWays
 Parameters:	int, int, String[]
 Returns:	long
 Method signature:	long numWays(int width, int height, String[] bad)
 (be sure your method is public)

 Constraints
 -	width will be between 1 and 100 inclusive.
 -	height will be between 1 and 100 inclusive.
 -	bad will contain between 0 and 50 elements inclusive.
 -	Each element of bad will contain between 7 and 14 characters inclusive.
 -	Each element of the bad will be in the format "a b c d" where,
 a,b,c,d are integers with no extra leading zeros,
 a and c are between 0 and width inclusive,
 b and d are between 0 and height inclusive,
 and a,b is one block away from c,d.
 -	The return value will be between 0 and 2^63-1 inclusive.

 *
 */
public class AvoidRoads {

    public static long numWays(int width, int height, String[] bad){
        boolean[][] left_blocked = new boolean[width+1][height+1];
        boolean[][] down_blocked = new boolean[width+1][height+1];
        long[][] ways = new long[width+1][height+1];

        for ( int i =0 ; i < height+1; i++){
            left_blocked[0][i] = true;
        }

        for ( int i =0 ; i < width+1; i++){
            down_blocked[i][0] = true;
        }

        for (String s : bad){
            mark(s, left_blocked, down_blocked);
        }

        for(int i = 0; i < width+1; i++){
            for (int j = 0; j < height+1; j++){
                if ( i ==0 && j==0){
                    ways[i][j] = 1;
                    continue;
                }

                if (left_blocked[i][j]){
                    if (down_blocked[i][j]){
                        ways[i][j]=0;
                    }else{
                        ways[i][j]=ways[i][j-1];
                    }

                }else{
                    if (down_blocked[i][j]){
                        ways[i][j]=ways[i-1][j];
                    }else{
                        ways[i][j]=ways[i][j-1]+ ways[i-1][j];
                    }
                }
            }
        }

        return ways[width][height];
    }

    public static void mark(String s , boolean[][] left_blocked, boolean[][] down_blocked){
        StringTokenizer st  = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()){
            int a_x = Integer.parseInt(st.nextToken());
            int a_y = Integer.parseInt(st.nextToken());
            int b_x = Integer.parseInt(st.nextToken());
            int b_y = Integer.parseInt(st.nextToken());

            if (( a_x + a_y) > (b_x + b_y)){
                if (a_x == b_x){ //  a is upon b
                    down_blocked[a_x][a_y] = true;
                }else{  //a is  right side of b
                    left_blocked[a_x][a_y] = true;
                }

            }else{
                if (a_x == b_x){// b  is upon a
                    down_blocked[b_x][b_y] = true;
                }else{
                    left_blocked[b_x][b_y] = true;
                }
            }
        }

    }
    public static void main(String[] argc){

//        int width = 6;
//        int height = 6;
//        String[] bad = new String[2];
//        bad[0]= "0 0 0 1";
//        bad[1]= "6 6 5 6";

//        int width = 1;
//        int height = 1;
//        String[] bad = new String[0];

//        int width = 35;
//        int height = 31;
//        String[] bad = new String[0];

        int width = 2;
        int height = 2;
        String[] bad = new String[3];
        bad[0]= "0 0 1 0";
        bad[1]= "1 2 2 2";
        bad[2]= "1 1 2 1";

        System.out.println(numWays(width, height, bad));
    }

}
