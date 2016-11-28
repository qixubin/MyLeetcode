package com.qxb.leetcode._75;

/**
 * Created by hacker on 7/11/2016.

 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?

 */
public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int beginIndex =0;
        int oneIndex =-1;
        int endIndex = n-1;

        while(beginIndex <= endIndex){
            if (nums[beginIndex] ==0 &&oneIndex ==-1){
                beginIndex ++;
            }else if (nums[beginIndex] ==1 && oneIndex>-1){
                beginIndex ++;
            }else if(nums[beginIndex] ==1 && oneIndex ==-1){
                oneIndex = beginIndex++;
            }else if (nums[beginIndex] ==0 && oneIndex >-1){
                swap(nums, beginIndex++, oneIndex++);
            }else if (nums[beginIndex] ==2) {
                if (nums[endIndex] ==2){
                    endIndex--;
                }else if(nums[endIndex] ==0){
                    if(oneIndex ==-1){
                        swap(nums, beginIndex++,endIndex--);
                    }else{
                        swap(nums, beginIndex, endIndex);
                        swap(nums, beginIndex, oneIndex);
                        beginIndex++;
                        oneIndex++;
                        endIndex--;
                    }
                }else if(nums[endIndex]==1){
                    swap(nums, beginIndex, endIndex);
                    if (oneIndex ==-1) oneIndex =beginIndex;
                    beginIndex++;
                    endIndex--;
                }
            }
        }

    }

    public void swap(int[] nums, int m, int n){
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

    public static void main(String[] argc){
        int[] nums = {1,1,1,2,2,0,0,0,2,2,1,0,1,1,0,0,0,0,2,2};
        Solution so = new Solution();

        so.sortColors(nums);

        for(int i =0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
    }
}
