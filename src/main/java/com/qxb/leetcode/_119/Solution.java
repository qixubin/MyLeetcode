package com.qxb.leetcode._119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hacker on 8/1/2016.

 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?

 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {


        Integer[] resArr = new Integer[rowIndex+1];
        for(int i =0; i< rowIndex+1; i++){
            resArr[i] =0;
        }
        resArr[0] =1;

        if (rowIndex ==0) return Arrays.asList(resArr);

        for(int i =1; i <= rowIndex; i++){
            for(int j = i; j >0; j--){
                resArr[j] = resArr[j-1] + resArr[j];
            }
        }


        return Arrays.asList(resArr);
    }

    public static void main(String[] args){
        Solution so = new Solution();
        List<Integer> res = so.getRow(0);
        System.out.println(res.size());
    }

}
