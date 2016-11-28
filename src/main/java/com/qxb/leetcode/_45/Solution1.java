package com.qxb.leetcode._45;

/**
 * Created by qixubin on 2016/5/31.
 */
public class Solution1 {
    public int jump(int[] nums) {
        if (nums.length ==1)
            return 0;

        int start_index =0;
        int reach =0;
        int count =0;
        while(start_index < nums.length){
            int step = nums[start_index];
            if (start_index + step >= nums.length-1){
                count++;
                break;
            }else{

            }

            for (int i  = 1; i <=step; i++){
                if ( start_index +i <nums.length && nums[start_index +i]!=0){
                    int longest = nums[start_index +i] + start_index+i;
                    if (longest > reach){
                        reach = longest;
                    }
                }
            }

            start_index = start_index + reach;
            count +=2;
            if  (start_index >=nums.length-1){
                break;
            }
        }

        return count;
    }

    public static void main(String[] argv){
        Solution1 s1 = new  Solution1();
        int[] nums = {2,4,1,1,4,1};

        int[] nums1 = {1,2};
        int[] nums2 = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(s1.jump(nums2));
    }
}
