package com.qxb.leetcode._174;

/**
 * Created by qixubin on 2016/5/17.
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid.
 * Our valiant knight (K)
 * was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 other rooms are either empty (0's) or contain magic orbs that increase
 the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

 -2 (K)	-3	    3
 -5	    -10	    1
 10	    30	    -5 (P)


 Notes:

 The knight's health has no upper bound.
 Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        return 0;
    }

//    public int calculateMinimumHP(int[][] dungeon) {
//        int size_m = dungeon.length;
//        int size_n = dungeon[0].length;
//        int step = size_m + size_n -1;
//        int min_value;
//
//        for (int k =0; k< step;k++){
//            for (int i =0; i <size_m; i++){
//                int j = k -i;
//                if (j >=size_n)
//                    continue;
//
//                calcu(i,j,dungeon);
//            }
//        }
//
//
//        return 1-dungeon[size_m-1][size_n-1];
//    }

//    public void calcu(int x, int y, int[][] dungeon){
//        boolean hasLeft =false;
//        int leftValue=0;
//        if (y-1>=0 && y-1>=x){
//            hasLeft = true;
//            leftValue = dungeon[x][y-1];
//        }
//
//        boolean hasUpper = false;
//        int upperValue=0;
//        if (x-1>=0 && y>=x-1){
//            hasUpper = true;
//            upperValue = dungeon[x-1][y];
//        }
//
//
//        if (hasUpper && !hasLeft){
//            dungeon[x][y] +=upperValue;
//        }
//
//        if (!hasUpper && hasLeft){
//            dungeon[x][y] +=leftValue;
//        }
//
//        if (hasUpper && hasLeft){
//            dungeon[x][y] += upperValue>=leftValue?upperValue:leftValue;
//        }
//
//    }

    public static void main(String[] argc){
        int[][] dungeon =  {{-2,-3,3},{-5,-10,1},{10,30,-5}};

//        System.out.println(dungeon.length);
//        System.out.println(dungeon[0].length);
        Solution s1 = new Solution();
        int i = s1.calculateMinimumHP(dungeon);
        System.out.println(i);
    }
}
