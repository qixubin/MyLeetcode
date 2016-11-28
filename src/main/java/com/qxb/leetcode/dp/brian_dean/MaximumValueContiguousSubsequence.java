package com.qxb.leetcode.dp.brian_dean;

/**
 * Created by hacker on 8/9/2016.

 Given a sequence of n real numbers A(1) ... A(n), determine a contiguous subsequence A(i) ... A(j) for which the sum of elements in the subsequence is maximized.

 */
public class MaximumValueContiguousSubsequence {

    public void maxSub(int[] A){

        int len = A.length;
        int maxSum = 0;
        int runningSum = A[0];
        int j = 0;
        int start=0, finish=0;

        for (int i=1; i<len; i++) {
            if (runningSum > 0) {
                runningSum += A[i];
            } else {
                runningSum = A[i];
                j = i;
            }
            if (runningSum > maxSum) {
                maxSum = runningSum;
                start = j;
                finish = i;
            }
        }
        System.out.println("Max Sum: " + maxSum);
        System.out.println("Indices: i=" + start + ": j=" + finish);
    }

    public static void main(String[] args){
        MaximumValueContiguousSubsequence so = new MaximumValueContiguousSubsequence();
        int[] seq = {1,2,3,-4, -2, 3,4,5, -3, 8, 9};
        so.maxSub(seq);



    }
}
