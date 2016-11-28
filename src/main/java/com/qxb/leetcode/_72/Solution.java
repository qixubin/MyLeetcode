package com.qxb.leetcode._72;

/**
 * Created by hacker on 7/5/2016.

 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character

 */
public class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dis= new int[m+1][n+1];

        for(int i =0; i <=m; i++){
            dis[i][0]=i;
        }

        for(int i =0; i <=n; i++){
            dis[0][i]=i;
        }

        for(int i =1; i<=m; i++){
            System.out.println();
            for(int j=1; j<=n; j++){
                int d1 = dis[i-1][j]+1;
                int d2 = dis[i][j-1]+1;
                int d3 = dis[i-1][j-1];

                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    d3 = d3+1;
                }


                dis[i][j] = Math.min(Math.min(d1,d2), d3);

            }
        }

        return dis[m][n];
    }



    public static void main(String[] argv){
        Solution so = new Solution();
        String a = "intention";
        String b = "execution";
        System.out.println(so.minDistance(a,b));
    }
}
