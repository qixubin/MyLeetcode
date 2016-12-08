package com.qxb.leetcode._134;

/**

 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.

 * Created by qxb on 2016/12/8.
 */
public class Solution {

    // time limit exceeded
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int[] diff = new int[len];
        for(int i = 0; i < len; i++){
            diff[i] = gas[i] - cost[i];
        }

        for(int i = 0; i< len; i++){
            boolean found = false;
            int left = 0;
            for(int j =0; j < len; j++){
                int mod= (i+j)%len;
                left  += diff[mod];
                if (left <0)
                    break;
                if (j == len-1){
                    found = true;
                }
            }
            if (found) return i;
        }

        return -1;
    }

    //leetcode solution
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int start = 0,total = 0, tank = 0;


        //if car fails at 'start', record the next station
        for(int i=0;i<gas.length;i++) {
            if ((tank = tank + gas[i] - cost[i]) < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return (total+tank<0)? -1:start;
    }

    public static void main(String[] args){

        int[] gas = {1,2,2};
        int[] cost = {2,1,3};

        Solution so = new Solution();
        System.out.println(so.canCompleteCircuit1(gas, cost));
    }
}
