package com.qxb.leetcode._45;

/**
 * Created by qixubin on 2016/5/31.
 */
public class Solution2 {

    public int jump(int[] nums) {
        int i, n = nums.length, lc, ln, step = 1;
        if (n <=1)
            return 0;

        lc = nums[0];
        ln = nums[0];

        for (i = 1; i < n; ++i){
            if (i > lc){
                lc = ln;
                step++;
            }

            if (i + nums[i] > ln) //maintain the furthest distance of next jump can get
                ln = i + nums[i];
            if (lc >= n - 1) //current jump can achieve the last index
                return step;

        }
        return 0;
    }


//    if (n <= 1)
//            return 0;
//    int i, n = nums.size(), lc, ln, step = 1;
//    // lc means the longest distance can achieve by current jump
//    // ln means the longest distance can achieve by next jump
//
//    lc = nums[0], ln = nums[0]; //Initialize to index 0, the start point.
//    for (i = 1; i < n; ++i)
//    {
//        if (i > lc) //current jump cannot get index i -->>> must jump one more time.
//        {
//            lc = ln;
//            step++;
//        }
//        if (i + nums[i] > ln) //maintain the furthest distance of next jump can get
//            ln = i + nums[i];
//        if (lc >= n - 1) //current jump can achieve the last index
//            return step;
//    }

    public static void main(String[] argv){
        Solution2 s2 = new  Solution2();
        int[] nums = {2,3,1,1,4,1};

        int[] nums1 = {1,2};
        int[] nums2 = {5,9,3,2,1,0,2,3,3,1,0,0};

        System.out.println(s2.jump(nums2));
    }
}
