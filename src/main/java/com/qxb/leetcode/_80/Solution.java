package com.qxb.leetcode._80;

import java.util.ArrayList;

/**
 * Created by hacker on 7/13/2016.

 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        ArrayList<Pair> al = new ArrayList<Pair>();

        int count =0;
        int totalCount =0;

        int prev=0;
        for(int i =0; i < nums.length; i++){
            if(i==0){
                prev = nums[i];
                count++;
            }else{
                if ( prev == nums[i]){
                    count++;
                }else {
                    al.add(new Pair(prev, count));
                    if (count >1){
                        totalCount+=2;
                    }else{
                        totalCount+=1;
                    }
                    prev = nums[i];
                    count =1;
                }
            }
        }

        al.add(new Pair(prev, count));
        if (count >1){
            totalCount+=2;
        }else{
            totalCount+=1;
        }

        int start =0;
        for(Pair pair: al){
            if (pair.count ==1){
                nums[start++] = pair.num;
            }else{
                nums[start++] = pair.num;
                nums[start++] = pair.num;
            }
        }
        return  totalCount;
    }

    public static void main(String[] argv){
        Solution so = new Solution();

        int[] nums = {1,1,1,2,2,3};
        int re = so.removeDuplicates(nums);
        System.out.println(re);
    }
}

class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num= num;
        this.count = count;
    }
}
