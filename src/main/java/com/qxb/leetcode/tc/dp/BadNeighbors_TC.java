package com.qxb.leetcode.tc.dp;

import java.util.Arrays;

/**
 * Created by qixubin on 2016/6/4.
 */
public class BadNeighbors_TC {
    int[][] cache;

    public static void main(String[] argv){
        BadNeighbors_TC btc = new BadNeighbors_TC();
        int[] nums0 = { 10, 3, 2, 5, 7, 8 }; //19
        int[] nums1 = { 11, 15 };// 15
        int[] nums2 = { 7, 7, 7, 7, 7, 7, 7 }; //21
        int[] nums3 = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };  //16
        int[] nums4 = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72}; //2926

        int[] nums5 ={162, 964, 975, 847, 31, 472, 61, 903, 713, 392, 798, 937, 378, 994, 969, 310, 924,
                766, 529, 422, 786, 844, 746, 428, 332, 832, 280, 233, 609, 744, 165, 635, 335, 655, 414, 661, 686, 374, 739, 599};//13227

        int[] nums6 = 	{349, 187, 672, 268, 750, 926, 787, 578, 784, 795, 991, 9, 416, 981,
                355, 840, 850, 501, 53, 794, 712, 740, 833, 113, 401, 285, 952, 422, 535, 532, 102};//10170

        int[] nums7 = 	{90, 1, 2, 89, 3, 4, 88, 5, 6, 87, 5, 4, 86, 3, 2, 85, 1, 2};//525

        System.out.println(btc.maxDonations(nums0));
//        System.out.println(btc.maxDonations(nums1));
//        System.out.println(btc.maxDonations(nums2));
//        System.out.println(btc.maxDonations(nums3));
//        System.out.println(btc.maxDonations(nums4));
//        System.out.println(btc.maxDonations(nums5));
//        System.out.println(btc.maxDonations(nums6));
//        System.out.println(btc.maxDonations(nums7));
    }

    public int maxDonations(int[] donations) {
        cache=new int[2][donations.length];
        Arrays.fill(cache[0],-1);
        Arrays.fill(cache[1],-1);
        return Math.max(max(donations,2,true)+donations[0],max(donations,1,false));
    }

    public int max(int[] donations, int where, boolean onegave){
        if(where==donations.length)
            return 0;
        if(where==donations.length-1
                && onegave)
            return 0;
        else if(where==donations.length-1)
            return donations[where];
        if(cache[onegave?1:0][where]!=-1)
            return cache[onegave?1:0][where];
        return cache[onegave?1:0][where]=Math.max(max(donations,where+1,onegave),max(donations,where+2,onegave)+donations[where]);
    }


}
