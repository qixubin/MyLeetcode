package com.qxb.leetcode.tc.dp;

/**
 * Created by qixubin on 2016/6/4.
 */
public class ZigZag_TC {

    public static int longestZigZag(int[] nums){
        if (nums.length ==1)
            return 1;
        int[] v = new int[nums.length-1];
        for (int i =1; i< nums.length; i++){
            v[i-1]= nums[i]-nums[i-1];
        }
        int ii =0;
        while(ii < v.length && v[ii]==0)
            ii++;

        if (ii==v.length)
            return 1;

        int dir = v[ii];
        int len =2;
        for( int i =ii+1; i < v.length; i++){
            if(v[i] * dir < 0)
            {
                dir *= -1;
                len++;
            }
        }
        return len;
    }

//    c++ code
//    int longestZigZag(vector <int> sequence)
//    {
//        if(sequence.size() == 1) return 1;
//        vector<int> v(sequence.size()-1);
//        for(int i=1;i<sequence.size();i++)
//        {
//            v[i-1] = sequence[i] - sequence[i-1];
//        }
//        //    dir is first nonzero
//        int ii=0;
//        while( ii < v.size() && v[ii] == 0)
//            ii++;
//        if(ii == v.size()) return 1;
//        int dir = v[ii];
//        int len = 2;
//        for(int i=ii+1;i<v.size();i++)
//        {
//            if(v[i] * dir < 0)
//            {
//                dir *= -1;
//                len++;
//            }
//        }
//        return len;
//    }

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

        System.out.println(longestZigZag(nums0));
        System.out.println(longestZigZag(nums1));
        System.out.println(longestZigZag(nums2));
        System.out.println(longestZigZag(nums3));
        System.out.println(longestZigZag(nums4));
        System.out.println(longestZigZag(nums5));
    }
}
