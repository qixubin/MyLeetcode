package com.qxb.leetcode._88;

/**
 * Created by hacker on 7/25/2016.

 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.

 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n ==0) return;

        for(int j = m+n-1; j>=0 &&m>0 && n>0 ; j--){

            if (nums1[m-1] > nums2[n-1]){
                nums1[j] = nums1[m-1];
                m--;
            }else{
                nums1[j] = nums2[n-1];
                n--;
            }
        }

        if (n >0){
            for(int k =0; k<n; k++){
                nums1[k] = nums2[k];
            }
        }
    }
}
