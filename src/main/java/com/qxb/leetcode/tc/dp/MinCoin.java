package com.qxb.leetcode.tc.dp;

/**
 * Created by qixubin on 2016/6/1.
 *
 * Given a list of N coins, their values (V1, V2, … , VN),
 * and the total sum S. Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want),
 * or report that it’s not possible to select coins in such a way that they sum up to S.
 *
 */
public class MinCoin {

    public static int min_step(int[] coins, int target){
        int len = target;
        int N = coins.length;

        int[] min = new int[len+1];
        for (int i= 0 ; i < len+1; i++){
            min[i] =Integer.MAX_VALUE;
        }
        min[0] =0;

        for (int i =1; i <= target; i++){
            for (int j =0; j<=N-1; j++){
                if ( coins[j] <=i  &&  min[i-coins[j]] +1 < min[i]){
                    min[i] = min[i-coins[j]] +1;
                }
            }
        }

        return min[target];
    }

    public static void main(String[] argv){

        int[] coins = {1,3,5};
        int target =11;
        int aa = min_step(coins, target);
        System.out.println(aa);

    }
}
