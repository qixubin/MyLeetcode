package com.qxb.leetcode.tc.dp;

/**
 * Created by qixubin on 2016/6/4.

 A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate between positive and negative.
 The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a zig-zag sequence.

 For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
 In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences are positive and the second because its last difference is zero.

 Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag sequence.
 A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
 */
public class ZigZag {
    public static int getSeq(int[] nums){
        int result =0;
        int len = nums.length;
        if (len ==1)
            result =1;

        int[] pos_seq = new int[len];
        int[] neg_seq = new int[len];
//        int[] pos = new int[len];
//        int[] neg = new int[len];
        for (int i =0; i< len; i++){
            pos_seq[i] =1;
            neg_seq[i] =1;
        }

        for ( int i =1; i< len; i++){
            for (int j =0; j <i; j++){
                if (nums[i] > nums[j]){  // greater than previous j
                    if (neg_seq[j]+1 >pos_seq[i]){
                        pos_seq[i] = neg_seq[j]+1;
                    }
                }else if(nums[i] == nums[j]){  // equal previous j
                    if (neg_seq[j]>neg_seq[i]){
                        neg_seq[i] = neg_seq[j];
                    }
                    if (pos_seq[j] > pos_seq[i]){
                        pos_seq[i] = pos_seq[j];
                    }
                }else{//less than previous j
                    if (pos_seq[j]+1 >neg_seq[i]){
                        neg_seq[i] = pos_seq[j]+1;
                    }
                }
            }

            result = pos_seq[i]>result?pos_seq[i]:result;
            result = neg_seq[i]>result?neg_seq[i]:result;
        }


        return result;
    }

    public static void main(String[] argc){
        int[] nums0 = { 1, 7, 4, 9, 2, 5 };   //7
        int[] nums1 = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }; //7
        int[] nums2 = { 44 };  //1
        int[] nums3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  //2
        int[] nums4 = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }; //8
        int[] nums5 = {  374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244};  //36

        System.out.println(getSeq(nums0));
        System.out.println(getSeq(nums1));
        System.out.println(getSeq(nums2));
        System.out.println(getSeq(nums3));
        System.out.println(getSeq(nums4));
        System.out.println(getSeq(nums5));
    }
}


