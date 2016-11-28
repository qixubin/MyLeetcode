package com.qxb.leetcode._89;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 7/25/2016.
 */
public class Solution1 {
    public List<Integer> grayCode(int n) {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << i;
            for (int j = arr.size() - 1; j >= 0; j--) {
                arr.add(arr.get(j) + inc);
            }
        }
        return arr;
    }

    public static void main(String[] args){
        Solution1 s1 = new Solution1();

        List<Integer> li =s1.grayCode(3);
        for(int i:li){
            System.out.println(Integer.bitCount(i));
        }
    }
}
