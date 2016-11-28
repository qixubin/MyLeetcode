package com.qxb.leetcode.tc.dp;

/**
 * Created by qixubin on 2016/6/3.
 *
 * Given a sequence of N numbers – A[1] , A[2] , …, A[N] . Find the length of the longest non-decreasing sequence.
 */
public class MaxNonDecreaseSeq {

    public int getResult(int[] nums){
        int result =1;
        int len = nums.length;
        int[] seq = new int[len];
        for (int i = 0; i < len; i++){
            seq[i] =1;
        }

        for (int i  =1; i < len; i++){
            for (int j=0; j <i ; j++){
                if (nums[j] <= nums[i]  && seq[j] +1 > seq[i])
                {
                    seq[i] = seq[j] +1;
                }
            }
            result = seq[i] > result? seq[i]:result;
        }
        return result;
    }

    public static  void main(String[] argc){
        int[] nums = {5, 3, 4, 8,6,7};
        MaxNonDecreaseSeq m1 = new MaxNonDecreaseSeq();
        System.out.println(m1.getResult(nums));



    }

}
