package com.qxb.leetcode._89;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hacker on 7/25/2016.

 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2

 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

 */
public class Solution {
    public List<Integer> grayCode(int n) {
        int max = (int) Math.pow(2,n);

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0 ; i <= n; i++){
            hm.put(i, new ArrayList<Integer>());
        }

        for (int i =0 ; i < max; i++){
            int bitCount = Integer.bitCount(i);
            hm.get(bitCount).add(i);
        }

        int[] count = new int[n+1];
        int[] index = new int[n+1];
        for(int i = 0; i<=n; i++){
            count[i] = hm.get(i).size();
        }

        List<Integer> res = new ArrayList<Integer>();

        int currentBitCount =0;
        for(int i =0; i<max;i++){
            res.add(hm.get(currentBitCount).get(index[currentBitCount]));
            index[currentBitCount] ++;

            int left = currentBitCount -1;
            int right = currentBitCount +1;

            if (left >=0 && index[left] < count[left]){
                currentBitCount--;
                continue;
            }

            if( right <=n && index[right] < count[right]){
                currentBitCount++;
            }
        }

        return res;
    }

    public static void main(String[] args){
        Solution so = new Solution();

        List<Integer> li =so.grayCode(3);
        for(int i:li){
            System.out.println(Integer.bitCount(i));
        }
    }
}
